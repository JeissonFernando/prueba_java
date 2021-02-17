package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService service;
	
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar() throws Exception {
		List<Consulta> lista = service.listar();
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Consulta> registrar(@Valid @RequestBody ConsultaListaExamenDTO consulta) throws Exception {
		Consulta obj = service.registrarTransaccional(consulta);
		return new ResponseEntity<Consulta>(obj, HttpStatus.CREATED); 
	}
	
	
	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta consulta) throws Exception {
		Consulta obj = service.modificar(consulta);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable Integer id) throws Exception {
		Consulta obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
		Consulta obj = service.listarPorId(id);
		if (obj.getIdConsulta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
