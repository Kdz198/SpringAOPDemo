package hoangtugio.org.springaopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // 2 Cách để nhận parameter từ method jointPoint
    @Before( "execution(* hoangtugio.org.springaopdemo.OrderService.saveOrder(..))" )
    public void logBefore( JoinPoint joinPoint) {
        System.out.println(">>> Aspect: Logging before saving order... ");
        Object[] args = joinPoint.getArgs();
        System.out.println(">>> ID = " + args[0]);
    }

    @Before("execution(* hoangtugio.org.springaopdemo.OrderService.saveOrder(..)) && args(id)")
    public void logBefore(int id) {
        System.out.println(">>> Logging id = " + id);
    }


    @Around( "execution(* hoangtugio.org.springaopdemo.OrderService.saveOrder(..))  "  )
    public void logAround(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(">>> Aspect: Logging around before saving order...");
        joinPoint.proceed();
        System.out.println(">>> Aspect: Logging around after saving order...");
    }
}
