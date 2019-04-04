package charlie.spring.aopEx;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookZQ {
    public void preAdd(){
        System.out.println("前置增强...");
    }
    public void afterAdd(){
        System.out.println("后置增强...");
    }
    public  void  around1(ProceedingJoinPoint joinPointd) throws Throwable {
        System.out.println("环绕通知1");
        joinPointd.proceed();
        System.out.println("222");
    }
}
