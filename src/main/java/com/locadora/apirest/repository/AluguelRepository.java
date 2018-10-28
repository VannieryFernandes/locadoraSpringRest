package com.locadora.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.apirest.models.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
	Aluguel findById(long idAluguel);
	
}