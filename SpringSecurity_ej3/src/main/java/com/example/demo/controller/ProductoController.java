package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoService;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired(required = true)
	ProductoService productoService;
	
	@GetMapping("/all")
	public List<Producto> listarProductos(){
		return productoService.listAll();
	}
	
	@PostMapping("/add")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoService.add(producto);
	}
	
	@GetMapping("/{codigo}")
	public Producto listarUnaAsignacion(@PathVariable(name="codigo") int codigo) {
		return productoService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Producto actualizarAsignacion(@PathVariable(name="codigo")int codigo,@RequestBody Producto producto) {
		
		Producto prevProducto = new Producto();
		Producto newProducto = new Producto();
		
		prevProducto = productoService.getOne(codigo);
		
		prevProducto.setNombre(producto.getNombre());
		prevProducto.setPrecio(producto.getPrecio());
		
		newProducto = productoService.update(prevProducto);
		
		return newProducto;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void aliminarAsignacion(@PathVariable(name="codigo")int codigo) {
		productoService.eliminar(codigo);
	}
}
