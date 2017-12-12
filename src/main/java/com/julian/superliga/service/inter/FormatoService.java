package com.julian.superliga.service.inter;

import java.util.List;

import com.julian.superliga.model.Formato;

public interface FormatoService {

	public Formato findFormatoById(Long id);

	public List<Formato> findAllFormatos();

	public void newFormato(Formato formato);

	public void updateFormato(Formato formato);

	public void deleteFormato(Formato formato);
}
