package com.julian.superliga.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.FormatoDao;
import com.julian.superliga.model.Formato;

@Repository("formatoDao")
public class FormatoDaoImpl extends AbstractDao<Long, Formato> implements FormatoDao {

	@Override
	public Formato findById(Long id) {

		return super.findObjectById(id);
	}

	@Override
	public List<Formato> findAll() {

		return super.findAllObjects();
	}

	@Override
	public void save(Formato formato) {
		super.save(formato);
	}

	/*-
	@Override
	public void update(Formato formato) {
		super.update(formato);
	}
	 */

	@Override
	public void delete(Formato formato) {
		super.delete(formato);
	}

}
