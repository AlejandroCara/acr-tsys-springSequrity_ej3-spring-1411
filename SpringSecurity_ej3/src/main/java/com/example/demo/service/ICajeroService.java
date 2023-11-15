package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajero;

public interface ICajeroService {
	
	// Metodos del CRUD
	public List<Cajero> listAll();

	public Cajero add(Cajero cajero);

	public Cajero getOne(int codigo);

	public Cajero update(Cajero cajero);

	public void eliminar(int codigo);
	
}
