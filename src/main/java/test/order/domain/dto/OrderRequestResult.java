package test.order.domain.dto;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

public class OrderRequestResult {

    private String returnUrl;
    private String orderNo;

    public OrderRequestResult(String returnUrl, String orderNo) {
        this.returnUrl = returnUrl;
        this.orderNo = orderNo;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
