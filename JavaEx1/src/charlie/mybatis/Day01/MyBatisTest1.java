
package charlie.mybatis.Day01;

import charlie.mybatis.Day01.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest1 {
   @Test
    public void Test1(){
        try{
            InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            User user = session.selectOne("UserResp.selectUserById",1);
            System.out.println(user);
            session.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }


    @Test
    public void selectUserByUserName(){
        try{
            InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            List<User> user = session.selectList("UserResp.selectUserByUserName","jack");
            System.out.println(user);
            session.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    /*占位符*/
    @Test
    public void selectUserByUserNameZWF(){
        try{
            InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            List<User> user = session.selectList("UserResp.selectUserByUserNameZWF","%jack%");
            System.out.println(user);
            session.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void insertUser(){
        try{
            User user=new User();
            user.setUserName("tttttt");
            user.setBirthday(new Date());
            user.setSex(true);

            InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            System.out.println( session.insert("UserResp.insertUser",user));
            session.commit();

            session.close();

            System.out.println(user);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteUser(){
        try{

            InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            System.out.println( session.delete("UserResp.deleteUser",11));
            session.commit();

            session.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void updateUser(){
        try{
            User user=new User();
            user.setId(10);
            user.setUserName("bbbb");
            user.setBirthday(new Date());
            user.setSex(true);

            InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            System.out.println( session.update("UserResp.updateUser",user));
            session.commit();
            session.close();
            System.out.println(user);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
