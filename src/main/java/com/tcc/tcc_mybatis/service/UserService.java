package com.tcc.tcc_mybatis.service;

import com.tcc.tcc_mybatis.dao.UserDao;
import com.tcc.tcc_mybatis.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public String show(){
        return "hello world";
    }

    public List<User> showUserByAge(int age){
        return userDao.get(age);
    }

    public String insertUser(String name , int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userDao.insert(user);
        return "添加成功";
    }

    public String deleteUser(int id){
        System.out.println("方法开始前------------------------------");
        userDao.batchIndeleteUser(id);
        System.out.println("方法开始后------------------------------");
        return "添加成功";
    }


    public String updateUser(User user){
        System.out.println("方法开始前------------------------------");
        userDao.batchInupdateUser(user);
        System.out.println("方法开始后------------------------------");
        return "添加成功";
    }


    public List<User>  selectUser(int id){
        System.out.println("方法开始前------------------------------");
        return userDao.batchInselectUser(id);
       // System.out.println("方法开始后------------------------------");

    }





}
