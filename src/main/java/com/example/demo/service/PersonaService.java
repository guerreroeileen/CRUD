package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.respository.PersonaRepository;

@Service
public class PersonaService implements PersonaRepository{

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public List<Persona> findAll(Sort sort) {
		return personaRepository.findAll(sort);
	}

	@Override
	public List<Persona> findAllById(Iterable<Long> ids) {
		return personaRepository.findAllById(ids);
	}

	@Override
	public <S extends Persona> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Persona> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Persona> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Persona> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Persona> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return personaRepository.existsById(id);
	}

	@Override
	public long count() {
		return personaRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		personaRepository.deleteById(id);		
	}

	@Override
	public void delete(Persona entity) {
		personaRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Persona> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Persona> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Persona> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Persona> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Persona> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
	
	
	
	
	
}
