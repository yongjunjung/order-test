package test.order.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@RestController
public class OrderResultController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "order/result/{orderNo}")
    public void orderResult(@PathVariable("orderNo") String orderNo,
                            @RequestParam Map<String, String> paramMap) {

        logger.info("orderResultController!!");
        logger.info("orderNo={}", orderNo);
        logger.info("paramMap={}", paramMap.toString());
    }
}
