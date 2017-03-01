package test.order.domain;

import test.order.common.AbstractTimestamp;
import test.order.common.OrderStatusCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongjunjung on 2017. 2. 23..
 */
@Entity
@Table(name = "baemin_order")
public class Order extends AbstractTimestamp {

    @Id
    @GeneratedValue
    private Long orderSeq;
    private String orderNo;
    private Long amount;
    private Long discountAmount;
    private OrderStatusCode status;
    private String userId;
    private String telNo;
    private String orderTelNo;
    private String Address;
    private String orderType;               //바로결제, 만나서결제, 예약결제
    private String requestMessage;
    private String serviceId;               //배민닷컴 , 배달의민족, 배민라이더스
    private String modifyId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    //결제정보
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_seq")
    private Payment payment;

    public Order() {
        setStatus(OrderStatusCode.ORDER_REQUEST);
        setModifyId("");
    }

    public Long getOrderPaymentAmount() {
        return this.amount - this.discountAmount;
    }

    public Long getOrderDetailsAmountSum() {
        return orderDetails.stream().mapToLong(detail -> detail.getAmount()).sum();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public OrderStatusCode getStatus() {
        return status;
    }

    public void setStatus(OrderStatusCode status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getOrderTelNo() {
        return orderTelNo;
    }

    public void setOrderTelNo(String orderTelNo) {
        this.orderTelNo = orderTelNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
