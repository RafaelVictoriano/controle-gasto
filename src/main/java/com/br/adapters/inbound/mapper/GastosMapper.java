package com.br.adapters.inbound.mapper;

import com.br.adapters.inbound.dto.GastosRequestDTO;
import com.br.adapters.outbound.dto.GastosResponseDTO;
import com.br.adapters.inbound.entity.Gastos;
import com.br.application.core.domain.GastosDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GastosMapper {

    GastosDomain toDomain(GastosRequestDTO dto);
    Gastos toEntity(GastosDomain dto);

    GastosResponseDTO toDto(Gastos entity);

    List<GastosResponseDTO> toDto(List<Gastos> entity);
}
