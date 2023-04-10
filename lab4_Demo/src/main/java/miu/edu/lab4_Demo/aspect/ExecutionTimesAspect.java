package miu.edu.lab4_Demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimesAspect {
    @Pointcut("@annotation(miu.edu.miu.lab4_Demo.aspect.annotation.ExecutionTime)")
    public void excutionTimeAnnotation(){

    }
    @Around("excutionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint)throws Throwable{
        long start =System.nanoTime();
        var result=joinPoint.proceed();
        long finish= System.nanoTime();
        System.out.println(joinPoint.getSignature().getName()+"takes ns: "+(finish-start));
        return result;
    }

}
