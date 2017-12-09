package by.bsu.trainingmanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by anyab on 09.12.2017.
 */
@Aspect
public class LoggerAspect {

    @AfterReturning(pointcut = "execution(* by.bsu.trainingmanagement.dao.impl.TrainingDAOImpl.findTrainings(..))",
            returning= "result")
    public void logBefore(JoinPoint joinPoint, Object result) {
        System.out.println("******");
        System.out.println("Trainings : " + result);
        System.out.println("******");
    }
}
