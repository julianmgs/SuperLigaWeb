package com.julian.superliga.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.TipoEventoDao;
import com.julian.superliga.model.TipoEvento;

@Repository("tipoEventoDao")
public class TipoEventoDaoImpl extends AbstractDao<Long, TipoEvento> implements TipoEventoDao {

	@Override
	public TipoEvento findById(Long id) {
		return super.findObjectById(id);
	}

	@Override
	public List<TipoEvento> findAll() {
		return super.findAllObjects();
	}

	@Override
	public void save(TipoEvento tipoEvento) {
		super.save(tipoEvento);
	}

	/*-
	@Override
	public void update(TipoEvento tipoEvento) {
		super.update(tipoEvento);
	}
	 */

	@Override
	public void delete(TipoEvento tipoEvento) {
		super.delete(tipoEvento);
	}
}
