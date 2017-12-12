package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.Producto;

public interface ProductoDao {

	public Producto findById(Long id);

	public List<Producto> findAll();
}
