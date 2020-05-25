package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ContribuyenteDAO;
import com.example.demo.domain.Contribuyente;

@Service
public class ContribuyenteServicelmpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findOne(code);
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.save(contribuyente);
		
	}

	@Override
	@Transactional
	public void delete(Integer codigoContribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.delete(codigoContribuyente);
	}
}
