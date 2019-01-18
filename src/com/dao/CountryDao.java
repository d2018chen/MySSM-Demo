package com.dao;

import java.util.List;

import com.bean.Country;


public interface CountryDao {
	public int addCountry(Country c);
	public boolean deleteCountry(int i);
	public int update(Country c);
	public Country findById(int i);
	public List<Country> findByname(Country c);
	public List<Country> findAll();
}
