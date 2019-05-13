package com.tcc.tcc_mybatis.activity;

import com.tcc.tcc_mybatis.entity.User;

import java.util.List;
//接受json时要这个
public class userList {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public userList() {
    }

    public userList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "userList{" +
                "userList=" + userList +
                '}';
    }
}
