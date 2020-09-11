package com.example.demo.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.respository.PersonaRepository;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/api/persona/")
public class PersonaRest {
	@Autowired
	private PersonaService personaService;
	
	
	@PostMapping
	public ResponseEntity<Persona> create (@RequestBody Persona persona) {
		Persona newPersonas = personaService.save(persona);
		try {
			return ResponseEntity.created(new URI("/api/persona/"+newPersonas.getId())).body(persona);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Persona>> getAll () {
		return ResponseEntity.ok(personaService.findAll());
	}
	
	@PostMapping ("/delete")
	public ResponseEntity<Void> deleteById (@RequestBody Persona persona) {
		try {
			personaService.delete(persona);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
