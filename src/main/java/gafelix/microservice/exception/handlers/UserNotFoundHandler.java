package gafelix.microservice.exception.handlers;

import gafelix.microservice.exception.UserNotFoundException;
import gafelix.microservice.service.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

@RestControllerAdvice
@Order(1)
public class UserNotFoundHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleMethodArgumentTypeMismatch(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDto(
                        HttpStatus.NOT_FOUND,
                        exception.getMessage(),
                        Instant.now()
                ));
    }

}