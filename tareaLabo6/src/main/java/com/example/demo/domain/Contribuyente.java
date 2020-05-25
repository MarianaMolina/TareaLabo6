package com.example.demo.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contribuyente")
	private Integer codigoContribuyente;
	
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
	private Date fecha_ingreso;
	
	@Column(name="id_importancia")
	@OneToMany(fetch=FetchType.EAGER)
	private Integer id_importancia;
	
	//CONTRUCTOR
	
	public Contribuyente() {
	
	}

	//SETTER AND GETTERS
	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}

	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
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

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Integer getId_importancia() {
		return id_importancia;
	}

	public void setId_importancia(Integer id_importancia) {
		this.id_importancia = id_importancia;
	}
	
	
}
