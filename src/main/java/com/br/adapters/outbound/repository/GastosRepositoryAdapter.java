package com.br.adapters.outbound.repository;

import com.br.adapters.inbound.entity.Gastos;
import com.br.application.ports.outbound.GastosRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Repository
public class GastosRepositoryAdapter implements GastosRepositoryPort {

    private final MongoTemplate mongoTemplate;

    @Override
    public Gastos salvar(Gastos gastos) {
        return mongoTemplate.save(gastos);
    }

    @Override
    public List<Gastos> buscarPorFiltros(Map<String, Object> filtros) {
        final var dynamicQuery = new Query();
        filtros.forEach((key, value) -> {
            if (nonNull(value)) {
                final var criteria = Criteria.where(key).is(value);
                dynamicQuery.addCriteria(criteria);
            }
        });
        return mongoTemplate.find(dynamicQuery, Gastos.class, "gastos");
    }
}
