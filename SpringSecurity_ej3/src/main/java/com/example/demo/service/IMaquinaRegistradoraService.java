package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	// Metodos del CRUD
	public List<MaquinaRegistradora> listAll();

	public MaquinaRegistradora add(MaquinaRegistradora maquina);

	public MaquinaRegistradora getOne(int codigo);

	public MaquinaRegistradora update(MaquinaRegistradora maquina);

	public void eliminar(int codigo);
	
}	
