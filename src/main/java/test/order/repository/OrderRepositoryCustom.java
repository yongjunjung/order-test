package test.order.repository;

import test.order.domain.Order;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public interface OrderRepositoryCustom {

    Order findRequestByOrderNo(String orderNo);

    Order findWaitByOrderNo(String orderNo);
}
