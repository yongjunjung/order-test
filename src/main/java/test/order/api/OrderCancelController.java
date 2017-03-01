package test.order.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.order.domain.dto.billing.BillingReturnDto;
import test.order.service.BillingService;
import test.order.service.OrderSerivce;

/**
 * Created by yongjunjung on 2017. 2. 26..
 */

@RestController
public class OrderCancelController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BillingService billingService;

    @Autowired
    OrderSerivce orderSerivce;

    @RequestMapping(value = "order/cancel")
    public void orderCancel(@RequestBody BillingReturnDto returnDto) {

        logger.info("OrderCancelController Start!");

        orderSerivce.cancelOrder(returnDto.getServiceTradeNo());


    }
}
