package com.example.demo.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name= "contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contribuyente")
	private Integer id_Contribuyente;
	
	@Size(message ="El campo no debe contener mas de 30 caracteres", max =30)
	@NotEmpty(message ="Este campo no puede estar vacio")
	@Column(name="nombre")
	private String nombre;
	
	@Size(message ="El campo no debe contener mas de 30 caracteres", max =30)
	@NotEmpty(message ="Este campo no puede estar vacio")
	@Column(name="apellido")
	private String apellido;
	
	@NotNull(message ="Este campo no puede estar vacio")
	@Column(name="nit")
	private Integer nit;
	
	@Column(name="fecha_ingrso")
	private Date fecha_ingrso;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_importancia")
	private Importancia id_importancia;
	
	//CONTRUCTOR
	
	public Contribuyente() {
	
	}
	
	//SETTER AND GETTERS

	public Integer getId_Contribuyente() {
		return id_Contribuyente;
	}

	public void setId_Contribuyente(Integer id_Contribuyente) {
		this.id_Contribuyente = id_Contribuyente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getNit() {
		return nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public Date getFecha_ingrso() {
		return fecha_ingrso;
	}

	public void setFecha_ingrso(Date fecha_ingrso) {
		this.fecha_ingrso = fecha_ingrso;
	}

	public Importancia getId_importancia() {
		return id_importancia;
	}

	public void setId_importancia(Importancia id_importancia) {
		this.id_importancia = id_importancia;
	}
	

	
	
	
}
