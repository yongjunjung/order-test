package test.order.domain.dto.billing;

import static test.order.domain.dto.billing.BillingReturnStatus.FAIL;
import static test.order.domain.dto.billing.BillingReturnStatus.OK;

/**
 * Created by yongjunjung on 2017. 2. 26..
 */
public class BillingRequestResult {

    private static final String SUCCESS_CODE = "0000";
    private static final String SUCCESS_MESSAGE = "성공";

    private BillingReturnStatus status;
    private String requestUrl;
    private String code;
    private String message;

    public static BillingRequestResult ok(String requestUrl) {
        BillingRequestResult billingRequestResult = new BillingRequestResult();
        billingRequestResult.status = OK;
        billingRequestResult.code = SUCCESS_CODE;
        billingRequestResult.message = SUCCESS_MESSAGE;
        billingRequestResult.requestUrl = requestUrl;
        return billingRequestResult;
    }

    public static BillingRequestResult fail(String code, String message) {
        BillingRequestResult billingRequestResult = new BillingRequestResult();
        billingRequestResult.status = FAIL;
        billingRequestResult.code = code;
        billingRequestResult.message = message;
        billingRequestResult.requestUrl = "";
        return billingRequestResult;
    }

    public boolean isOk() {
        return status == OK;
    }

    public boolean isFail() {
        return status == FAIL;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
