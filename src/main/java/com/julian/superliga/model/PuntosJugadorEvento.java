package com.julian.superliga.model;

import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "puntos_jugadores_evento")
public class PuntosJugadorEvento implements Comparable<PuntosJugadorEvento> {

	private Long id;
	private Jugador jugador;
	private Evento evento;
	private int puntos;

	private int eventosJugados;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_jugador")
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_evento")
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Column(name = "puntos")
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Transient
	public int getEventosJugados() {
		return eventosJugados;
	}

	public void setEventosJugados(int eventosJugados) {
		this.eventosJugados = eventosJugados;
	}

	@Override
	public String toString() {
		return "PuntosJugadorEvento [jugador=" + jugador + ", evento=" + evento + ", puntos=" + puntos + "]";
	}

	@Override
	public int compareTo(PuntosJugadorEvento puntos) {
		return puntos.getPuntos() - getPuntos();
	}

	public static Comparator<PuntosJugadorEvento> PuntosJugadorEventoComparator = new Comparator<PuntosJugadorEvento>() {

		@Override
		public int compare(PuntosJugadorEvento puntos1,
				PuntosJugadorEvento puntos2) {

			return puntos1.compareTo(puntos2);
		}

	};
}
