package com.br.adapters.inbound.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record GastosRequestDTO(String nome, BigDecimal valor, Integer ano, Integer mes,
                               Integer paracelaAtual, Integer parcelaFinal) {


}
