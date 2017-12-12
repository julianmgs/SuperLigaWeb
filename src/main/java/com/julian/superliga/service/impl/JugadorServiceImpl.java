package com.julian.superliga.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.JugadorDao;
import com.julian.superliga.model.Jugador;
import com.julian.superliga.service.inter.JugadorService;

@Service("jugadorService")
@Transactional
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	private JugadorDao jugadorDao;

	@Override
	public Jugador findJugadorById(Long id) {
		return jugadorDao.findById(id);
	}

	@Override
	public List<Jugador> findAllJugadores() {
		return jugadorDao.findAll();
	}

	@Override
	public void newJugador(Jugador jugador) {
		jugadorDao.save(jugador);
	}

	@Override
	public void updateJugador(Jugador jugador) {
		Jugador entity = jugadorDao.findById(jugador.getId());
		if (entity != null) {
			entity.setNombre(jugador.getNombre());
			entity.setApellido(jugador.getApellido());
			entity.setDci(jugador.getDci());
			entity.setEventosJugador(jugador.getEventosJugador());
		}
	}

	@Override
	public void deleteJugador(Jugador jugador) {
		jugadorDao.delete(jugador);
	}

	@Override
	public Jugador findByDci(String dci) {
		return jugadorDao.findByDci(dci);
	}

}
