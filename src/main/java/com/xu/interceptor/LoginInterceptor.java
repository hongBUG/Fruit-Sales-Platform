package com.xu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String uri = arg0.getRequestURI();
		if(uri.contains("Login") || uri.contains("login") || uri.contains("register") || uri.contains("Register")) {
			// 登录/注册请求  放行
			return true;
		} else {
			// 非登录请求
			if (arg0.getSession().getAttribute("user") != null) {
				return true;  // 已经登录，放行
			} else {
				if (uri.contains("css") || uri.contains("js") || uri.contains("image")) {
					return true;  // 静态资源   放行
				} else {
					// 没有登录 跳转到登录界面
					arg1.sendRedirect(arg0.getContextPath() + "/user/toLogin.action");
				}
			}
		}
		
		return false;
	}

}
