package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.respository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	public Page<Persona> findAll(Integer page, Integer size, Boolean enablePagination) {
		return personaRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
	}


	public List<Persona> findAll(Sort sort) {
		return personaRepository.findAll(sort);
	}


	public List<Persona> findAllById(Iterable<Long> ids) {
		return personaRepository.findAllById(ids);
	}


	public boolean existsById(Long id) {
		return personaRepository.existsById(id);
	}

	public long count() {
		return personaRepository.count();
	}

	public void deleteById(Long id) {
		personaRepository.deleteById(id);		
	}

	public void delete(Persona entity) {
		personaRepository.delete(entity);
	}

	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
}
