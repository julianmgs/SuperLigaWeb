package com.julian.superliga.service.inter;

import java.util.List;

import com.julian.superliga.model.TipoEvento;

public interface TipoEventoService {

	public TipoEvento findTipoEventoById(Long id);

	public List<TipoEvento> findAllTiposEvento();

	public void saveTipoEvento(TipoEvento tipoEvento);

	public void updateTipoEvento(TipoEvento tipoEvento);

	public void deleteTipoEvento(TipoEvento tipoEvento);
}
