package charlie.mybatis.Day01.Dao;

import charlie.mybatis.Day01.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory sessionFactory) {
        this.factory=sessionFactory;
    }

    @Override
    public User selectUserById(int id) throws Exception {
        SqlSession session=factory.openSession();
        User user = session.selectOne("UserResp.selectUserById",1);
        System.out.println(user);
        session.close();
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
