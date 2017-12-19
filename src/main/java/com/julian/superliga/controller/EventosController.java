package com.julian.superliga.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julian.superliga.model.Evento;
import com.julian.superliga.model.Jugador;
import com.julian.superliga.model.PuntosJugadorEvento;
import com.julian.superliga.service.inter.EventoService;
import com.julian.superliga.service.inter.FormatoService;
import com.julian.superliga.service.inter.JugadorService;
import com.julian.superliga.service.inter.PuntosJugadorEventoService;
import com.julian.superliga.service.inter.TipoEventoService;
import com.julian.superliga.vo.JugadorPuntos;
import com.julian.superliga.vo.SancionarEventoVo;

@Controller
public class EventosController {

	@Autowired
	EventoService eventoService;

	@Autowired
	TipoEventoService tipoEventoService;

	@Autowired
	FormatoService formatoService;

	@Autowired
	JugadorService jugadorService;

	@Autowired
	PuntosJugadorEventoService pjeService;
	
	private static final Logger logger = Logger.getLogger(EventosController.class);
	
	@RequestMapping(value = { "/eventos/new" }, method = RequestMethod.GET)
	public String newEvento(ModelMap model) {

		model.addAttribute("evento", new Evento());
		model.addAttribute("tiposEvento", tipoEventoService.findAllTiposEvento());
		model.addAttribute("formatos", formatoService.findAllFormatos());

		return "eventos/form-evento";
	}
	
	@RequestMapping(value = { "/eventos/upload" }, method = RequestMethod.GET)
	public String uploadEvento(ModelMap model) {

		return "eventos/upload-evento";
	}

	/**
	 * Upload single file using Spring Controller
	 * @throws IOException 
	 */
	@RequestMapping(value = "/eventos/upload", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) 
			throws IOException {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		
		InputStream inputStream = file.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		
		return "redirect:/uploadStatus";
	}
	
	@RequestMapping(value = { "/eventos/save" }, method = RequestMethod.POST, params = "create")
	public String createEvento(ModelMap model, @ModelAttribute("evento") Evento evento, BindingResult result) {

		evento.setTipoEvento(tipoEventoService.findTipoEventoById(evento.getTipoEvento().getId()));
		evento.setFormato(formatoService.findFormatoById(evento.getFormato().getId()));

		eventoService.newEvento(evento);

		return "redirect:/eventos/list";
	}

	@RequestMapping(value = { "/eventos/edit" }, method = RequestMethod.GET)
	public String editEvento(ModelMap model, @RequestParam(value = "id") Long id) {

		model.addAttribute("evento", eventoService.findEventoById(id));

		model.addAttribute("tiposEvento", tipoEventoService.findAllTiposEvento());
		model.addAttribute("formatos", formatoService.findAllFormatos());

		return "eventos/form-evento";
	}

	@RequestMapping(value = { "/eventos/save" }, method = RequestMethod.POST, params = "update")
	public String updateEvento(ModelMap model, @ModelAttribute("evento") Evento evento, BindingResult result) {

		evento.setTipoEvento(tipoEventoService.findTipoEventoById(evento.getTipoEvento().getId()));
		evento.setFormato(formatoService.findFormatoById(evento.getFormato().getId()));

		eventoService.updateEvento(evento);

		return "redirect:/eventos/list";
	}

	@RequestMapping(value = { "/eventos/cancel" }, method = RequestMethod.GET)
	public String cancelarEvento(ModelMap model, @RequestParam(value = "id") Long id) {

		eventoService.deleteEvento(eventoService.findEventoById(id));

		return "redirect:/eventos/list";
	}

	@RequestMapping(value = { "/eventos/list" }, method = RequestMethod.GET)
	public String listEventos(ModelMap model) {

		model.addAttribute("eventosPendientes", eventoService.findAllEventosPendientes());
		model.addAttribute("eventosSancionados", eventoService.findAllEventosSancionados());

		return "eventos/list-eventos";
	}

	@RequestMapping(value = { "/eventos/sancionar" }, method = RequestMethod.GET)
	public String sancionarEvento(ModelMap model,
			@RequestParam(value = "id") Long id, String error, RedirectAttributes redirectAttributes) {

		SancionarEventoVo eventoVo = new SancionarEventoVo();

		eventoVo.setEvento(eventoService.findEventoById(id));
		eventoVo.setJugadoresList(jugadorService.findAllJugadores());

		//redirectAttributes.addAttribute("error", redirectAttribute);
		model.addAttribute("eventoVo", eventoVo);
		model.addAttribute("newJugador", new Jugador());

		return "eventos/sancionar-evento";
	}

	@RequestMapping(value = { "/eventos/confirmar" }, method = RequestMethod.POST)
	public String confirmarRankingEvento(ModelMap model,
			@ModelAttribute("eventoVo") SancionarEventoVo eventoVo,
			BindingResult result) {

		eventoVo.setRankingFinal(calcularRankEvento(eventoVo));
		eventoVo.setEvento(eventoService.findEventoById(eventoVo.getEvento()
				.getId()));
		model.addAttribute("eventoVo", eventoVo);

		return "eventos/confirmar-evento";
	}

	@RequestMapping(value = { "/eventos/confirmarok" }, method = RequestMethod.POST)
	public String saveRankingEvento(ModelMap model,
			@ModelAttribute("eventoVo") SancionarEventoVo eventoVo,
			BindingResult result) {

		eventoService.insertPuntos(
				eventoService.findEventoById(eventoVo.getEvento().getId()),
				eventoVo.getRankingFinal());

		return "redirect:/eventos/list";
	}

	/*-
	@RequestMapping(value = { "/eventos/confirmarok" }, method = RequestMethod.POST, params = { "volver" })
	public String volverSancionarEvento(ModelMap model,
			@ModelAttribute("eventoVo") SancionarEventoVo eventoVo,
			BindingResult result) {

		eventoVo.setEvento(eventoService.findEventoById(eventoVo.getEvento()
				.getId()));
		eventoVo.setJugadoresList(jugadorService.findAllJugadores());

		model.addAttribute("eventoVo", eventoVo);
		model.addAttribute("newJugador", new Jugador());

		return "eventos/sancionar-evento";
	}
	 */

	@RequestMapping(value = { "/eventos/posiciones" }, method = RequestMethod.GET)
	public String viewRankingEvento(ModelMap model, @RequestParam(value = "id") Long id) {

		model.addAttribute("eventoVo", eventoService.posicionesEvento(id));

		return "eventos/posiciones-evento";
	}

	private List<PuntosJugadorEvento> calcularRankEvento(SancionarEventoVo eventoVo) {
		List<PuntosJugadorEvento> pjeList = new ArrayList<PuntosJugadorEvento>();

		PuntosJugadorEvento pje;
		for (JugadorPuntos jp : eventoVo.getJugadoresPuntos()) {
			if (jp.getChecked()) {
				pje = new PuntosJugadorEvento();
				pje.setEvento(eventoVo.getEvento());
				pje.setJugador(jugadorService.findJugadorById(jp.getJugador().getId()));
				pje.setPuntos(jp.getPuntos());
				pjeList.add(pje);
			}
		}

		Collections.sort(pjeList, PuntosJugadorEvento.PuntosJugadorEventoComparator);

		return pjeList;
	}
}
