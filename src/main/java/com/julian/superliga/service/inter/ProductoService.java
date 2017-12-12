package com.julian.superliga.service.inter;

import java.util.List;

import com.julian.superliga.model.Producto;

public interface ProductoService {

	public Producto findProductoById(Long id);

	public List<Producto> findAllProductos();

}
