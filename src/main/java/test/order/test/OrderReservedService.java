package test.order.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by yongjunjung on 2017. 2. 16..
 */

@Service
public class OrderReservedService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    OrderReservedRepository orderReservedRepository;

    @Transactional
    public Long create(OrderReserved orderReserved) {

        OrderReserved reserved = orderReservedRepository.findByOrderNo(orderReserved.getOrderNo());
        if (reserved == null) {
            orderReservedRepository.save(orderReserved);

        }

        throw new IllegalStateException("이미 예약요청된 주문입니다.");
    }

    @Transactional
    public OrderReserved confirm(Long orderReservedSeq) {
        OrderReserved reserved = orderReservedRepository.findOne(orderReservedSeq);
        logger.info("findOne Reserved : {}", reserved.toString());
        reserved.setStatus(ReservedStatus.CONFIRM);
        return reserved;
    }

}
