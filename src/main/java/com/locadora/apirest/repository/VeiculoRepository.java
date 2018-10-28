package com.locadora.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locadora.apirest.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	Veiculo findById(long idVeiculo);
	
	
	@Query(value = "SELECT DISTINCT * FROM veiculo u WHERE u.disponivel = ?", 
		       nativeQuery = true)
	List<Veiculo> findDisponivel(long disponivel);
}
