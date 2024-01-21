package com.br.service.impl;

import com.br.dto.request.GastosParamsDTO;
import com.br.dto.response.GastosResponseDTO;
import com.br.mapper.GastosMapper;
import com.br.repository.GastosRepository;
import com.br.service.BuscarGastosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuscarGastosServiceImpl implements BuscarGastosService {


    private final GastosRepository gastosRepository;

    private final GastosMapper gastosMapper;

    @Override
    public List<GastosResponseDTO> byParams(String nome, BigDecimal valor, Integer ano, Integer mes) {
        log.info("Buscando nos gasto, por filtros, nome:{}, valor:{}, ano:{}, mes:{}", nome, valor, ano, mes);
        final var gastos = gastosRepository.findByFilters(new GastosParamsDTO(nome, valor, ano, mes).toMap());
        return gastosMapper.toDto(gastos);
    }
}
