package com.service;

import java.util.List;

import com.bean.Country;

public interface CountryService {
	public void addUser(Country c);
	public boolean deleteUser(int id);
	public void updateUser(Country c);
	public Country findById(int id);
	public List<Country> findByname(Country c);
	public List<Country> findAll();
}
