package test.order.service;

import org.springframework.stereotype.Service;
import test.order.domain.OrderDetail;
import test.order.domain.dto.OrderRequestDetailDto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Service
public class OrderDetailServiceBean implements OrderDetailService {

    @Override
    public OrderDetail buildOrderDetail(OrderRequestDetailDto orderRequestDetailDto) {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setShopNo(orderRequestDetailDto.getShopNo());
        orderDetail.setShopNm(orderRequestDetailDto.getShopNm());
        orderDetail.setShopAddress(orderRequestDetailDto.getShopAddress());
        orderDetail.setShopOwnerNo(orderRequestDetailDto.getShopOwnerNo());
        orderDetail.setAmount(orderRequestDetailDto.getAmount());
        orderDetail.setDiscountAmount(orderRequestDetailDto.getDiscountAmount());
        orderDetail.setOrderTakeType(orderRequestDetailDto.getOrderTakeType());
        orderDetail.setPromotionType(orderRequestDetailDto.getPromotionType());

        return orderDetail;
    }
}
