package test.order.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import test.order.common.OrderStatusCode;
import test.order.domain.Order;
import test.order.domain.QOrder;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class OrderRepositoryImpl extends QueryDslRepositorySupport implements OrderRepositoryCustom {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private final QOrder qOrder = new QOrder("order");

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public Order findRequestByOrderNo(String orderNo) {

        logger.info("findRequestByOrderNo={}", orderNo);

        return from(qOrder)
                .where(qOrder.status.eq(OrderStatusCode.ORDER_REQUEST)
                        , qOrder.orderNo.eq(orderNo)).fetchOne();
    }

    @Override
    public Order findWaitByOrderNo(String orderNo) {
        return from(qOrder)
                .where(qOrder.status.eq(OrderStatusCode.ORDER_WAIT)
                        , qOrder.orderNo.eq(orderNo)).fetchOne();
    }
}
