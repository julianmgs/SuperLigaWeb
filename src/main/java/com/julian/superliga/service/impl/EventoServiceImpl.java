package com.julian.superliga.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.EventoDao;
import com.julian.superliga.dao.inter.JugadorDao;
import com.julian.superliga.model.Evento;
import com.julian.superliga.model.Formato;
import com.julian.superliga.model.PuntosJugadorEvento;
import com.julian.superliga.service.inter.EventoService;
import com.julian.superliga.utils.Constants;
import com.julian.superliga.vo.EventoVo;
import com.julian.superliga.vo.Mes;
import com.julian.superliga.vo.SancionarEventoVo;

@Service("eventoService")
@Transactional
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoDao eventoDao;

	@Autowired
	private JugadorDao jugadorDao;

	@Override
	public Evento findEventoById(Long id) {
		return eventoDao.findById(id);
	}

	@Override
	public List<Evento> findAllEventos() {
		return eventoDao.findAll();
	}

	@Override
	public void newEvento(Evento evento) {
		eventoDao.save(evento);
	}

	@Override
	public void updateEvento(Evento evento) {
		Evento entity = eventoDao.findById(evento.getId());
		if (entity != null) {
			entity.setDescripcion(evento.getDescripcion());
			entity.setFecha(evento.getFecha());
			entity.setFormato(evento.getFormato());
			entity.setPuntosJugador(evento.getPuntosJugador());
			entity.setTipoEvento(evento.getTipoEvento());
		}
	}

	@Override
	public void deleteEvento(Evento evento) {
		eventoDao.delete(evento);
	}

	@Override
	public List<Evento> findAllEventosPendientes() {

		List<Evento> eventos = eventoDao.findAll();

		for (Iterator<Evento> iterator = eventos.iterator(); iterator.hasNext();) {
			Evento evento = iterator.next();
			if (!evento.getPuntosJugador().isEmpty()) {
				iterator.remove();
			}
		}

		return eventos;
	}

	@Override
	public List<Evento> findAllEventosSancionados() {
		List<Evento> eventos = eventoDao.findAll();

		for (Iterator<Evento> iterator = eventos.iterator(); iterator.hasNext();) {
			Evento evento = iterator.next();
			if (evento.getPuntosJugador().isEmpty()) {
				iterator.remove();
			}
		}

		return eventos;
	}

	@Override
	public void insertPuntos(Evento evento, List<PuntosJugadorEvento> pje) {

		Set<PuntosJugadorEvento> pjeSet = new HashSet<PuntosJugadorEvento>(pje);
		evento = eventoDao.findById(evento.getId());

		for (Iterator<PuntosJugadorEvento> iterator = pjeSet.iterator(); iterator.hasNext();) {
			PuntosJugadorEvento puntosJugadorEvento = iterator.next();

			puntosJugadorEvento.setEvento(evento);
			puntosJugadorEvento.setJugador(jugadorDao.findById(puntosJugadorEvento.getJugador().getId()));
			puntosJugadorEvento.getJugador().getEventosJugador().add(puntosJugadorEvento);
		}

		evento.setPuntosJugador(pjeSet);
	}

	@Override
	public SancionarEventoVo posicionesEvento(Long id) {

		Evento e = eventoDao.findById(id);

		List<PuntosJugadorEvento> posiciones = new ArrayList<PuntosJugadorEvento>(e.getPuntosJugador());

		Collections.sort(posiciones);

		SancionarEventoVo eventoVo = new SancionarEventoVo();

		eventoVo.setEvento(e);
		eventoVo.setRankingFinal(posiciones);

		return eventoVo;
	}

	@Override
	public List<EventoVo> findProximosEventos() {

		List<Evento> eventos = eventoDao.findAfterDate(new Date());
		Collections.sort(eventos);

		// List<ProximosEventos> proxEventosList = new
		// ArrayList<ProximosEventos>();
		// ProximosEventos pEventos;

		EventoVo eventoVo;
		List<EventoVo> evoList = new ArrayList<EventoVo>();
		for (Evento e : eventos) {
			eventoVo = new EventoVo();
			eventoVo.setEvento(e);
			eventoVo.setImg(findImagen(e.getFormato()));
			evoList.add(eventoVo);
		}

		return evoList;
	}

	private String findImagen(Formato formato) {
		switch (formato.getNombre()) {
		case Constants.COMMANDER:
			return Constants.IMG_COMMANDER;
		case Constants.STANDARD:
			return Constants.IMG_STANDARD;
		default:
			return Constants.IMG_STANDARD;
		}
	}

	@Override
	public List<Mes> findMesesEventos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findAniosEventos() {
		// TODO Auto-generated method stub
		return null;
	}

}
