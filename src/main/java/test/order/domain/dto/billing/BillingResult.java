package test.order.domain.dto.billing;

import static test.order.domain.dto.billing.BillingReturnStatus.*;

/**
 * Created by yongjunjung on 2017. 2. 26..
 */
public class BillingResult {

    private BillingReturnStatus status;

    public BillingResult(BillingReturnStatus status) {
        this.status = status;
    }

    public BillingReturnStatus getStatus() {
        return status;
    }

    public void setStatus(BillingReturnStatus status) {
        this.status = status;
    }

    //    public static BillingResult ok() {
//        BillingResult billingResult = new BillingResult();
//        billingResult.status = OK;
//        return billingResult;
//    }
//
//    public static BillingResult fail() {
//        BillingResult billingResult = new BillingResult();
//        billingResult.status = FAIL;
//        return billingResult;
//    }
}
