package com.br.application.core.service;

import com.br.adapters.inbound.dto.GastosRequestDTO;
import com.br.adapters.outbound.dto.GastosResponseDTO;
import com.br.adapters.inbound.mapper.GastosMapper;
import com.br.application.core.domain.GastosDomain;
import com.br.application.ports.inboud.LancarGastosPort;
import com.br.application.ports.outbound.GastosRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
public class LancarGastosService implements LancarGastosPort {

    private final GastosRepositoryPort gastosRepositoryPort;

    private final GastosMapper mapper;

    @Override
    public GastosResponseDTO start(GastosDomain gastosDomain) {
        log.info("Lançando gastos, body:{}", gastosDomain);
        final var entity = gastosRepositoryPort.salvar(mapper.toEntity(gastosDomain));
        log.info("Gastis lançados, body:{}", gastosDomain);
        return mapper.toDto(entity);
    }
}
