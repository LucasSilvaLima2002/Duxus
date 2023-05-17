package br.com.duxusdesafio.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

public interface IntegranteRepository extends JpaRepository<Integrante, Long>{
	
	@Query("SELECT i FROM Integrante i WHERE i.nome = :nome")
	Integrante findByNome(String nome);
	
	

	
}
