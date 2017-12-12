package com.julian.superliga.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.ProductoDao;
import com.julian.superliga.model.Producto;
import com.julian.superliga.service.inter.ProductoService;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	public Producto findProductoById(Long id) {
		return this.productoDao.findById(id);
	}

	@Override
	public List<Producto> findAllProductos() {
		return this.productoDao.findAll();
	}

}
