package com.hqyj.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("À¹½Ø");
		if(arg0.getRequestURL().indexOf("login")>=0){
			return true;
		}
		Cookie[] cookArr=arg0.getCookies();
		if(cookArr!=null){
			for (Cookie cookie : cookArr) {
				if("USERNAME".equals(cookie.getName())){
					return true;
				}
			}
		}
		arg0.getRequestDispatcher("../index.jsp").forward(arg0, arg1);
		return false;
	}
	
}
