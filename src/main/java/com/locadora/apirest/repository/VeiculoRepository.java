package com.locadora.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.apirest.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	Veiculo findById(long idVeiculo);
}
