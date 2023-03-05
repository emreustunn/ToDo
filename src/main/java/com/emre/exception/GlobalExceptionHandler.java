package com.emre.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Tüm istisnaların üzerinden geçtiği bir method oluşturuyorum ve Hata mesajını burada
     * dönüyorum.
     */
    private ErrorMessage createErrorMessage(EErrorType errorType, Exception exception) {
        System.out.println("Hata oluştu...: " + exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();

    }

    /**
     * ExceptionHandler -> uygulama içinde oluşacak hatanın türünü bizden alarak
     * onun yakalanmasını sağlar, böylece yakaladığı istisnayı methoda geçer
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception exception) {
        System.out.println("Tespit edilmeyen hata oluştu....: " + exception.getMessage());
        return ResponseEntity.badRequest().body("Uygulamada beklenmeyen bir hata oluştu..: " + exception.getMessage());

    }

    @ResponseBody
    @ExceptionHandler(UserDoLoginException.class)
    public ResponseEntity<ErrorMessage> handleSatisManagerException(UserDoLoginException exception) {
        EErrorType errorType = exception.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        return new ResponseEntity<>(createErrorMessage(errorType, exception), httpStatus);
    }

    @ResponseBody
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorMessage> handleInvalidFormatExcepiton(InvalidFormatException exception) {
        EErrorType errorType = EErrorType.INVALID_PARAMATER;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handle(MethodArgumentTypeMismatchException exception) {
        EErrorType errorType = EErrorType.METHOD_MIS_MATCH_ERROR;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadebleException(HttpMessageNotReadableException exception) {
        EErrorType errorType = EErrorType.METHOD_MIS_MATCH_ERROR;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    /**
     * http://localhost:9090/urun/findbyid/234/sort/desc
     * http://localhost:9090/urun/findbyid/sort/desc
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadebleException(MethodArgumentNotValidException exception) {
        EErrorType errorType = EErrorType.METHOD_NOT_VALID_ARGUMENT_ERROR;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }
}
