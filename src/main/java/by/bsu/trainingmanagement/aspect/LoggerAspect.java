package by.bsu.trainingmanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by anyab on 09.12.2017.
 */
@Aspect
public class LoggerAspect {

    @AfterReturning(pointcut = "execution(* by.bsu.trainingmanagement.dao.impl.TrainingDAOImpl.*(..))",
            returning= "result")
    public void logAfterTrainingsMethod(JoinPoint joinPoint, Object result) {
        System.out.println("******");
        System.out.println("Method : " + joinPoint.getSignature().getName());
        System.out.println("Result : " + result);
        System.out.println("******");
    }

    @AfterReturning(pointcut = "execution(* by.bsu.trainingmanagement.dao.impl.UserDAOImpl.*(..))",
            returning= "result")
    public void logAfterUsersMethod(JoinPoint joinPoint, Object result) {
        System.out.println("******");
        System.out.println("Method : " + joinPoint.getSignature().getName());
        System.out.println("Result : " + result);
        System.out.println("******");
    }
}
