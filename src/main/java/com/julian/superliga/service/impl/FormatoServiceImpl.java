package com.julian.superliga.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.FormatoDao;
import com.julian.superliga.model.Formato;
import com.julian.superliga.service.inter.FormatoService;

@Service("formatoService")
@Transactional
public class FormatoServiceImpl implements FormatoService {

	@Autowired
	private FormatoDao formatoDao;

	@Override
	public Formato findFormatoById(Long id) {
		return formatoDao.findById(id);
	}

	@Override
	public List<Formato> findAllFormatos() {
		return formatoDao.findAll();
	}

	@Override
	public void newFormato(Formato formato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFormato(Formato formato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFormato(Formato formato) {
		// TODO Auto-generated method stub

	}

}
