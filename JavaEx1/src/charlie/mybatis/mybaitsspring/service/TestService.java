package charlie.mybatis.mybaitsspring.service;


import charlie.mybatis.day02.domain.User;
import charlie.mybatis.mybaitsspring.dao.UserDao;
import charlie.mybatis.mybaitsspring.dao.UserDaoImpl;
import charlie.mybatis.mybaitsspring.dao.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class TestService {


    @Test
    public void Test1() throws Exception {
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/mybatis/mybaitsspring/config/spring/applicationContext.xml");
        UserDao userDao=(UserDao) context.getBean("userDaoImpl");
        userDao.selectUserById(1);
    }

    @Test
    public void Test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/mybatis/mybaitsspring/config/spring/applicationContext.xml");
        UserMapper userDao=(UserMapper) context.getBean("userMapper");
       charlie.mybatis.mybaitsspring.dao.domain.User user= userDao.selectUserById(1);
       System.out.println(user);

    }


    @Test
    public void TestService(){
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/mybatis/mybaitsspring/config/spring/applicationContext.xml");
        UserService userService= (UserService) context.getBean("userService");
        userService.findUser();

    }
}
