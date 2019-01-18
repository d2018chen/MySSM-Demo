package com.hqyj.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.bean.Country;
import com.hqyj.bean.User;
import com.hqyj.service.CountryService;
import com.hqyj.service.UserService;
@Controller
@RequestMapping("/country")
public class UserController {
	@Autowired
	private CountryService countryService;
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String list(User u,Model model,HttpServletRequest req,HttpServletResponse resp){
		int result=userService.findByName(u);
		String msg="";
		if(result==0){
			msg="用户不存在";
			req.setAttribute("msg",msg);
			return "../../index";
		}else if(result==-1){
			msg="密码输入错误";
			req.setAttribute("msg",msg);
			return "../../index";
		}else{
			List<Country> list=countryService.findAll();
			model.addAttribute("countryList",list);
			Cookie c=new Cookie("USERNAME",URLEncoder.encode(u.getUsername()));
			c.setPath("/");
			resp.addCookie(c);
			req.setAttribute("USERNAME", u.getUsername());
			return "/countryList";
		}
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
