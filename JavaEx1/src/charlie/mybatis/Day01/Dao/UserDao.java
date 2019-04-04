package charlie.mybatis.Day01.Dao;

import charlie.mybatis.Day01.domain.User;

public interface UserDao {
    public User selectUserById(int id) throws Exception;

    public boolean insertUser(User user) throws Exception;

    public boolean deleteUser(int id) throws Exception;


}
