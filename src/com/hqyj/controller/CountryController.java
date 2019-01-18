package com.hqyj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.bean.Country;
import com.hqyj.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/delete.do")
	public String delete(Country count){
		countryService.deleteCountry(count.getId());
		return "redirect:/country/list.do";
	}
	@RequestMapping("deleteCountry.do")
	public void deleteCountry(int id,HttpServletRequest req,HttpServletResponse resp){
		String result="{\"result\":\"error\"}";
		if(countryService.deleteCountry(id)){
			result="{\"result\":\"success\"}";
		}
		resp.setContentType("application/json");
		PrintWriter pw;
		
		try {
			pw=resp.getWriter();
			pw.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/preAdd.do")
	public String preAdd(){
		return "/addCountry";
	}
	@RequestMapping("/addCountry.do")
	public String addCountry(Country c,Model model){
		countryService.addCountry(c);
		List<Country> list =countryService.findAll();
		model.addAttribute("countryList",list);
		return "/countryList";
	}
	@RequestMapping("/preUpdate.do")
	public String preUpdate(Integer id,Model model){
		Country c=countryService.findById(id);
		model.addAttribute("coun",c);
		return "/updateCountry";
	}
	@RequestMapping("/updateCountry.do")
	public String updateCountry(Country c,Model model){
		countryService.updateCountry(c);
		List<Country> list =countryService.findAll();
		model.addAttribute("countryList",list);
		return "/countryList";
	}
	@RequestMapping("/findCountryAndLanguage.do")
	public String findCountryAndLanguage(Country c,Model model){
		List<Country> countryList=countryService.findCountryAndLanguage(c);
		model.addAttribute("countryList",countryList);
		return "/countryList";
		
	}
}
