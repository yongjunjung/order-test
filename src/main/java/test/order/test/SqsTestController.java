package test.order.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2017. 2. 20..
 */

@RestController
public class SqsTestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/sqs/test", method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void sqsRequest(@RequestBody Map<String, String> map) {
        logger.info("sqs request = {}", map.toString());
    }
}
