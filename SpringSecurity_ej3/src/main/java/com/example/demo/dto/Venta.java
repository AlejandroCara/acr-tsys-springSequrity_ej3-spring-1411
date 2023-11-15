package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "cajero")
	private Cajero cajero;
	
	@ManyToOne
	@JoinColumn(name = "producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "maquina")
	private MaquinaRegistradora maquina;

	public Venta() {
		
	}
	
	public Venta(int codigo, Cajero cajero, Producto producto, MaquinaRegistradora maquina) {
		this.codigo = codigo;
		this.cajero = cajero;
		this.producto = producto;
		this.maquina = maquina;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public MaquinaRegistradora getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinaRegistradora maquina) {
		this.maquina = maquina;
	}

	
}
