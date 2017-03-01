package test.order.api.advice;

public class ErrorResult {

    Error error;

    public ErrorResult(String code, String message) {
        error = new Error(code, message);
    }

    public ErrorResult(String code, String message, Object innererror) {
        error = new Error(code, message, innererror);
    }

    public Error getError() {
        return error;
    }

    static class Error {

        private String code;
        private String message;
        private Object innererror;

        public Error(String code, String message) {
            this(code, message, null);
        }

        public Error(String code, String message, Object innererror) {
            this.code = code;
            this.message = message;
            this.innererror = innererror;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public Object getInnererror() {
            return innererror;
        }
    }
}

