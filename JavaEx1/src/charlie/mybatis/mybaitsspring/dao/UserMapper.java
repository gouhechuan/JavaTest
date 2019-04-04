package charlie.mybatis.mybaitsspring.dao;


import charlie.mybatis.mybaitsspring.dao.domain.User;

public interface UserMapper {
    User selectUserById(int id);
    //void updateUser(User user);
}
