package com.julian.superliga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julian.superliga.model.Producto;
import com.julian.superliga.service.inter.ProductoService;

@Controller
public class ProductosController {

	@Autowired
	private ProductoService productoService;

	@RequestMapping(value = { "/productos/new" }, method = RequestMethod.GET)
	public String newProducto(ModelMap model) {

		model.addAttribute("producto", new Producto());

		return "eventos/form-evento";
	}

	@RequestMapping(value = { "/productos/list" }, method = RequestMethod.GET)
	public String listProductos(ModelMap model) {

		model.addAttribute("productos", this.productoService.findAllProductos());

		return "tienda/list-productos";
	}

}
