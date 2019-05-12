package charlie.ssm.controller;

import charlie.ssm.po.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class ItemsController1 implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

        User user1=new User();
        user1.setUserName("aaaa");
        user1.setId(1);


        User user2=new User();
        user2.setUserName("bbb");
        user2.setId(2);

        List<User> userList=new ArrayList<>();

        userList.add(user1);
        userList.add(user2);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("WEB-INF/jsp/users/userlist.jsp");

        return  modelAndView;
    }
}
