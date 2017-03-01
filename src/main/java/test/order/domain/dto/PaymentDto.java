package test.order.domain.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class PaymentDto {

    @NotNull(message = "총 결제금액 누락")
    @Min(value = 0, message = "총 결제금액 오류")
    private Long amount;
    @Valid
    private List<PaymentDetailDto> payDetails;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public List<PaymentDetailDto> getPayDetails() {
        return payDetails;
    }

    public void setPayDetails(List<PaymentDetailDto> payDetails) {
        this.payDetails = payDetails;
    }

    public Long getPaymentDetailDtoAmountSum() {
        return payDetails.stream().mapToLong(detail -> detail.getAmount()).sum();
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "amount=" + amount +
                ", payDetails=" + payDetails +
                '}';
    }
}
