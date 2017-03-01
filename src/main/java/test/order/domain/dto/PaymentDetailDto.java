package test.order.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class PaymentDetailDto {

    @NotEmpty(message = "결제수단 누락")
    private String paymentType;
    @NotNull(message = "결제금액 누락")
    @Min(value = 0, message = "결제금액 오류")
    private Long amount;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDetailDto{" +
                "paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
