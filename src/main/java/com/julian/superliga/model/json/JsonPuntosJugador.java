package com.julian.superliga.model.json;

public class JsonPuntosJugador {
	
	private String dci;
	private String nombre;
	private String apellido;
	private int puntos;
	private int eventosJugados;
	
	public String getDci() {
		return dci;
	}
	
	public void setDci(String dci) {
		this.dci = dci;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
