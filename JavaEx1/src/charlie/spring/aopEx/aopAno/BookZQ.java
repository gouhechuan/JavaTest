package charlie.spring.aopEx.aopAno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Before;

@Aspect
public class BookZQ {
    @org.aspectj.lang.annotation.Before("execution(* charlie.spring.aopEx.aopAno.Book.*(..))")
    public void preAdd(){
        System.out.println("前置增强...");
    }
    @After("execution(* charlie.spring.aopEx.aopAno.Book.*(..))")
    public void afterAdd(){
        System.out.println("后置增强...");
    }
    public  void  around1(ProceedingJoinPoint joinPointd) throws Throwable {
        System.out.println("环绕通知1");
        joinPointd.proceed();
        System.out.println("222");
    }
}
