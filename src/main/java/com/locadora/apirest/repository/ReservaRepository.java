package com.locadora.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.apirest.models.Reserva;

	public interface ReservaRepository extends JpaRepository<Reserva, Long> {
		
	}

