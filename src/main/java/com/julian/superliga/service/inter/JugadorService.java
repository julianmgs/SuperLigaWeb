package com.julian.superliga.service.inter;

import java.util.List;

import com.julian.superliga.model.Jugador;

public interface JugadorService {

	public Jugador findJugadorById(Long id);

	public List<Jugador> findAllJugadores();

	public void newJugador(Jugador jugador);

	public void updateJugador(Jugador jugador);

	public void deleteJugador(Jugador jugador);

	public Jugador findByDci(String dci);
}
