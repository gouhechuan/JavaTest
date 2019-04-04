package charlie.spring.jdbcTemplateEx.TranAno;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void  add(UserInfo userInfo){
        String sql = "insert into UserInfo(UserName,Password,CreateTime) values(?,?,?)";
        int row = jdbcTemplate.update(sql, userInfo.getUserName(), userInfo.getPassword(),userInfo.getCreateTime());
        if (row > 0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
    }
    public void addPoint(int id,int point) {
        String sql="update userinfo set point=point+? where id=?";
        jdbcTemplate.update(sql,point,id);
    }
    public  void  reducePoint(int id,int point){
        String sql="update userinfo set point=point-? where id=?";
        jdbcTemplate.update(sql,point,id);
    }

}
