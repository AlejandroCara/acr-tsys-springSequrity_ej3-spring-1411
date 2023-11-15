package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {

	// Metodos del CRUD
	public List<Venta> listAll();

	public Venta add(Venta venta);

	public Venta getOne(int codigo);

	public Venta update(Venta venta);

	public void eliminar(int codigo);
	
}
