package charlie.mybatis.Day01.Dao.Mapper;

import charlie.mybatis.Day01.domain.User;
import charlie.mybatis.day02.domain.UserCustom;
import charlie.mybatis.day02.domain.UserVo;

import java.util.List;

public interface UserMapper {
    public User selectUserById(int id) throws Exception;
    public List<UserCustom> SelectPage(UserVo userVo) throws  Exception;
}
