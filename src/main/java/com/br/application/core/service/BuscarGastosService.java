package com.br.application.core.service;

import com.br.adapters.inbound.dto.GastosFiltrosDTO;
import com.br.adapters.outbound.dto.GastosResponseDTO;
import com.br.adapters.inbound.mapper.GastosMapper;
import com.br.application.ports.inboud.BuscarGastosPort;
import com.br.application.ports.outbound.GastosRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuscarGastosService implements BuscarGastosPort {


    private final GastosRepositoryPort gastosRepositoryPort;

    private final GastosMapper gastosMapper;

    @Override
    public List<GastosResponseDTO> byParams(GastosFiltrosDTO filtroDTO) {
        log.info("Buscando nos gasto, por filtros, filtros:{}", filtroDTO);
        final var gastos = gastosRepositoryPort.buscarPorFiltros(filtroDTO.toMap());
        return gastosMapper.toDto(gastos);
    }
}
