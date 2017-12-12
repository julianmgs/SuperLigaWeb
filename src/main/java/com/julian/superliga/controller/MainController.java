package com.julian.superliga.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julian.superliga.service.inter.EventoService;
import com.julian.superliga.service.inter.RankingService;
import com.julian.superliga.vo.Mes;
import com.julian.superliga.vo.PuntosJugadorSeasonVo;
import com.julian.superliga.vo.RankingMes;
import com.julian.superliga.vo.RankingSemestre;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	RankingService rankingService;

	@Autowired
	EventoService eventoService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(ModelMap model,
			@ModelAttribute("rankingMes") RankingMes rankingMes,
			@ModelAttribute("rankingSemestre") RankingSemestre rankingSemestre,
			BindingResult result) {

		// Mes mes = new Mes();
		// mes.setNroMes(Calendar.getInstance().get(Calendar.MONTH) + 1);
		int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int anio = Calendar.getInstance().get(Calendar.YEAR);

		List<PuntosJugadorSeasonVo> pjSeason = this.rankingService.rankingSeason(anio, mes);

		int semestre = 1;
		if (mes >= 7) {
			semestre = 2;
		}

		List<PuntosJugadorSeasonVo> pjSemestre = this.rankingService.rankingSemestre(anio, semestre);

		model.addAttribute("pjSeason", pjSeason);
		model.addAttribute("pjSemestre", pjSemestre);

		model.addAttribute("meses", this.inicializarMeses());

		model.addAttribute("anios", Arrays.asList(new Integer[] { 2017 }));

		model.addAttribute("rankingMes", new RankingMes(mes, anio));
		model.addAttribute("rankingSemestre", new RankingSemestre(semestre, anio));

		return "index";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String changeMesSemestreAnio(ModelMap model,
			@ModelAttribute("rankingMes") RankingMes rankingMes,
			BindingResult result) {

		Mes mes = new Mes();
		mes.setNroMes(Calendar.getInstance().get(Calendar.MONTH) + 1);
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		int semestre = 1;
		if (mes.getNroMes() >= 7) {
			semestre = 2;
		}
		List<PuntosJugadorSeasonVo> pjSeason = null;
		// List<PuntosJugadorSeasonVo> pjSemestre;
		if (rankingMes != null) { // Se cambio mes o a�o del ranking del mes
			pjSeason = this.rankingService.rankingSeason(rankingMes.getAnio(), rankingMes.getMes());

			// pjSemestre = this.rankingService.rankingSemestre(anio, semestre);
		} else { // Se cambio semestre o a�o del ranking del semestre
			/*-
			pjSeason = this.rankingService.rankingSeason(anio, mes.getNroMes());

			pjSemestre = this.rankingService.rankingSemestre(
					rankingSemestre.getAnio(), rankingSemestre.getSemestre());
			 */
		}

		model.addAttribute("pjSeason", pjSeason);
		// model.addAttribute("pjSemestre", pjSemestre);

		model.addAttribute("meses", this.inicializarMeses());

		model.addAttribute("anios", Arrays.asList(new Integer[] { 2017 }));

		model.addAttribute("rankingMes", rankingMes);
		// model.addAttribute("rankingSemestre", rankingSemestre);

		return "index";
	}

	private List<Mes> inicializarMeses() {
		List<Mes> meses = new ArrayList<Mes>();

		meses.add(new Mes(1, "Enero", "ENE"));
		meses.add(new Mes(2, "Febrero", "FEB"));
		meses.add(new Mes(3, "Marzo", "MAR"));
		meses.add(new Mes(4, "Abril", "ABR"));
		meses.add(new Mes(5, "Mayo", "MAY"));
		meses.add(new Mes(6, "Junio", "JUN"));
		meses.add(new Mes(7, "Julio", "JUL"));
		meses.add(new Mes(8, "Agosto", "AGO"));
		meses.add(new Mes(9, "Septiembre", "SEP"));
		meses.add(new Mes(10, "Octubre", "OCT"));
		meses.add(new Mes(11, "Noviembre", "NOV"));
		meses.add(new Mes(12, "Diciembre", "DIC"));

		return meses;
	}
}
