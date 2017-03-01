package test.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import test.order.common.config.BillingConfig;
import test.order.common.config.CommonConfig;
import test.order.common.exception.ErrorReturn;
import test.order.common.exception.OrderRuntimeException;
import test.order.domain.Order;
import test.order.domain.Payment;
import test.order.domain.PaymentDetail;
import test.order.domain.dto.billing.*;
import test.order.repository.OrderRepository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Service
public class BillingService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    BillingConfig billingConfig;
    @Autowired
    CommonConfig commonConfig;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderRepository orderRepository;


    public BillingPayDto buildBillingRequest(String orderNo) {

        //todo 밖에서 데이터 바인딩을 하고 billingpayDto를 입력 받는 것으로 바꿀것
        Order order = orderRepository.findRequestByOrderNo(orderNo);

        BillingPayDto billingPayDto = new BillingPayDto();
        billingPayDto.setServiceId("baropay");
        billingPayDto.setSite("app");
        billingPayDto.setUserId(order.getUserId());
        billingPayDto.setUserName(order.getUserId());
        billingPayDto.setUserEmail("test@woowahan.com");
        billingPayDto.setUserTel(order.getTelNo());
        billingPayDto.setServiceTradeNo(order.getOrderNo());
        billingPayDto.setAmount(order.getOrderPaymentAmount());
        billingPayDto.setUserAddr(order.getAddress());
        billingPayDto.setUserIp("127.0.0.1");
        billingPayDto.setItemName("테스트테스트");
        billingPayDto.setMerchantKey("2222");
        billingPayDto.setResultUrl(commonConfig.getResultUrl(), orderNo);
        billingPayDto.setReturnUrl(commonConfig.getReturnUrl());
        billingPayDto.setCloseUrl("http://betapurch2.baemin.com/billing_bera/order_result");
        billingPayDto.setEtc1("");
        billingPayDto.setEtc2("");
        billingPayDto.setEtc3("");

        List<Map<String, Object>> billingPayDetails = new ArrayList<>();

        Payment payment = order.getPayment();
        List<PaymentDetail> paymentDetailList = payment.getPaymentDetails();
        for (PaymentDetail paymentDetail : paymentDetailList) {
            Map<String, Object> payMethod = new HashMap<>();
            payMethod.put("amount", paymentDetail.getAmount());
            payMethod.put("payMethod", paymentDetail.getPaymentType());
            billingPayDetails.add(payMethod);
        }

        billingPayDto.setPayDetails(billingPayDetails);

        return billingPayDto;
    }

    /**
     * Created by yongjunjung on 2017. 2. 24..
     * 서비스 -> 빌링 결제요청
     */
    @Transactional
    public BillingRequestResult request(String orderNo) throws IOException {

        BillingPayDto billingPayDto = buildBillingRequest(orderNo);

        try {
            BillingRequestReturnDto returnDto = restTemplate.postForObject(billingConfig.getRequestUrl(), setParameter(billingPayDto), BillingRequestReturnDto.class);
            return BillingRequestResult.ok(returnDto.getRequestUrl());

        } catch (HttpClientErrorException hce) {
            ErrorReturn errorReturn = mapper.readValue(hce.getResponseBodyAsString(), ErrorReturn.class);

            logger.error("BillingRequest HttpClientErrorException={}", hce.getResponseBodyAsString());
            return BillingRequestResult.fail(errorReturn.getError().getCode(), errorReturn.getError().getMessage());

        } catch (Exception e) {
            logger.error("BillingRequest HttpClientErrorException={}", e.getMessage());
            return BillingRequestResult.fail("5001", e.getMessage());
        }
    }

    /**
     * Created by yongjunjung on 2017. 2. 24..
     * 서비스 -> 빌링 결제승인요청
     */
    public BillingApproveResult approve(BillingReturnDto returnDto) {

        logger.info("billing approve");

        try {
            BillingApproveResult result = restTemplate.postForObject(billingConfig.getApproveUrl() + "/" + returnDto.getBillingTradeNo(), setParameter(returnDto), BillingApproveResult.class);
            logger.info("approveResult={}", result.toString());
            return result;
        } catch (HttpClientErrorException e) {
            logger.info("result={}", e.getResponseBodyAsString());

        } catch (Exception e) {

        }

        return null;
    }

    /**
     * Created by yongjunjung on 2017. 2. 24..
     * 서비스 -> 빌링 결제취소요청
     */
    public String cancel(BillingCancelDto cancelDto) {

        Map map = restTemplate.postForObject(billingConfig.getCancelUrl() + cancelDto.getTradeNo(), setParameter(cancelDto), Map.class);
        logger.info("cancel Result={}", map.toString());

        return null;
    }

    /**
     * Created by yongjunjung on 2017. 2. 24..
     * 빌링 요청시 헤더 공통정보
     */
    private HttpEntity setParameter(Object object) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        headers.set("Authorization", "Bearer " + billingConfig.getServiceKey());

        try {
            return new HttpEntity<>(new ObjectMapper().writeValueAsString(object), headers);
        } catch (JsonProcessingException e) {
            throw new OrderRuntimeException("5100", "잠시 후 다시 시도해주세요");
        }
    }
}
