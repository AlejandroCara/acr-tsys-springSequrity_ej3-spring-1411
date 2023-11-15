package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajeroDAO;
import com.example.demo.dto.Cajero;

@Service
public class CajeroService implements ICajeroService{
	
	@Autowired(required = true)
	ICajeroDAO iCajeroDAO;

	@Override
	public List<Cajero> listAll() {
		return iCajeroDAO.findAll();
	}

	@Override
	public Cajero add(Cajero cajero) {
		return iCajeroDAO.save(cajero);
	}

	@Override
	public Cajero getOne(int codigo) {
		return iCajeroDAO.findById(codigo).get();
	}

	@Override
	public Cajero update(Cajero cajero) {
		return iCajeroDAO.save(cajero);
	}

	@Override
	public void eliminar(int codigo) {
		iCajeroDAO.deleteById(codigo);
	}
	
	
}
