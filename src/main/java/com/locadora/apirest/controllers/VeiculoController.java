package com.locadora.apirest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.apirest.models.Veiculo;
import com.locadora.apirest.repository.VeiculoRepository;
@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping(value="/api")
public class VeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@GetMapping("/veiculos")
	public List<Veiculo> listaVeiculos(){
		return veiculoRepository.findAll();
	}
	
	@GetMapping("/veiculo/{id}")
	public Veiculo veiculoUnico(@PathVariable(value="id") long idVeiculo) {
		return veiculoRepository.findById(idVeiculo);
	}
	
	@PostMapping("/veiculo")
	public Veiculo salvaVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);	
		
	}
	
	@DeleteMapping("/veiculo")
	public void deletarVeiculo(@RequestBody Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
	}
	
	@PutMapping("/veiculo")
	public Veiculo atualizaVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
		

}
