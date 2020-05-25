package com.example.demo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.Contribuyente;

public interface ContribuyenteDAO {
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public Contribuyente findOne(Integer code) throws DataAccessException;
	
	public void save(Contribuyente contribuyente) throws DataAccessException;
	
	public void delete(Integer codigoContribuyente) throws DataAccessException;
}
