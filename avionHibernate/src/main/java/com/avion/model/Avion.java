package com.avion.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="salida")
public class Avion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="hora")
	String hora;
	
	@Column(name="vuelo")
	String vuelo;
	
	@Column(name="destino")
	String destino;
	
	@Column(name="mostrador1")
	int mostrador1;
	
	@Column(name="mostrador2")
	int mostrador2;
	
	@Column(name="puerta")
	int puerta;
	
	@Column(name="fecha")
	LocalDate fecha;

	

	public Avion(String hora, String vuelo, String destino, int mostrador1, int mostrador2, int puerta, LocalDate fecha) {
		super();
		this.hora = hora;
		this.vuelo = vuelo;
		this.destino = destino;
		this.mostrador1 = mostrador1;
		this.mostrador2 = mostrador2;
		this.puerta = puerta;
		this.fecha = fecha;
	}

	public Avion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getVuelo() {
		return vuelo;
	}

	public void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getMostrador1() {
		return mostrador1;
	}

	public void setMostrador1(int mostrador1) {
		this.mostrador1 = mostrador1;
	}
	
	public int getMostrador2() {
		return mostrador2;
	}

	public void setMostrador2(int mostrador2) {
		this.mostrador2 = mostrador2;
	}

	public int getPuerta() {
		return puerta;
	}

	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
