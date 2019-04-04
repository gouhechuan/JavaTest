package charlie.spring.jdbcTemplateEx.TranAno;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Test1 {
    @Test
    public void insertTest() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "insert into UserInfo(UserName,Password) values(?,?)";
        int row = template.update(sql, "lucy", "123");
        if (row > 0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
        //template.execute("insert into UserInfo(UserName,Password) values(\"admin\",\"123\")");
    }
    @Test
    public void updateTest() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "update userinfo set password=? where username=?";
        int row = template.update(sql, "456", "lucy");
        if (row > 0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
        //template.execute("insert into UserInfo(UserName,Password) values(\"admin\",\"123\")");
    }

    @Test
    public void deleteTest() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "delete from UserInfo where username=?";
        int row = template.update(sql,  "lucy");
        if (row > 0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
        //template.execute("insert into UserInfo(UserName,Password) values(\"admin\",\"123\")");
    }
    @Test
    public void queryTest(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select count(1) from userinfo";
        int count=  template.queryForObject(sql,Integer.class);
        System.out.println("总记录数"+count);
    }
    private final String url="jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8";
    @Test
    public void queryJdbc()  {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,"root","1234");
            String sql="select * from UserInfo";
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void queryObject(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from userinfo where id=?";
        try{
           UserInfo userInfo= template.queryForObject(sql, new RowMapper<UserInfo>() {
                public UserInfo mapRow(ResultSet rs, int i){
                    UserInfo userInfo=new UserInfo();
                    try{
                        userInfo.setId(rs.getInt(1));
                        userInfo.setUserName(rs.getString(2));
                        userInfo.setPassword(rs.getString(3));
                        userInfo.setCreateTime(rs.getTimestamp(4));
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return userInfo;
                }
            },"1");

           System.out.println(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void queryList(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from userinfo";
        try{
            List<UserInfo> userInfos= template.query(sql, new RowMapper<UserInfo>() {
                public UserInfo mapRow(ResultSet rs, int i){
                    UserInfo userInfo=new UserInfo();
                    try{
                        userInfo.setId(rs.getInt(1));
                        userInfo.setUserName(rs.getString(2));
                        userInfo.setPassword(rs.getString(3));
                        userInfo.setCreateTime(rs.getTimestamp(4));
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return userInfo;
                }
            });

            System.out.println(userInfos.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void queryMap(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from userinfo";
        try{
            List<Map<String, Object>>  lists  = template.queryForList(sql);
            System.out.println(lists.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void c3p0Test(){

        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1/myjavadb?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("1234");
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from userinfo";
        try{
            List<Map<String, Object>>  lists  = template.queryForList(sql);
            System.out.println(lists.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public  void  TestUserService(){
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/spring/jdbcTemplateEx/Bean.xml");
        UserService userService=(UserService)context.getBean("userService");
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("jack");
        userInfo.setPassword("111");
        userInfo.setCreateTime(new Date());

        userService.add(userInfo);
    }

    @Test
    public  void  TestUserServiceTransfer(){
        ApplicationContext context=new ClassPathXmlApplicationContext("charlie/spring/jdbcTemplateEx/TranAno/Bean.xml");
        UserService userService=(UserService)context.getBean("userService");
        userService.transfer(4,5,1);
    }



}
