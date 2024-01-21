package com.br.service.impl;

import com.br.dto.request.GastosRequestDTO;
import com.br.dto.response.GastosResponseDTO;
import com.br.mapper.GastosMapper;
import com.br.repository.GastosRepository;
import com.br.service.LancarGastosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LancarGastosServiceImpl implements LancarGastosService {

    private final GastosRepository repository;

    private final GastosMapper mapper;

    @Override
    public GastosResponseDTO start(GastosRequestDTO requestDTO) {
       log.info("Lançando gastos, body:{}", requestDTO);
       final var entity = repository.save(mapper.toEntity(requestDTO));
       log.info("Gastis lançados, body:{}", requestDTO);
        return mapper.toDto(entity);
    }
}
