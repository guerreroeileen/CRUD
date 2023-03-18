package com.example.demo.controller;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("persona/")
@RequiredArgsConstructor
public class PersonaController {

	private final PersonaService personaService;

	@PostMapping
	public ResponseEntity<PersonaDTO> create (@Valid @RequestBody PersonaDTO persona) {
		try {
			PersonaDTO newPersonas = personaService.save(persona);
			return ResponseEntity.created(new URI("/api/persona/" + newPersonas.getNumeroDocumentoIdentificacion())).body(persona);
		} catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Page<PersonaDTO>> getAll (
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer size,
			@RequestParam(required = false, defaultValue = "false") Boolean enablePagination
	) {
		return ResponseEntity.ok(personaService.findAll(page, size, enablePagination));
	}
	
	@PostMapping ("delete")
	public ResponseEntity<Void> deleteById (@RequestBody Persona persona) {
		try {
			personaService.delete(persona);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
