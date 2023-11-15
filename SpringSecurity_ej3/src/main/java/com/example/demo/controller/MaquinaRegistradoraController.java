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

import com.example.demo.dto.MaquinaRegistradora;
import com.example.demo.service.MaquinaRegistradoraService;

@RestController
@RequestMapping("/maquina")
public class MaquinaRegistradoraController {

	@Autowired(required = true)
	MaquinaRegistradoraService maquinaRegistradoraService;
	
	@GetMapping("/all")
	public List<MaquinaRegistradora> listarMaquinas(){
		return maquinaRegistradoraService.listAll();
	}
	
	@PostMapping("/add")
	public MaquinaRegistradora guardarMaquina(@RequestBody MaquinaRegistradora maquina) {
		return maquinaRegistradoraService.add(maquina);
	}
	
	@GetMapping("/{codigo}")
	public MaquinaRegistradora listarUnaMaquina(@PathVariable(name="codigo") int codigo) {
		return maquinaRegistradoraService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public MaquinaRegistradora actualizarVenta(@PathVariable(name="codigo")int codigo,@RequestBody MaquinaRegistradora maquina) {
		
		MaquinaRegistradora preMaquina = new MaquinaRegistradora();
		MaquinaRegistradora newVenta = new MaquinaRegistradora();
		
		preMaquina = maquinaRegistradoraService.getOne(codigo);
		
		preMaquina.setPiso(maquina.getPiso());
		
		newVenta = maquinaRegistradoraService.update(preMaquina);
		
		return newVenta;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarVenta(@PathVariable(name="codigo")int codigo) {
		maquinaRegistradoraService.eliminar(codigo);
	}
}
