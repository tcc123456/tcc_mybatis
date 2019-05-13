package com.tcc.tcc_mybatis.filter;

import com.tcc.tcc_mybatis.entity.User;
import com.tcc.tcc_mybatis.service.UserService;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

//声明类为过滤器
@WebFilter(filterName = "Filter1_userFilter" , urlPatterns = "/*")
public class UserFilter implements Filter {

    @Resource
    UserService userService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter1_userFilter ------filter init");
    }

    @Override
    public void destroy() {
        System.out.println("filter  destory");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
/*
   String  id= servletRequest.getParameter("id");
        System.out.println("这是filter-----得到用户id"+id );
        int uId=Integer.parseInt(id);
        List<User> user = userService.selectUser(uId);

            if(user.size()<1) {
                return;
            }

        System.out.println("filter  dofilter----权限验证通过，会继续往下执行");*/
        filterChain.doFilter(servletRequest,servletResponse);


        System.out.println("Filter1_userFilter ------doFilter");
    }
}
