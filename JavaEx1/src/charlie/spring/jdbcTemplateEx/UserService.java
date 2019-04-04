package charlie.spring.jdbcTemplateEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;


public class UserService {

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    public void  add(UserInfo userInfo){
        userDao.add(userInfo);
    }

    public void transfer(int addid,int reduceId,int point){

        userDao.addPoint(addid,point);
        int i=1/0;
        userDao.reducePoint(reduceId,point);
    }
}
