package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaRegistradoraDAO;
import com.example.demo.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraService implements IMaquinaRegistradoraService{
	
	@Autowired(required = true)
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;

	@Override
	public List<MaquinaRegistradora> listAll() {
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora add(MaquinaRegistradora maquina) {
		return iMaquinaRegistradoraDAO.save(maquina);
	}

	@Override
	public MaquinaRegistradora getOne(int codigo) {
		return iMaquinaRegistradoraDAO.findById(codigo).get();
	}

	@Override
	public MaquinaRegistradora update(MaquinaRegistradora maquina) {
		return iMaquinaRegistradoraDAO.save(maquina);
	}

	@Override
	public void eliminar(int codigo) {
		iMaquinaRegistradoraDAO.deleteById(codigo);
	}
}
