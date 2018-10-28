package com.locadora.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findById(long idCliente);
	
}
