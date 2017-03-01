package test.order.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.order.domain.dto.billing.BillingResult;
import test.order.domain.dto.billing.BillingReturnDto;
import test.order.service.BillingService;
import test.order.service.OrderSerivce;
import test.order.service.PaymentService;

import static test.order.domain.dto.billing.BillingReturnStatus.*;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Controller
public class OrderReturnController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PaymentService paymentService;
    @Autowired
    BillingService billingService;
    @Autowired
    OrderSerivce orderSerivce;

    @ResponseBody
    @RequestMapping(value = "/order/return", method = RequestMethod.POST)
    public BillingResult orderReturn(BillingReturnDto returnDto) {

        logger.info("orderReturn!!");
        logger.info("requestParam={}", returnDto.toString());

        //todo 여기서 매니저 테이블에 넣어줄까?
        paymentService.updateBillingApprove(returnDto);

        billingService.approve(returnDto);

        //todo 업데이트 db
        orderSerivce.processOrderWait(returnDto.getServiceTradeNo());



        //주문중개
        //예약대신
        //브로스


        return new BillingResult(OK);
    }
}
