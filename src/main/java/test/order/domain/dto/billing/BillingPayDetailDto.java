package test.order.domain.dto.billing;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class BillingPayDetailDto {

    private String payMethod;
    private Long amount;

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
