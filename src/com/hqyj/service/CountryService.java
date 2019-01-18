package com.hqyj.service;

import java.util.List;

import com.hqyj.bean.Country;

public interface CountryService {
	public List findAll();
	public boolean deleteCountry(int id);
	public void addCountry(Country c);
	public Country findById(int id);
	public void updateCountry(Country c);
	public List<Country> findCountryAndLanguage(Country c);
}
