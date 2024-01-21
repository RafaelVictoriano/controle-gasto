package com.br.dto.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Map;

public record GastosParamsDTO(String nome,
                              BigDecimal valor,
                              Integer ano,
                              Integer mes) {


        public Map<String, Object> toMap() {
        final var mapper = new ObjectMapper();
        return mapper.convertValue(this, new TypeReference<Map<String, Object>>() {});
    }
}