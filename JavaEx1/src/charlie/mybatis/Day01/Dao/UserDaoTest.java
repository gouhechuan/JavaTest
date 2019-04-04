package charlie.mybatis.Day01.Dao;

import charlie.mybatis.Day01.Dao.Mapper.UserMapper;
import charlie.mybatis.Day01.domain.User;
import charlie.mybatis.day02.domain.UserCustom;
import charlie.mybatis.day02.domain.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class UserDaoTest {

    @Test
    public  void  Test1() throws Exception{
        InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user);
    }
    @Test
    public void  Test2() {
        User user=new User();
        System.out.println(user);



    }
    @Test
    public void  Test3()  throws Exception {
        InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        //user.setSex(true);

        UserVo userVo=new UserVo();
        userVo.setPageIndex(1);
        userVo.setPageSize(3);
        userVo.setUser(user);

        List<UserCustom> users = userMapper.SelectPage(userVo);
        System.out.println(users);
    }


    @Test
    public void  Test4()  throws Exception {
        InputStream is= Resources.getResourceAsStream("charlie/mybatis/Day01/config/sqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user1 = new User();
        user1.setId(1);

        User user2 = new User();
        user2.setId(2);

        List<User> users=new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        User user= new User();
        //user.setSex(true);

        UserVo userVo=new UserVo();
        userVo.setPageIndex(0);
        userVo.setPageSize(3);
        userVo.setUser(user);
        userVo.setUsers(users);

        List<UserCustom> userCustoms = userMapper.SelectPage(userVo);
        System.out.println(userCustoms);
    }

    @Test
    public void  test4(){
        String a="abc";

        String b="abc";
        if(a==b){

            System.out.println("a==b");

        }else{

            System.out.println("a!=b");}
    }
}
