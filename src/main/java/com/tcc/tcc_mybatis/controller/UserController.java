package com.tcc.tcc_mybatis.controller;

import com.tcc.tcc_mybatis.activity.userList;
import com.tcc.tcc_mybatis.entity.User;
import com.tcc.tcc_mybatis.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController //声明为一个Restful的Controller
public class UserController {
    @Resource
    private UserService userService;
    //前端给json对象的增加及批量添加的接口
    @PostMapping("/saveUserBatch")
    public String saveUserBatch(@RequestBody userList model) {
        System.out.println(model.getUserList());
        List<User> u1ist= model.getUserList();
        User user = new User();
        for (User u:u1ist) {
          String name = u.getName();
          int age = u.getAge();
          userService.insertUser(name,age);
        }

        return "ok";
    }


    //删
    @PostMapping("/deleteUserBatch")
    public String deleteUserBatch(@RequestBody userList model) {
        System.out.println(model.getUserList());
        List<User> u1ist= model.getUserList();
        User user = new User();
        for (User u:u1ist) {
            int id=u.getId();
            String name = u.getName();
            int age = u.getAge();
            userService.deleteUser(id);
        }

        return "ok";
    }


    //改
    @PostMapping("/updateUserBatch")
    public String updateUserBatch(@RequestBody userList model) {
        System.out.println(model.getUserList());
        List<User> u1ist= model.getUserList();
        User user = new User();
        for (User u:u1ist) {
            int id=u.getId();
            String name = u.getName();
            int age = u.getAge();
            userService.updateUser(u);
        }

        return "ok";
    }

    //查  http://localhost:8080/selectUserBatch?id=8或者见postman的
    @RequestMapping(value ="/selectUserBatch",method = {RequestMethod.POST})
    public List<User> selectUserBatch(HttpServletRequest request) {
         String  id= request.getParameter("id");
         System.out.println("得到id了--------------------"+id);
         int aid = Integer.parseInt(id);
         HttpSession session = request.getSession();
         session.setAttribute("usrid", aid);
         return userService.selectUser(aid);
    }
    @RequestMapping(value = "/sayhello",method = {RequestMethod.POST})
    public String sayHello(String name){
        String name1 =name;
        System.out.println("收到请求----------------");
        return "hello"+name;
    }

}
