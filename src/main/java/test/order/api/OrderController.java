package test.order.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.order.common.config.CommonConfig;
import test.order.common.exception.ClientRuntimeException;
import test.order.common.exception.OrderRuntimeException;
import test.order.domain.Order;
import test.order.domain.dto.OrderRequestDto;
import test.order.domain.dto.OrderRequestResult;
import test.order.domain.dto.PaymentDto;
import test.order.domain.dto.billing.BillingRequestResult;
import test.order.repository.OrderRepository;
import test.order.service.BillingService;
import test.order.service.OrderSerivce;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2017. 3. 1..
 */

@Controller
public class OrderController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CommonConfig config;
    @Autowired
    OrderSerivce orderSerivce;
    @Autowired
    BillingService billingService;
    @Autowired
    OrderRepository orderRepository;

    /**
     * Created by yongjunjung on 2017. 3. 1.
     * 주문생성
     * 클라이언트 -> 주문시스템 초기 주문을 생서하는 단계
     */
    @ResponseStatus(CREATED)
    @ResponseBody
    @PostMapping("/order/request")
    public OrderRequestResult orderRequest(@Valid @RequestBody OrderRequestDto orderRequestDto) throws Exception {

        //1.검증
        validateRequest(orderRequestDto);

        //2.주문생성
        String orderNo = orderSerivce.createOrder(orderRequestDto);

        //3.반환
        return new OrderRequestResult(config.getPaymentUrl()+"/"+orderNo);
    }

    @ResponseStatus(CREATED)
    @ResponseBody
    @PostMapping("/order/payment/{orderNo}")
    public OrderRequestResult orderPaymentRequest(@PathVariable("orderNo") String orderNo) throws Exception {

        BillingRequestResult billingRequestResult = billingService.request(orderNo);

        //빌링요청이 실패하면 오류
        if (billingRequestResult.isFail()) {
            throw new OrderRuntimeException(billingRequestResult.getCode(), billingRequestResult.getMessage());
        }

        //3.반환
        return new OrderRequestResult(billingRequestResult.getRequestUrl());
    }

    /**
     * Created by yongjunjung on 2017. 3. 1.
     * 클라이언트에서 넘어온 데이터의 유효성 체크를 한다
     * 1. 주문금액 = 주문상세 총 합계금액
     * 2. 결제금액 = 주문금액 - 할인금액
     * 3. 결제금액 = 결제상세 총 합계금액
     */
    private void validateRequest(@RequestBody OrderRequestDto orderRequestDto) throws Exception {

        if (!orderRequestDto.getAmount().equals(orderRequestDto.getOrderDetailRequestDtoSum())) {
            logger.info("orderRequestDto.getAmount()={} , sum={}", orderRequestDto.getAmount(), orderRequestDto.getOrderDetailRequestDtoSum());
            throw new ClientRuntimeException("4001", "주문금액합계 불일치");
        }

        PaymentDto paymentDto = orderRequestDto.getPayment();

        if (!orderRequestDto.getPaymentDtoAmount().equals(paymentDto.getAmount())) {
            throw new ClientRuntimeException("4002","주문금액 결제금액 불일치");
        }

        if (!paymentDto.getPaymentDetailDtoAmountSum().equals(paymentDto.getAmount())) {
            throw new ClientRuntimeException("4003","결제금액합계 불일치");
        }
    }

}
