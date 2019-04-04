package charlie.mybatis.day02;

import charlie.mybatis.day02.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class day02Test {
    @Test
    public void Test1(){
        try{
            InputStream is= Resources.getResourceAsStream("charlie/mybatis/day02/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();

            UserMapper userDao = session.getMapper(UserMapper.class);
            charlie.mybatis.day02.domain.User user=userDao.selectUserById(1);
            System.out.println(user);

            user.setAddress("bbbbb");
            userDao.updateUser(user);



            user.setAddress("CCCCCC");
            userDao.updateUser(user);

            session.commit();

            charlie.mybatis.day02.domain.User user2=userDao.selectUserById(1);
            System.out.println(user2);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void TestCache1(){
        try{
            InputStream is= Resources.getResourceAsStream("charlie/mybatis/day02/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session1=factory.openSession();
            SqlSession session2=factory.openSession();
            SqlSession session3=factory.openSession();

            UserMapper userDao1 = session1.getMapper(UserMapper.class);
            charlie.mybatis.day02.domain.User user=userDao1.selectUserById(1);
            System.out.println(user);
            session1.close();

            UserMapper userDao2 = session2.getMapper(UserMapper.class);
            charlie.mybatis.day02.domain.User user2=userDao2.selectUserById(1);
            System.out.println(user2);
            session2.close();


//            user.setAddress("bbbbb");
//            userDao.updateUser(user);
//
//
//
//            user.setAddress("CCCCCC");
//            userDao.updateUser(user);
//
//            session.commit();

            //charlie.mybatis.day02.domain.User user2=userDao.selectUserById(1);
            //System.out.println(user2);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
