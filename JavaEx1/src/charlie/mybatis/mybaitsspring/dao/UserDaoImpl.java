package charlie.mybatis.mybaitsspring.dao;
import charlie.mybatis.mybaitsspring.dao.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends   SqlSessionDaoSupport implements UserDao  {
    @Autowired
    public void  setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public User selectUserById(int id) throws Exception {
        SqlSession session=this.getSqlSession();
        User user = session.selectOne("charlie.mybatis.mybaitsspring.dao.UserMapper.selectUserById",1);
        System.out.println(user);
        return  user;
    }

    @Override
    public boolean insertUser(User user) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        return false;
    }
}
