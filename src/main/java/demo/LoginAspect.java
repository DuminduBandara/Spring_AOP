package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){

        String arg = jp.getArgs()[0].toString();
        System.out.println("Before loggers: " + arg);
    }

    @After("execution(* *.*.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.count(..))")
    public void afterRetuningPointCut(){}

    @AfterReturning(pointcut = "afterRetuningPointCut()", returning = "retVal")
    public void afterReturning(String retVal){
        System.out.println("After Returning: " + retVal);
    }
}
