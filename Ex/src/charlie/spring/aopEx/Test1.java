package charlie.spring.aopEx;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public  void TestAop(){
        //BasicConfigurator.configure();
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/spring/aopEx/bean3.xml");
        Book book=(Book) context.getBean("book");
        book.add();
        book.add();
    }

}
