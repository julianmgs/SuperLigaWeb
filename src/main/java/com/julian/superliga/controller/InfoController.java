package com.julian.superliga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julian.superliga.service.inter.EventoService;

@Controller
@ControllerAdvice
public class InfoController {
	
	@Autowired
	EventoService eventoService;

	@RequestMapping(value = { "/calendario" }, method = RequestMethod.GET)
	public String calendario(ModelMap model) {

		model.addAttribute("menuActive", "calendario");

		return "errors/under-construction";
	}

	@RequestMapping(value = { "/proximos" }, method = RequestMethod.GET)
	public String proximosEventos(ModelMap model) {

		model.addAttribute("eventos", this.eventoService.findProximosEventos());

		model.addAttribute("menuActive", "proximos");

		return "info/proximos-eventos";
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String about(ModelMap model) {

		model.addAttribute("menuActive", "about");

		return "errors/under-construction";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap model) {

		return "errors/403";
	}
	
}
