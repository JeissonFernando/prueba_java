package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información del OBJ Paciente")
@Entity
@Table(name = "paciente")
public class Paciente {

	@Schema(description = "Identificador del Paciente")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;

	@Schema(description = "Nombres del Paciente")
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Schema(description = "Apellidos del Paciente")
	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Schema(description = "Documento del Paciente")
	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;

	@Schema(description = "Dirección del Paciente")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;

	@Schema(description = "Teléfono del Paciente")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

	@Schema(description = "Email del Paciente")
	@Email	
	@Column(name = "email", nullable = false, length = 55)
	private String email;

	
	/*
	 * Getter & Setter
	 */
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
