package com.julian.superliga.vo;

import java.util.ArrayList;
import java.util.List;

import com.julian.superliga.model.Evento;
import com.julian.superliga.model.Jugador;
import com.julian.superliga.model.PuntosJugadorEvento;

public class SancionarEventoVo {

	private Evento evento;
	private List<JugadorPuntos> jugadoresPuntos;
	private List<PuntosJugadorEvento> rankingFinal;

	public SancionarEventoVo() {
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<JugadorPuntos> getJugadoresPuntos() {
		return jugadoresPuntos;
	}

	public void setJugadoresPuntos(List<JugadorPuntos> jugadoresPuntos) {
		this.jugadoresPuntos = jugadoresPuntos;
	}

	public List<PuntosJugadorEvento> getRankingFinal() {
		return rankingFinal;
	}

	public void setRankingFinal(List<PuntosJugadorEvento> rankingFinal) {
		this.rankingFinal = rankingFinal;
	}

	public void setJugadoresList(List<Jugador> jugadores) {
		jugadoresPuntos = new ArrayList<JugadorPuntos>();

		for (Jugador jugador : jugadores) {
			jugadoresPuntos.add(new JugadorPuntos(jugador, 0, false));
		}
	}

}
