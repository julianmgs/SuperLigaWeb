package com.julian.superliga.vo;

import com.julian.superliga.model.Jugador;

public class PuntosJugadorSeasonVo {

	private Jugador jugador;
	private int puntos;
	private int eventosJugados;

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getEventosJugados() {
		return eventosJugados;
	}

	public void setEventosJugados(int eventosJugados) {
		this.eventosJugados = eventosJugados;
	}

}
