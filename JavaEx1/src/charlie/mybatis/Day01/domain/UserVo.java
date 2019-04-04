package charlie.mybatis.Day01.domain;

import java.util.List;

public class UserVo {
    private User user;
    private int pageSize;
    private  int pageIndex;
    private List<User> users;
    public int curRowIndex;
    public int getCurRowIndex() {
        return pageSize * pageIndex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
