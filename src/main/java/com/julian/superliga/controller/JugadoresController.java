package com.julian.superliga.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julian.superliga.model.Jugador;
import com.julian.superliga.service.inter.JugadorService;

@Controller
public class JugadoresController {

	@Autowired
	JugadorService jugadorService;

	@RequestMapping(value = { "/jugadores/new" }, method = RequestMethod.POST)
	public String createJugador(RedirectAttributes redirectAttributes,
			@ModelAttribute("newJugador") Jugador jugador,
			BindingResult result,
			HttpServletRequest request) {

		if (jugadorService.findByDci(jugador.getDci()) == null) {
			jugadorService.newJugador(jugador);
		} else {
			redirectAttributes.addFlashAttribute("error", "Ya existe un jugador con el mismo #DCI.");
		}

		return "redirect:" + request.getHeader("Referer");
	}
}
