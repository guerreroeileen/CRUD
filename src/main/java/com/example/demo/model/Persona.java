package com.example.demo.model;

import com.example.demo.audit.Auditable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "Persona")
public class Persona extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	@Column(name = "nombre")
	private String nombre;

	@NotBlank
	@Column(name = "apellido")
	private String apellido;

	@Email
	@Column(name = "correo")
	private String correo;

	@Column(name = "edad")
	@NotNull
	private Integer edad;

	@NotNull
	@Column(name = "numero_documento_identificacion", unique = true)
	private Integer numeroDocumentoIdentificacion;

}
