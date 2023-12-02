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

//    @AfterReturning("execution(* esprit.se.foyer.services.EtudiantService.*(..))")
//    public void logMethodExit(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("In method " + name + " : ");
//    }
//
//    @AfterThrowing("execution(* esprit.se.foyer.services.EtudiantService.*(..))")
//    public void logSelect(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("In method " + name + " : ");
//    }
//
//    @After("execution(* esprit.se.foyer.services.EtudiantService.*(..))")
//    public void logMethod(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("In method " + name + " : ");
//    }
}
