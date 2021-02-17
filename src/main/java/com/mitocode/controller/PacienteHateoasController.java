package com.mitocode.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;


@RestController
@RequestMapping("/hateoas/pacientes")
public class PacienteHateoasController {

	@Autowired
	private IPacienteService service;
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Paciente paciente) throws Exception {
		
		Paciente obj = service.registrar(paciente);
		
		// http://localhost:8080/pacientes/3
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdPaciente()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable Integer id) throws Exception {
		Paciente obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Paciente> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		
		Paciente obj = service.listarPorId(id);
		
		if(obj == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		//localhost:8080/pacientes/{id}
		EntityModel<Paciente> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		recurso.add(linkTo.withRel("paciente-recurso"));
		
		return recurso;
	}
}
