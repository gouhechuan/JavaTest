package charlie.mybatis.day02.domain;

import charlie.mybatis.Day01.domain.User;

import java.util.List;

public class UserVo {
    private charlie.mybatis.Day01.domain.User user;
    private int pageSize;
    private  int pageIndex;
    private List<charlie.mybatis.Day01.domain.User> users;
    public int curRowIndex;
    public int getCurRowIndex() {
        return pageSize * pageIndex;
    }

    public charlie.mybatis.Day01.domain.User getUser() {
        return user;
    }

    public void setUser(charlie.mybatis.Day01.domain.User user) {
        this.user = user;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<charlie.mybatis.Day01.domain.User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
