package com.br.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GastosResponseDTO(String id, String nome, BigDecimal valor, Integer ano, Integer mes,
                                Integer paracelaAtual, Integer parcelaFinal) {

}
