package com.br.mapper;

import com.br.dto.request.GastosRequestDTO;
import com.br.dto.response.GastosResponseDTO;
import com.br.entity.Gastos;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GastosMapper {

    Gastos toEntity(GastosRequestDTO dto);

    GastosResponseDTO toDto(Gastos entity);

    List<GastosResponseDTO> toDto(List<Gastos> entity);
}
