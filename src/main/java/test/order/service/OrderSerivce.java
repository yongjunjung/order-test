package test.order.service;

import test.order.domain.Order;
import test.order.domain.dto.OrderRequestDto;

/**
 * Created by yongjunjung on 2017. 2. 24..*
 */
public interface OrderSerivce {

    String createOrder(OrderRequestDto orderRequestDto);

    void processOrderWait(String orderNo);

    void cancelOrder(String orderNo);


}
