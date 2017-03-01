package test.order.api.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import test.order.common.exception.ClientRuntimeException;
import test.order.common.exception.OrderRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Created by yongjunjung on 2017. 2. 25..
 */

@ControllerAdvice
@ResponseBody
public class CommonAdviceController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageSource messageSource;

    /**
     * 사용자 오류
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ClientRuntimeException.class)
    public ErrorResult exceptionHandler(ClientRuntimeException ce) {
        logger.info("[request] client Exception code={}, message={}", ce.getErrorCode(), ce.getErrorMessage(), ce);
        return new ErrorResult(ce.getErrorCode(), ce.getErrorMessage());
    }

    /**
     * 서버 내부 오류
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(OrderRuntimeException.class)
    public ErrorResult exceptionHandler(OrderRuntimeException e) {
        logger.error("[request] order server Exception code={}, message={}", e.getErrorCode(), e.getErrorMessage(), e);
        return new ErrorResult(e.getErrorCode(), e.getErrorMessage());
    }

    /**
     * 스프링 MVC 파라미터 바인딩 오류
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult processValidationError(MethodArgumentNotValidException ex) {

        BindingResult result = ex.getBindingResult();
        logger.info("[request] spring Parameter Exception code={}, message={}", result.getFieldError(), ex);

        return new ErrorResult("4000", "INVALID_REQUEST_PARAMETER", processFieldErrors(result.getFieldErrors()));
    }

    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();

        for (FieldError fieldError : fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
        }

        return dto;
    }

    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

        //메시지를 찾지 못하면 기본 메시지 + 예러 코드 정보를 반환한다.
        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = localizedErrorMessage + ", errorCode = " + fieldErrorCodes[0];
        }

        return localizedErrorMessage;
    }


    public class ValidationErrorDTO {

        private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

        public void addFieldError(String path, String message) {
            FieldErrorDTO error = new FieldErrorDTO(path, message);
            fieldErrors.add(error);
        }

        public List<FieldErrorDTO> getFieldErrors() {
            return fieldErrors;
        }
    }

    public class FieldErrorDTO {

        private String field;
        private String message;

        public FieldErrorDTO(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

}
