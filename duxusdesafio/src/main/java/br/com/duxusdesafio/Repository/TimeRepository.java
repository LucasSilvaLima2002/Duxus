package br.com.duxusdesafio.Repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.duxusdesafio.model.Time;

public interface TimeRepository extends JpaRepository<Time, Long>{

	@Query("SELECT i FROM Time i WHERE data = :data")
	List<Time> findByDate(LocalDate data);
	



	
	
	
}
