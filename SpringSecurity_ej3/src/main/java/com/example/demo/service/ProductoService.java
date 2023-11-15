package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

@Service
public class ProductoService implements IProductoService{

	 @Autowired(required = true)
	 IProductoDAO iProductoDAO;

	@Override
	public List<Producto> listAll() {
		return iProductoDAO.findAll();
	}

	@Override
	public Producto add(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto getOne(int codigo) {
		return iProductoDAO.findById(codigo).get();
	}

	@Override
	public Producto update(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminar(int codigo) {
		iProductoDAO.deleteById(codigo);
	}
}
