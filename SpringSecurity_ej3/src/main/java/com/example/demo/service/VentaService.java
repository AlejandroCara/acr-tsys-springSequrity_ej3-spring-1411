package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service
public class VentaService implements IVentaService{
	
	@Autowired(required = true)
	IVentaDAO iVentaDAO;

	@Override
	public List<Venta> listAll() {
		return iVentaDAO.findAll();
	}

	@Override
	public Venta add(Venta venta) {
		return iVentaDAO.save(venta);
	}

	@Override
	public Venta getOne(int codigo) {
		return iVentaDAO.findById(codigo).get();
	}

	@Override
	public Venta update(Venta venta) {
		return iVentaDAO.save(venta);
	}

	@Override
	public void eliminar(int codigo) {
		iVentaDAO.deleteById(codigo);
	}
}
