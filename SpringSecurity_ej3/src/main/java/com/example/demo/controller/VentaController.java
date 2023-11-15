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

import com.example.demo.dto.Venta;
import com.example.demo.service.VentaService;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired(required = true)
	VentaService ventaService;
	
	@GetMapping("/all")
	public List<Venta> listarVentas(){
		return ventaService.listAll();
	}
	
	@PostMapping("/add")
	public Venta guardarVenta(@RequestBody Venta venta) {
		return ventaService.add(venta);
	}
	
	@GetMapping("/{codigo}")
	public Venta listarUnaVenta(@PathVariable(name="codigo") int codigo) {
		return ventaService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Venta actualizarVenta(@PathVariable(name="codigo")int codigo,@RequestBody Venta producto) {
		
		Venta prevVenta = new Venta();
		Venta newVenta = new Venta();
		
		prevVenta = ventaService.getOne(codigo);
		
		prevVenta.setCajero(producto.getCajero());
		prevVenta.setMaquina(producto.getMaquina());
		prevVenta.setProducto(producto.getProducto());
		
		newVenta = ventaService.update(prevVenta);
		
		return newVenta;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarVenta(@PathVariable(name="codigo")int codigo) {
		ventaService.eliminar(codigo);
	}
}
