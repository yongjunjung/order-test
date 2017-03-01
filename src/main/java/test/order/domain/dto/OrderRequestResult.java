package test.order.domain.dto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

public class OrderRequestResult {

    public OrderRequestResult(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    private String paymentUrl;

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }
}
