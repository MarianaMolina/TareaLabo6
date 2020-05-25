package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table 
public class Importancia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_importancia")
	private Integer id_importancia;
	
	@Size(message ="El campo no debe contener mas de 30 caracteres", max =30)
	@NotEmpty(message ="Este campo no puede estar vacio")
	@Column(name="importancia")
	private String importancia;

	//Constructor
	public Importancia() {
		super();
	}

	//getters y setters
	
	public Integer getId_importancia() {
		return id_importancia;
	}

	public void setId_importancia(Integer id_importancia) {
		this.id_importancia = id_importancia;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	
	

}
