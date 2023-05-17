package br.com.duxusdesafio.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.Repository.ComposicaoTimeRepository;
import br.com.duxusdesafio.Repository.IntegranteRepository;
import br.com.duxusdesafio.Repository.TimeRepository;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

@RestController
@RequestMapping(value = "/user2")
public class Controller {

	@Autowired
	private ComposicaoTimeRepository composicaoTimerepository; //Repositorio da composicaoTime

	@Autowired
	private IntegranteRepository integranterepository; //Repositorio da integrante

	@Autowired
	private TimeRepository timeRepository; //Repositorio da time

	@GetMapping(value = "/composicao") //função que imprime a lista de composicaotime para teste
	public List<ComposicaoTime> getAll3() {

		return composicaoTimerepository.findAll();
	}

	@GetMapping(value = "/integrante") //função que imprime a lista de integrante para teste
	public List<Integrante> getAll2() { 

		return integranterepository.findAll();
	}

	@GetMapping(value = "/time") //função que imprime a lista de time para teste
	public List<Time> getAll() {

		return timeRepository.findAll();
	}

	@GetMapping(value = "/teste/{nome}") //função que imprime o integrante pelo nome para teste
	public Integrante findByNome(@PathVariable String nome) {
		System.out.println("oi");
		Integrante teste = integranterepository.findByNome(nome);
		return teste;
	}

	
	
	@PersistenceContext //Função para o primeiro exercicio, (ainda não esta funcionando)
    private EntityManager entityManager;
	@GetMapping(value = "/find")
    public List<ComposicaoTime> findAllEntities() {
        TypedQuery<ComposicaoTime> query = entityManager.createQuery("select b.data,c.nome from composicao_time a\r\n"
        		+ "INNER JOIN time as b on (b.id=a.time_id)\r\n"
        		+ "INNER JOIN integrante as c on(c.id = a.integrante_id)\r\n"
        		+ "where b.id = 1", ComposicaoTime.class);
        return query.getResultList();
    }

}
