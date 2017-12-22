package by.bsu.trainingmanagement.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Created by anyab on 09.12.2017.
 */
@Aspect
public class LoggerAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggerAspect.class);

    @AfterReturning(pointcut = "execution(* by.bsu.trainingmanagement.dao.impl.TrainingDAOImpl.*(..))",
            returning= "result")
    public void logAfterTrainingsMethod(JoinPoint joinPoint, Object result) {
        LOGGER.info("******");
        LOGGER.info("Method : " + joinPoint.getSignature().getName());
        LOGGER.info("Result : " + result);
        LOGGER.info("******");
    }

    @AfterReturning(pointcut = "execution(* by.bsu.trainingmanagement.dao.impl.UserDAOImpl.*(..))",
            returning= "result")
    public void logAfterUsersMethod(JoinPoint joinPoint, Object result) {
        LOGGER.info("******");
        LOGGER.info("Method : " + joinPoint.getSignature().getName());
        LOGGER.info("Result : " + result);
        LOGGER.info("******");
    }
//
//    @AfterThrowing(pointcut = "execution(* by.bsu.trainingmanagement.controller.WeatherController(..))", throwing = "e")
//    public void logAfterThrowingWeatherController(JoinPoint joinPoint, Throwable e) {
//        Signature signature = joinPoint.getSignature();
//        String methodName = signature.getName();
//        String stuff = signature.toString();
//        String arguments = Arrays.toString(joinPoint.getArgs());
//        LOGGER.error(methodName + " with arguments "
//                + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
//                + e.getMessage(), e);
//    }
//
//    @AfterThrowing(pointcut = "execution(* by.bsu.trainingmanagement.controller.TrainingController(..))", throwing = "e")
//    public void logAfterThrowingTrainingController(JoinPoint joinPoint, Throwable e) {
//        Signature signature = joinPoint.getSignature();
//        String methodName = signature.getName();
//        String stuff = signature.toString();
//        String arguments = Arrays.toString(joinPoint.getArgs());
//        LOGGER.error(methodName + " with arguments "
//                + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
//                + e.getMessage(), e);
//    }
}
