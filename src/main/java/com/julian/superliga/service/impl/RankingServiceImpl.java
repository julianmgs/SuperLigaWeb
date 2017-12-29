package com.julian.superliga.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.PuntosJugadorEventoDao;
import com.julian.superliga.model.PuntosJugadorEvento;
import com.julian.superliga.model.json.JsonPuntosJugador;
import com.julian.superliga.model.json.JsonRankingMes;
import com.julian.superliga.model.json.JsonSearchRanking;
import com.julian.superliga.service.inter.RankingService;
import com.julian.superliga.vo.PuntosJugadorSeasonVo;

@Service("rankingService")
@Transactional
public class RankingServiceImpl implements RankingService {

	@Autowired
	private PuntosJugadorEventoDao pjeDao;

	@Override
	public List<PuntosJugadorSeasonVo> rankingSeason(int year, int month) {

		List<PuntosJugadorEvento> puntos = pjeDao.findBySeason(year, month);

		List<PuntosJugadorSeasonVo> puntosVo = new ArrayList<PuntosJugadorSeasonVo>();

		PuntosJugadorSeasonVo puntoVo;
		for (PuntosJugadorEvento p : puntos) {
			puntoVo = new PuntosJugadorSeasonVo();
			puntoVo.setJugador(p.getJugador());
			puntoVo.setPuntos(p.getPuntos() + 1);
			puntoVo.setEventosJugados(p.getEventosJugados());
			puntosVo.add(puntoVo);
		}

		return puntosVo;
	}

	@Override
	public List<PuntosJugadorSeasonVo> rankingSemestre(int year, int semestre) {

		List<PuntosJugadorEvento> puntos = pjeDao.findBySemestre(year, semestre);

		List<PuntosJugadorSeasonVo> puntosVo = new ArrayList<PuntosJugadorSeasonVo>();

		PuntosJugadorSeasonVo puntoVo;
		for (PuntosJugadorEvento p : puntos) {
			puntoVo = new PuntosJugadorSeasonVo();
			puntoVo.setJugador(p.getJugador());
			puntoVo.setPuntos(p.getPuntos() + 1);
			puntoVo.setEventosJugados(p.getEventosJugados());
			puntosVo.add(puntoVo);
		}

		return puntosVo;
	}
	
	@Override
	public JsonRankingMes buildJsonRankingMes(JsonSearchRanking sr) {
		
		List<PuntosJugadorEvento> puntos = pjeDao.findBySeason(sr.getAnio(), sr.getMes());

		JsonRankingMes jsonRankingMes = new JsonRankingMes();
		List<JsonPuntosJugador> ranking = new ArrayList<JsonPuntosJugador>();

		JsonPuntosJugador jsonPuntos;
		for (PuntosJugadorEvento p : puntos) {
			jsonPuntos = new JsonPuntosJugador();
			jsonPuntos.setDci(p.getJugador().getDci());
			jsonPuntos.setNombre(p.getJugador().getNombre());
			jsonPuntos.setApellido(p.getJugador().getApellido());
			jsonPuntos.setPuntos(p.getPuntos() + 1);
			jsonPuntos.setPuntos(p.getPuntos() + p.getEventosJugados()); // TODO Corroborar
			jsonPuntos.setEventosJugados(p.getEventosJugados());
			ranking.add(jsonPuntos);
		}
		
		jsonRankingMes.setRanking(ranking);
		
		return jsonRankingMes;
	}

}
