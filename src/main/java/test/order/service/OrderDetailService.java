package test.order.service;

import test.order.domain.OrderDetail;
import test.order.domain.dto.OrderRequestDetailDto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public interface OrderDetailService {

    OrderDetail buildOrderDetail(OrderRequestDetailDto orderRequestDetailDto);
}
