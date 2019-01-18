package com.hqyj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.bean.Country;
import com.hqyj.dao.CountryDao;
import com.hqyj.service.CountryService;
@Service
@Transactional
public class CountryServiceImpl implements CountryService{
	@Resource
	private CountryDao dao;
	@Override
	public List findAll() {

		return dao.findAll();
	}
	public CountryDao getDao() {
		return dao;
	}
	public void setDao(CountryDao dao) {
		this.dao = dao;
	}
	@Override
	public boolean deleteCountry(int id) {	
		return dao.deleteCountry(id);
	}
	@Override
	public void addCountry(Country c) {
		dao.addCountry(c);
		
	}
	@Override
	public Country findById(int id) {
		return dao.findById(id);
	}
	@Override
	public void updateCountry(Country c) {
		dao.updateCountry(c);
		
	}
	@Override
	public List<Country> findCountryAndLanguage(Country c) {
		return dao.findCountryAndLanguage(c);
	}
}
