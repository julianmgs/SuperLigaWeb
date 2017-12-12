package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.Formato;

public interface FormatoDao {

	public Formato findById(Long id);

	public List<Formato> findAll();

	public void save(Formato formato);

	// public void update(Formato formato);

	public void delete(Formato formato);

}
