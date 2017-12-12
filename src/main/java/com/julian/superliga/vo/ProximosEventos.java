package com.julian.superliga.vo;

import java.util.List;

public class ProximosEventos {

	Mes mes;
	List<EventoVo> eventos;

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public List<EventoVo> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoVo> eventos) {
		this.eventos = eventos;
	}

}
