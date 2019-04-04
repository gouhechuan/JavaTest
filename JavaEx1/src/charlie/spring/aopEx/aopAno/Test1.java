package charlie.spring.aopEx.aopAno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public  void TestAop(){
        //BasicConfigurator.configure();
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/spring/aopEx/aopAno/bean3.xml");
        Book book=(Book) context.getBean("book");
        book.add();
        book.add();
    }

}
