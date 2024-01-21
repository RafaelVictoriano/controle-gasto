package com.br.repository;

import com.br.entity.Gastos;
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
public class GastosRepository {

    private final MongoTemplate mongoTemplate;


    public Gastos save(Gastos gastos) {
        return mongoTemplate.save(gastos);
    }

    public List<Gastos> findByFilters(Map<String, Object> filters) {
        final var dynamicQuery = new Query();
        filters.forEach((key, value) -> {
            if (nonNull(value)) {
                final var criteria = Criteria.where(key).is(value);
                dynamicQuery.addCriteria(criteria);
            }
        });
        return mongoTemplate.find(dynamicQuery, Gastos.class, "gastos");
    }
}
