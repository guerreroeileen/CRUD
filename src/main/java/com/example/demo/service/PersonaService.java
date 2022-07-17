package com.example.demo.service;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.model.Persona;
import com.example.demo.respository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonaService {

	private final PersonaRepository personaRepository;

	private final ModelMapper modelMapper;


	public Page<PersonaDTO> findAll(Integer page, Integer size, Boolean enablePagination) {
		return personaRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged()).map(this::convertToDto);
	}


	public List<PersonaDTO> findAll(Sort sort) {
		return personaRepository.findAll(sort).stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public List<PersonaDTO> findAllById(Iterable<Long> ids) {
		return personaRepository.findAllById(ids).stream().map(this::convertToDto).collect(Collectors.toList());
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

	public PersonaDTO save(PersonaDTO persona) {
		return convertToDto(personaRepository.save(this.modelMapper.map(persona, Persona.class)));
	}

	private PersonaDTO convertToDto(Persona persona) {
		return modelMapper.map(persona, PersonaDTO.class);
	}

}
