package com.julian.superliga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.PuntosJugadorEventoDao;
import com.julian.superliga.model.PuntosJugadorEvento;
import com.julian.superliga.service.inter.PuntosJugadorEventoService;

@Service("puntosJugadorEventoService")
@Transactional
public class PuntosJugadorEventoServiceImpl implements PuntosJugadorEventoService {

	@Autowired
	PuntosJugadorEventoDao pjeDao;

	@Override
	public void newPuntosJugadorEvento(PuntosJugadorEvento pje) {
		pjeDao.save(pje);
	}

}
