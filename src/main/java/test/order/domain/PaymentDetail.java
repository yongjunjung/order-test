package test.order.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Entity
public class PaymentDetail {

    @Id @GeneratedValue
    private Long paymentDetailSeq;
    private String paymentType;
    private Long amount;
    private String billingApporveNo;
    private String paymentInfo;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "payment_seq")
    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getPaymentDetailSeq() {
        return paymentDetailSeq;
    }

    public void setPaymentDetailSeq(Long paymentDetailSeq) {
        this.paymentDetailSeq = paymentDetailSeq;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getBillingApporveNo() {
        return billingApporveNo;
    }

    public void setBillingApporveNo(String billingApporveNo) {
        this.billingApporveNo = billingApporveNo;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Payment getPayment() {
        return payment;
    }
}
