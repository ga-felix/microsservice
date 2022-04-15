package gafelix.microservice.service.dto;


import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ExceptionDto(
        HttpStatus responseStatus,
        String exception,
        Instant timestamp
) {
}
