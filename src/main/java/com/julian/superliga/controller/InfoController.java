package com.julian.superliga.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julian.superliga.service.inter.EmailService;
import com.julian.superliga.service.inter.EventoService;
import com.julian.superliga.vo.Mensaje;

@Controller
@ControllerAdvice
public class InfoController {
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	EmailService emailService;

	@RequestMapping(value = { "/calendario" }, method = RequestMethod.GET)
	public String calendario(ModelMap model) {

		return "errors/under-construction";
	}

	@RequestMapping(value = { "/proximos" }, method = RequestMethod.GET)
	public String proximosEventos(ModelMap model) {

		model.addAttribute("eventos", this.eventoService.findProximosEventos());

		return "info/proximos-eventos";
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String about(ModelMap model) {

		return "errors/under-construction";
	}
	
	@RequestMapping(value = { "/contacto" }, method = RequestMethod.GET)
	public String contacto(ModelMap model) {

		model.addAttribute("mensaje", new Mensaje());
		
		return "info/contacto";
	}
	
	@RequestMapping(value = { "/contacto" }, method = RequestMethod.POST)
	public String enviarMensaje(ModelMap model, @ModelAttribute("mensaje") Mensaje mensaje) throws IOException {

		emailService.sendEmailContacto(mensaje);
		
		return "info/contacto";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap model) {

		return "errors/403";
	}
	
}
