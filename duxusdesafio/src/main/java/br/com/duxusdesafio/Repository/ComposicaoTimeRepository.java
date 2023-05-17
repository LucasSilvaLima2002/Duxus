package br.com.duxusdesafio.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

public interface ComposicaoTimeRepository extends JpaRepository<ComposicaoTime, Long> {
	
	@Query(value = "select b.data,c.nome from composicao_time a\r\n"
			+ "INNER JOIN time as b on (b.id=a.time_id)\r\n"
			+ "INNER JOIN integrante as c on(c.id = a.integrante_id)\r\n"
			+ "where b.data = ?1",nativeQuery = true)
	List<ComposicaoTime> findByDate2(LocalDate data);
	

}
