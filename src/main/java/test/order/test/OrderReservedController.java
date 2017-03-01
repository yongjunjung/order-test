package test.order.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test.order.test.OrderReserved;
import test.order.test.OrderReservedService;
import test.order.test.ReservedDto;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2017. 2. 16..
 */

@RestController
public class OrderReservedController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    OrderReservedService orderReservedService;

    @RequestMapping(value = "/order/reserved/request", method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void reservedRequest(@Valid @RequestBody ReservedDto reservedDto) {

        logger.info("예약정보 ={}", reservedDto.toString());

//        OrderReserved orderReserved = new OrderReserved("1111", "2222");
//        orderReservedService.create(orderReserved);
    }

    @RequestMapping(value = "/order/reserved/confirm/{seq}", method = POST)
    public void reservedConfirm(@PathVariable("seq") Long orderReservedSeq) {

        OrderReserved reserved = orderReservedService.confirm(orderReservedSeq);
        logger.info("confirm Reserved : {}", reserved.toString());
    }


}
