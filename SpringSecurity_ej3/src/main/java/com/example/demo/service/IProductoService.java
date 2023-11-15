package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Producto;

public interface IProductoService {

	// Metodos del CRUD
	public List<Producto> listAll();

	public Producto add(Producto producto);

	public Producto getOne(int codigo);

	public Producto update(Producto producto);

	public void eliminar(int codigo);
}
