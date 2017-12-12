package com.julian.superliga.vo;

import com.julian.superliga.model.Jugador;

public class JugadorPuntos {

	private Jugador jugador;
	private Integer puntos;
	private boolean checked;

	public JugadorPuntos() {

	}

	public JugadorPuntos(Jugador jugador, Integer puntos, Boolean checked) {
		this.jugador = jugador;
		this.puntos = puntos;
		this.checked = checked;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}