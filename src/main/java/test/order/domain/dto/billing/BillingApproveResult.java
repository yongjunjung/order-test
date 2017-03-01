package test.order.domain.dto.billing;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import static test.order.domain.dto.billing.BillingApproveResult.ApproveResultStatus.FAIL;
import static test.order.domain.dto.billing.BillingApproveResult.ApproveResultStatus.OK;

/**
 * Created by younghankim on 2016. 6. 10..
 */
public class BillingApproveResult {

    private ApproveResultStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date approveDatetime;          //승인일자
    private Long amount;
    private String message;
    private String debugMessage;

    private BillingApproveResult(ApproveResultStatus status) {
        this.status = status;
    }

    public static BillingApproveResult ok(String message, Date approveDatetime, Long amount) {
        BillingApproveResult billingApproveResult = new BillingApproveResult(OK);
        billingApproveResult.approveDatetime = approveDatetime;
        billingApproveResult.message = message;
        billingApproveResult.amount = amount;
        return billingApproveResult;
    }

    public static BillingApproveResult fail(String message, String debugMessage) {
        BillingApproveResult billingApproveResult = new BillingApproveResult(FAIL);
        billingApproveResult.message = message;
        billingApproveResult.debugMessage = debugMessage;
        return billingApproveResult;
    }

    public enum ApproveResultStatus {
        OK, FAIL
    }
    protected BillingApproveResult() {
    }

    public ApproveResultStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "BillingApproveResult{" +
                "status=" + status +
                ", approveDatetime=" + approveDatetime +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                '}';
    }
}
