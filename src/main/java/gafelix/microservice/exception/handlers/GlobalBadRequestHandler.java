package gafelix.microservice.exception.handlers;

import gafelix.microservice.service.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalBadRequestHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class, IllegalArgumentException.class})
    public ResponseEntity<ExceptionDto> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDto(
                        HttpStatus.BAD_REQUEST,
                        exception.getMessage(),
                        Instant.now()
                ));
    }

}