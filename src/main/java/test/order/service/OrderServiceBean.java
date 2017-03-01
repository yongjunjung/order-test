package test.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.order.common.OrderStatusCode;
import test.order.common.exception.OrderRuntimeException;
import test.order.domain.Order;
import test.order.domain.OrderDetail;
import test.order.domain.Payment;
import test.order.domain.dto.OrderRequestDetailDto;
import test.order.domain.dto.OrderRequestDto;
import test.order.domain.dto.PaymentDto;
import test.order.domain.dto.billing.BillingCancelDto;
import test.order.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static test.order.common.OrderStatusCode.*;
import static test.order.common.OrderStatusCode.ORDER_CANCEL;

/**
 * Created by yongjunjung on 2017. 2. 24..
 *
 * 1. 유효성 체크를 한다.
 *  - 고객이 주문한 메뉴가 주문가능한지
 *  - 현재 업소가 운영중인지
 *
 * 2. 주문을 생성한다.
 *  - 주문번호를 생성한다. 주문번호는 중복되어서는 안된다.
 *  - 주문
 *      - 금액 = 주문상세 금액의 합
 *      - 할인 = 주문상세 할인의 합
 *      - 결제금액 = 결제상세의 합
 *      - 결제금액 = 주문금액 - 할인금액

 */

@Service
public class OrderServiceBean implements OrderSerivce {

    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    BillingService billingService;
    @Autowired
    OrderRepository orderRepository;

    @Transactional
    @Override
    public String createOrder(OrderRequestDto orderRequest) {

        //todo 주문번호 랜덤생성기능
        String orderNo = String.valueOf(new Date().getTime());

        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setAmount(orderRequest.getAmount());
        order.setDiscountAmount(orderRequest.getDiscountAmount());
        order.setUserId(orderRequest.getUserId());
        order.setTelNo(orderRequest.getTelNo());
        order.setOrderTelNo(orderRequest.getOrderTelNo());
        order.setAddress(orderRequest.getAddress());
        order.setOrderType(orderRequest.getOrderType());
        order.setRequestMessage(orderRequest.getRequestMessage());
        order.setServiceId(orderRequest.getServiceId());

        //주문상세정보입력
        List<OrderRequestDetailDto> requestDetailList = orderRequest.getOrderDetails();
        for (OrderRequestDetailDto requestDetail : requestDetailList) {
            OrderDetail orderDetail = orderDetailService.buildOrderDetail(requestDetail);
            orderDetail.setOrderDetailNo(orderNo);
            order.addOrderDetail(orderDetail);
        }

        //결제정보입력
        PaymentDto paymentDto = orderRequest.getPayment();
        Payment payment = paymentService.buidPayment(paymentDto);
        payment.setOrderNo(orderNo);

        order.setPayment(payment);
        return create(order);
    }

    private String create(Order order) {
        orderRepository.save(order);
        return order.getOrderNo();
    }

    @Transactional
    @Override
    public void processOrderWait(String orderNo) {
        Order order = orderRepository.findByOrderNo(orderNo);
        order.setStatus(ORDER_WAIT);

        List<OrderDetail> orderDetailList = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetail.setStatus(ORDER_WAIT);
        }
    }

    //하나의 트랜잭션에서 처리한다.
    @Transactional
    @Override
    public void cancelOrder(String orderNo) {

        Order waitOrderNo = orderRepository.findWaitByOrderNo(orderNo);

        if (waitOrderNo == null) {
            throw new OrderRuntimeException("50000", "취소가 불가합니다.");
        }

        Payment payment = waitOrderNo.getPayment();

        BillingCancelDto cancelDto = new BillingCancelDto(waitOrderNo.getServiceId(), payment.getOrderNo(), payment.getBillingTradeNo(), payment.getPayAuthToken());

        billingService.cancel(cancelDto);

        waitOrderNo.setStatus(ORDER_CANCEL);

    }
}
