package test.order.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.order.domain.dto.OrderRequestResult;

import test.order.common.exception.ClientRuntimeException;
import test.order.common.exception.OrderRuntimeException;
import test.order.domain.dto.OrderRequestDto;
import test.order.domain.dto.PaymentDto;
import test.order.domain.dto.billing.BillingRequestResult;
import test.order.service.BillingService;
import test.order.service.OrderSerivce;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2017. 2. 23..
 */

@RestController
public class OrderRequestController {


//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    OrderSerivce orderSerivce;
//    @Autowired
//    BillingService billingService;
//
//    @RequestMapping(value = "/order/request", method = POST)
//    public OrderRequestResult orderRequest(@Valid @RequestBody OrderRequestDto orderRequestDto) throws Exception {
//
//        //1.검증
//        validateRequest(orderRequestDto);
//
//        //2.주문생성
//        String orderNo = orderSerivce.createOrder(orderRequestDto);
//
//        BillingRequestResult billingRequestResult = billingService.request(orderNo);
//
//        //빌링요청이 실패하면 오류
//        if (billingRequestResult.isFail()) {
//            throw new OrderRuntimeException(billingRequestResult.getCode(), billingRequestResult.getMessage());
//        }
//
//        //3.반환
//        return new OrderRequestResult(billingRequestResult.getRequestUrl()+"/"+ orderNo);
//    }
//
//    private void validateRequest(@RequestBody OrderRequestDto orderRequestDto) throws Exception {
//
//        if (!orderRequestDto.getAmount().equals(orderRequestDto.getOrderDetailRequestDtoSum())) {
//            logger.info("orderRequestDto.getAmount()={} , sum={}", orderRequestDto.getAmount(), orderRequestDto.getOrderDetailRequestDtoSum());
//            throw new ClientRuntimeException("4001", "주문금액합계 불일치");
//        }
//
//        PaymentDto paymentDto = orderRequestDto.getPayment();
//
//        if (!orderRequestDto.getPaymentDtoAmount().equals(paymentDto.getAmount())) {
//            throw new ClientRuntimeException("4002","주문금액 결제금액 불일치");
//        }
//
//        if (!paymentDto.getPaymentDetailDtoAmountSum().equals(paymentDto.getAmount())) {
//            throw new ClientRuntimeException("4003","결제금액합계 불일치");
//        }
//    }
}
