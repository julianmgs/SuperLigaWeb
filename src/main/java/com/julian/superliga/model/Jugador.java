package com.julian.superliga.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador {

	private Long id;
	private String dci;
	private String nombre;
	private String apellido;
	private Set<PuntosJugadorEvento> eventosJugador = new HashSet<PuntosJugadorEvento>(0);

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "dci")
	public String getDci() {
		return dci;
	}

	public void setDci(String dci) {
		this.dci = dci;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugador")
	public Set<PuntosJugadorEvento> getEventosJugador() {
		return eventosJugador;
	}

	public void setEventosJugador(Set<PuntosJugadorEvento> eventosJugador) {
		this.eventosJugador = eventosJugador;
	}

}
