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

import com.locadora.apirest.models.Reserva;
import com.locadora.apirest.repository.ReservaRepository;

@RestController
@RequestMapping(value="/api")
public class ReservaController {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@GetMapping("/reservas")
	public List<Reserva> listaReservas(){
		return reservaRepository.findAll();
	}
	
	@GetMapping("/reserva/{id}")
	public Reserva reservaUnico(@PathVariable(value="id") long idReserva) {
		return reservaRepository.findById(idReserva);
	}
	
	@PostMapping("/reserva")
	public Reserva salvaReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);	
		
	}
	
	@DeleteMapping("/reserva")
	public void deletarVeiculo(@RequestBody Reserva reserva) {
		reservaRepository.delete(reserva);
	}
	
	@PutMapping("/reserva")
	public Reserva atualizaReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);
	}
		
}
