package com.avion.model;

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
	
	@Column(name="mostrador")
	String mostrador;
	
	@Column(name="puerta")
	int puerta;

	public Avion(String hora, String vuelo, String destino, String mostrador, int puerta) {
		super();
		this.hora = hora;
		this.vuelo = vuelo;
		this.destino = destino;
		this.mostrador = mostrador;
		this.puerta = puerta;
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

	public String getMostrador() {
		return mostrador;
	}

	public void setMostrador(String mostrador) {
		this.mostrador = mostrador;
	}

	public int getPuerta() {
		return puerta;
	}

	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}
	
	

}
