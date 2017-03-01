package test.order.common.exception;

/**
 * Created by yongjunjung on 2017. 2. 25..
 */
public class OrderRuntimeException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public OrderRuntimeException(String errorCode, String errorMessage) {
        super(errorMessage, null);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
