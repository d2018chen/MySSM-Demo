package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Country;
import com.bean.User;
import com.service.CountryService;
import com.service.UserService;

@Controller
public class Login {
	@Autowired
	private CountryService countryService;
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/list.do")
	public String list(User u, Model model,HttpServletResponse reponse) {
		User s = userService.findByName(u.getName());
		if (null != s) {
			if (s.getPassword().equals(u.getPassword())) {
				ArrayList<Country> clist = (ArrayList<Country>) countryService.findAll();
				model.addAttribute("clist", clist);
				Cookie cookie = new Cookie("username", u.getName());
				cookie.setPath("/");
				reponse.addCookie(cookie);
				return "list";
			}

		}
		return "../../index";
	}

	@RequestMapping(value = "/preAdd.do")
	public String preAdd() {
		return "add";
	}

	@RequestMapping(value = "/add.do")
	public String add(Country country, Model model)	throws UnsupportedEncodingException {
		countryService.addUser(country);
		ArrayList<Country> clist = (ArrayList<Country>) countryService.findAll();
		model.addAttribute("clist", clist);
		return "list";
	}

	@RequestMapping(value = "/delete.do")
	public String delete(Integer id, Model model) {
		boolean b = countryService.deleteUser(id);
		ArrayList<Country> clist = (ArrayList<Country>) countryService.findAll();
		model.addAttribute("clist", clist);
		return "list";
	}

	@RequestMapping(value = "/preupdate.do")
	public String preupdate(Integer id, Model model) {
		Country c = countryService.findById(id);
		model.addAttribute("country", c);
		return "update";
	}

	@RequestMapping(value = "/update.do")
	public String update(Country country,Model model) {
		countryService.updateUser(country);
		ArrayList<Country> clist = (ArrayList<Country>) countryService.findAll();
		model.addAttribute("clist", clist);
		return "list";
	}
	@RequestMapping(value="/select.do")
	public String query(Country c,Model model){
		ArrayList<Country> clist=(ArrayList<Country>) countryService.findByname(c);
		model.addAttribute("clist", clist);
		return "list";
	}
	/*
	 * @RequestMapping("delUser.do") public void delUser(int id,
	 * HttpServletRequest request, HttpServletResponse response) { String result
	 * = "{\"result\":\"error\"}"; if (countryService.deleteUser(id)) { result =
	 * "{\"result\":\"success\"}"; }
	 * response.setContentType("application/json"); PrintWriter pw; try { pw =
	 * response.getWriter(); pw.write(result); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

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
