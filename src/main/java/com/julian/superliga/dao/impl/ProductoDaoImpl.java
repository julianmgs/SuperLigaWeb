package com.julian.superliga.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.ProductoDao;
import com.julian.superliga.model.Producto;

@Repository("productoDao")
public class ProductoDaoImpl extends AbstractDao<Long, Producto> implements ProductoDao  {

	@Override
	public Producto findById(Long id) {
		return super.findObjectById(id);
	}

	@Override
	public List<Producto> findAll() {
		return super.findAllObjects();
	}

}
