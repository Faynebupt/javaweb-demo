package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class PermsAspect {


    // Controller层切点
    @Before( "@annotation(spring.aspect.Perms) && @Perms(perms)" )
    public void doBefore(ProceedingJoinPoint joinPoint, int[] perms){
        System.out.println("---------" + Arrays.toString(perms));
        try{
            joinPoint.proceed();
        } catch(Throwable throwable){
            throwable.printStackTrace();
        }
    }


}
