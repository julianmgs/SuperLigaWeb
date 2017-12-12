package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.Jugador;

public interface JugadorDao {

	public Jugador findById(Long id);

	public List<Jugador> findAll();

	public void save(Jugador jugador);

	// public void update(Jugador jugador);

	public void delete(Jugador jugador);

	public Jugador findByDci(String dci);
}
