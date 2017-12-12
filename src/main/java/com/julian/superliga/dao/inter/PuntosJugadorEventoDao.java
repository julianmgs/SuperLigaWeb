package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.PuntosJugadorEvento;

public interface PuntosJugadorEventoDao {

	public PuntosJugadorEvento findById(Long id);

	public List<PuntosJugadorEvento> findAll();

	public void save(PuntosJugadorEvento pje);

	// public void update(PuntosJugadorEvento pje);

	public void delete(PuntosJugadorEvento pje);

	public List<PuntosJugadorEvento> findBySeason(int year, int month);

	List<PuntosJugadorEvento> findBySemestre(int year, int semestre);
}
