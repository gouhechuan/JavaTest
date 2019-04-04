package charlie.mybatis.day02.dao;

import charlie.mybatis.day02.domain.User;

public interface UserMapper {
    User selectUserById(int id);
    void updateUser(User user);
}
