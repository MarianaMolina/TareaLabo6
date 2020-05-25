package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Contribuyente;

@Repository
public class ContribuyenteDAOlmpl implements ContribuyenteDAO {
	
	@PersistenceContext(unitName="demo")
	private EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente>result = query.getResultList();
		return result;
	}

	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		Contribuyente contribuyente = entityManager.find(Contribuyente.class, code);
		return contribuyente;
	}

	@Override
	public void save(Contribuyente contribuyente) throws DataAccessException {
		try {
			if(contribuyente.getId_Contribuyente() == null) {
				entityManager.persist(contribuyente);
			}
			else {
				entityManager.merge(contribuyente);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(Integer codigoContribuyente) throws DataAccessException {
		Contribuyente contribuyente = entityManager.find(Contribuyente.class, codigoContribuyente);
		entityManager.remove(contribuyente);
	}
	
}
