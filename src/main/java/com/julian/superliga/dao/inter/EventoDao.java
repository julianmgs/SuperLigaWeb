package com.julian.superliga.dao.inter;

import java.util.Date;
import java.util.List;

import com.julian.superliga.model.Evento;

public interface EventoDao {

	public Evento findById(Long id);

	public List<Evento> findAll();

	public void save(Evento evento);

	// public void update(Evento evento);

	public void delete(Evento evento);

	public List<Evento> findAllBySeason(int month, int year);

	List<Evento> findAfterDate(Date fecha);

}
