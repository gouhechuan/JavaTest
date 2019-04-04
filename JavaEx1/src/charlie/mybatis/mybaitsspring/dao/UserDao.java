package charlie.mybatis.mybaitsspring.dao;


import charlie.mybatis.mybaitsspring.dao.domain.User;

public interface UserDao {
    public User selectUserById(int id) throws Exception;

    public boolean insertUser(User user) throws Exception;

    public boolean deleteUser(int id) throws Exception;


}
