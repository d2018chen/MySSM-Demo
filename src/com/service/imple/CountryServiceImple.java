package com.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Country;
import com.dao.CountryDao;
import com.service.CountryService;

@Service
@Transactional
public class CountryServiceImple implements CountryService {
	@Resource
	public CountryDao countryDao;
	
	public CountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@Override
	public void addUser(Country c) {
		countryDao.addCountry(c);
	}

	@Override
	public boolean deleteUser(int id) {
		boolean b = countryDao.deleteCountry(id);
		return b;
	}

	@Override
	public void updateUser(Country c) {
		countryDao.update(c);
	}

	@Override
	public Country findById(int id) {
		Country c= countryDao.findById(id);
		return c;
	}

	@Override
	public List<Country> findAll() {
		
		return countryDao.findAll();
	}

	@Override
	public List<Country> findByname(Country c) {
		return countryDao.findByname(c);
	}
	
}
