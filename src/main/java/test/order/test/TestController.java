package test.order.test;

import test.order.domain.Order;
import test.order.domain.OrderDetail;
import test.order.domain.Payment;
import test.order.domain.PaymentDetail;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class TestController {

    public void test() {

        /*
        * 유효성 체크
        *   - 주문번호생성 > 중복주문번호인지 확인
        *   - 스마트메뉴 유효성 체크
        *   - 주문금액 합계체크
        *   - 결제금액 합계체크
        * */

        /*
        * 주문생성
        *   - 주문정보
        *   - 주문상세정보
        *   - 주문메뉴정보
        *   - 결제요청정보
        * */

        String orderNo = "111111111";

        Order order = new Order();
        order.setOrderNo(orderNo);

        //멀티주문인경우 첫번째 업소의 주문
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setShopNo("1");
        order.addOrderDetail(orderDetail);

        //멀티주문인경우 두번째 업소의 주문
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setShopNo("2");
        order.addOrderDetail(orderDetail1);

        //결제요청정보
        Payment payment = new Payment();
        payment.setAmount(3000L);
        payment.setOrderNo(orderNo);

        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setPaymentType("card");
        paymentDetail.setAmount(1000L);
        payment.addPaymentDetail(paymentDetail);

        PaymentDetail paymentDetail1 = new PaymentDetail();
        paymentDetail1.setPaymentType("point");
        paymentDetail1.setAmount(2000L);
        payment.addPaymentDetail(paymentDetail1);



        order.setPayment(payment);
//        orderRepository.save(order);
    }
}
