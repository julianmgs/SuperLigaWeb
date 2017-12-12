package com.julian.superliga.service.inter;

import java.util.List;

import com.julian.superliga.model.Evento;
import com.julian.superliga.model.PuntosJugadorEvento;
import com.julian.superliga.vo.EventoVo;
import com.julian.superliga.vo.Mes;
import com.julian.superliga.vo.SancionarEventoVo;

public interface EventoService {

	public Evento findEventoById(Long id);

	public List<Evento> findAllEventos();

	public void newEvento(Evento evento);

	public void updateEvento(Evento evento);

	public void deleteEvento(Evento evento);

	public List<Evento> findAllEventosPendientes();

	public List<Evento> findAllEventosSancionados();

	public void insertPuntos(Evento evento, List<PuntosJugadorEvento> pje);

	public List<Mes> findMesesEventos();

	public List<Integer> findAniosEventos();

	SancionarEventoVo posicionesEvento(Long id);

	List<EventoVo> findProximosEventos();
}
