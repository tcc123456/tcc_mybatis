package com.tcc.tcc_mybatis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 编码过滤器
 */
//声明类为过滤器,filter的执行顺序为首字母开头a-z
@WebFilter(filterName = "Filter0_encordingFilter" , urlPatterns = "/*")
public class EncodingFilter implements Filter {
	private String encoding = "utf-8";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter0_encordingFilter-----------");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}
}
