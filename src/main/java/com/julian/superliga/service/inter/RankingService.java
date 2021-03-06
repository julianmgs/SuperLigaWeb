package com.julian.superliga.service.inter;

import java.util.List;

import com.julian.superliga.model.json.JsonRankingMes;
import com.julian.superliga.model.json.JsonSearchRanking;
import com.julian.superliga.vo.PuntosJugadorSeasonVo;

public interface RankingService {

	public List<PuntosJugadorSeasonVo> rankingSeason(int year, int month);

	List<PuntosJugadorSeasonVo> rankingSemestre(int year, int semestre);

	JsonRankingMes buildJsonRankingMes(JsonSearchRanking mes);
}
