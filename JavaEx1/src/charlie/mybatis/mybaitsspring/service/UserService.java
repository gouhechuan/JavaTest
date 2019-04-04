package charlie.mybatis.mybaitsspring.service;

import charlie.mybatis.mybaitsspring.dao.UserMapper;
import charlie.mybatis.mybaitsspring.dao.domain.User;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void findUser(){
        User user=userMapper.selectUserById(1);
        System.out.println(user);
    }
}
