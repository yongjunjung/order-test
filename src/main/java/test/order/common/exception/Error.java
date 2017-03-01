package test.order.common.exception;

/**
 * Created by yongjunjung on 2017. 2. 25..
 */
public class Error {

    private String code;
    private String message;
    private Object innererror;

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

    public Object getInnererror() {
        return innererror;
    }

    public void setInnererror(Object innererror) {
        this.innererror = innererror;
    }
}
