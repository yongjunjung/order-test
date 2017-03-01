package test.order.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentSeq;

    private String orderNo;
    private String payAuthToken;
    private String billingTradeNo;
    private Long amount;

    @OneToOne(mappedBy = "payment")
    private Order order;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    List<PaymentDetail> paymentDetails = new ArrayList<>();

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void addPaymentDetail(PaymentDetail paymentDetail) {
        paymentDetails.add(paymentDetail);
        paymentDetail.setPayment(this);
    }

    public Long getPaymentDetailAmountSum() {
        return paymentDetails.stream().mapToLong(detail -> detail.getAmount()).sum();
    }

    public Long getPaymentSeq() {
        return paymentSeq;
    }

    public void setPaymentSeq(Long paymentSeq) {
        this.paymentSeq = paymentSeq;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public String getPayAuthToken() {
        return payAuthToken;
    }

    public void setPayAuthToken(String payAuthToken) {
        this.payAuthToken = payAuthToken;
    }

    public String getBillingTradeNo() {
        return billingTradeNo;
    }

    public void setBillingTradeNo(String billingTradeNo) {
        this.billingTradeNo = billingTradeNo;
    }

    public Long getAmount() {
        return amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<PaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentSeq=" + paymentSeq +
                ", orderNo='" + orderNo + '\'' +
                ", payAuthToken='" + payAuthToken + '\'' +
                ", billingTradeNo='" + billingTradeNo + '\'' +
                ", amount=" + amount +
                ", order=" + order +
                ", paymentDetails=" + paymentDetails +
                '}';
    }
}
