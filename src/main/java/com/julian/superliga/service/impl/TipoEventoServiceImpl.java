package com.julian.superliga.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.TipoEventoDao;
import com.julian.superliga.model.TipoEvento;
import com.julian.superliga.service.inter.TipoEventoService;

@Service("tipoEventoService")
@Transactional
public class TipoEventoServiceImpl implements TipoEventoService {

	@Autowired
	private TipoEventoDao tipoEventoDao;

	@Override
	public TipoEvento findTipoEventoById(Long id) {
		return tipoEventoDao.findById(id);
	}

	@Override
	public List<TipoEvento> findAllTiposEvento() {
		return tipoEventoDao.findAll();
	}

	@Override
	public void saveTipoEvento(TipoEvento tipoEvento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTipoEvento(TipoEvento tipoEvento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTipoEvento(TipoEvento tipoEvento) {
		// TODO Auto-generated method stub

	}

}
