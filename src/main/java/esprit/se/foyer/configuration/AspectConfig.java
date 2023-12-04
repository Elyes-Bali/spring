package esprit.se.foyer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectConfig {
    @Before("execution(* esprit.se.foyer.services.EtudiantService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterReturning(pointcut = "execution(* esprit.se.foyer.services.EtudiantService.*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        log.info("Exiting method " + name + " with result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* esprit.se.foyer.services.EtudiantService.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        String name = joinPoint.getSignature().getName();
        log.error("Exception in method " + name + ": " + exception.getMessage());
    }

    @After("execution(* esprit.se.foyer.services.EtudiantService.*(..))")
    public void logMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Inside method " + name);
    }
}
