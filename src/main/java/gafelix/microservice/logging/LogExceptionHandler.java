package gafelix.microservice.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static java.lang.String.*;

@Aspect
@Component
@Slf4j
public class LogExceptionHandler {

    @Pointcut("execution(* gafelix.microservice..*()) && args(exception)")
    void rootPackageException(Exception exception) {}

    @AfterThrowing(value = "rootPackageException(exception)", argNames = "joinPoint,exception")
    public void dispatchException(JoinPoint joinPoint, Exception exception) {
        log.error(format("%s caught after %s called %s method.",
                exception.getMessage(),
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName()));
    }

}