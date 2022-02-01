package com.tinnova.desafio.infrastructure.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tinnova.desafio.domain.model.Veiculo;
import com.tinnova.desafio.domain.model.dto.DistribuicaoVeiculo;
import com.tinnova.desafio.domain.service.DistribuicaoVeiculoQueryService;

@Repository
public class DistribuicaoVeiculoQueryServiceImpl implements DistribuicaoVeiculoQueryService{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DistribuicaoVeiculo> consultarDistribuicaoVeiculo() {
		var builder = entityManager.getCriteriaBuilder();
		var query   = builder.createQuery(DistribuicaoVeiculo.class);
		var root    = query.from(Veiculo.class);
		
		var selection = builder.construct(DistribuicaoVeiculo.class,
				root.get("ano"),
				builder.count(root.get("id")));
		
		query.select(selection);
		query.groupBy(root.get("ano"));
		
		return entityManager.createQuery(query).getResultList();
	}

}
