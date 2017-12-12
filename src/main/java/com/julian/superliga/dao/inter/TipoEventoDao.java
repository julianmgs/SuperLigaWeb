package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.TipoEvento;

public interface TipoEventoDao {

	public TipoEvento findById(Long id);

	public List<TipoEvento> findAll();

	public void save(TipoEvento tipoEvento);

	// public void update(TipoEvento tipoEvento);

	public void delete(TipoEvento tipoEvento);
}
