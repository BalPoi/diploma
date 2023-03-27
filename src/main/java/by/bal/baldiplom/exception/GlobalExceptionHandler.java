package by.bal.baldiplom.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public RuntimeException resourceHandler(Exception ex) {
        return new RuntimeException();
        //В таком виде отправляется стандартная DTO
    }
}
