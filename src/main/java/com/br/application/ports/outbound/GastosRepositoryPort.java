package com.br.application.ports.outbound;

import com.br.adapters.inbound.entity.Gastos;

import java.util.List;
import java.util.Map;

public interface GastosRepositoryPort {

    Gastos salvar(Gastos gastos);

    List<Gastos> buscarPorFiltros(Map<String, Object> filtros);
}
