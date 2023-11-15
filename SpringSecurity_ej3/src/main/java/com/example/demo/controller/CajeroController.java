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

import com.example.demo.dto.Cajero;
import com.example.demo.service.ICajeroService;

@RestController
@RequestMapping("/cajero")
public class CajeroController {

	@Autowired(required = true)
	ICajeroService iCajeroServce;
	
	@GetMapping("/all")
	public List<Cajero> listarCajeros(){
		return iCajeroServce.listAll();
	}
	
	@PostMapping("/add")
	public Cajero guardarAsignacion(@RequestBody Cajero cajero) {
		return iCajeroServce.add(cajero);
	}
	
	@GetMapping("/{codigo}")
	public Cajero listarUnCajero(@PathVariable(name="codigo") int codigo) {
		return iCajeroServce.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name="codigo")int codigo,@RequestBody Cajero cajero) {
		
		Cajero prevCajero = new Cajero();
		Cajero newProyecto = new Cajero();
		
		prevCajero = iCajeroServce.getOne(codigo);
		
		prevCajero.setNomapels(cajero.getNomapels());
		
		newProyecto = iCajeroServce.update(prevCajero);
		
		return newProyecto;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void aliminarAsignacion(@PathVariable(name="codigo")int codigo) {
		iCajeroServce.eliminar(codigo);
	}
}
