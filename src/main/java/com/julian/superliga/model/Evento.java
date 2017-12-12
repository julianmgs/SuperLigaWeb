package com.julian.superliga.model;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "eventos")
public class Evento implements Comparable<Evento> {

	private Long id;
	private TipoEvento tipoEvento;
	private Formato formato;
	private String descripcion;
	private Date fecha;
	private Date hora;
	private String fbUrl;
	private Timestamp fechaTimestamp;
	private Set<PuntosJugadorEvento> puntosJugador = new HashSet<PuntosJugadorEvento>(0);

	public Evento() {
	}

	public Evento(TipoEvento tipoEvento, Formato formato, String descripcion, Date fecha) {
		this.tipoEvento = tipoEvento;
		this.formato = formato;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = TipoEvento.class)
	@JoinColumn(name = "id_tipo_evento")
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Formato.class)
	@JoinColumn(name = "id_formato")
	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "fecha", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "hora", columnDefinition = "TIME")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Column(name = "fb_url")
	public String getFbUrl() {
		return fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	@Column(name = "timestamp_alta")
	public Timestamp getFechaTimestamp() {
		return fechaTimestamp;
	}

	public void setFechaTimestamp(Timestamp fechaTimestamp) {
		this.fechaTimestamp = fechaTimestamp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "evento", cascade = CascadeType.ALL)
	public Set<PuntosJugadorEvento> getPuntosJugador() {
		return puntosJugador;
	}

	public void setPuntosJugador(Set<PuntosJugadorEvento> puntosJugador) {
		this.puntosJugador = puntosJugador;
	}

	@Override
	public int compareTo(Evento o) {
		if (fecha.before(o.getFecha())) {
			return -1;
		} else if (fecha.after(o.getFecha())) {
			return 1;
		} else if (hora.before(hora)) {
			return -1;
		} else {
			return 1;
		}
	}

	public static Comparator<Evento> EventoComparator = new Comparator<Evento>() {

		@Override
		public int compare(Evento e1, Evento e2) {

			return e1.compareTo(e2);
		}

	};

}
