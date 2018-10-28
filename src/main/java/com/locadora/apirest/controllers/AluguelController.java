package com.locadora.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.apirest.models.Aluguel;

import com.locadora.apirest.repository.AluguelRepository;

@RestController
@RequestMapping(value="/api")
public class AluguelController {
	
	@Autowired
	AluguelRepository aluguelRepository;
	
	@GetMapping("/aluguels")
	public List<Aluguel> listaAluguels(){
		return aluguelRepository.findAll();
	}
	
	@GetMapping("/aluguel/{id}")
	public Aluguel aluguelUnico(@PathVariable(value="id") long idAluguel) {
		return aluguelRepository.findById(idAluguel);
	}
	
	@PostMapping("/aluguel")
	public Aluguel salvaAluguel(@RequestBody Aluguel aluguel) {
		return aluguelRepository.save(aluguel);	
		
	}
	
	@DeleteMapping("/aluguel")
	public void deletarVeiculo(@RequestBody Aluguel aluguel) {
		aluguelRepository.delete(aluguel);
	}
	
	@PutMapping("/aluguel")
	public Aluguel atualizaAluguel(@RequestBody Aluguel aluguel) {
		return aluguelRepository.save(aluguel);
	}
		
}
