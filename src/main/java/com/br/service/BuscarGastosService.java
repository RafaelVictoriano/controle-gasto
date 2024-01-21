package com.br.service;

import com.br.dto.response.GastosResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface BuscarGastosService {

    List<GastosResponseDTO> byParams(String nome,
                                     BigDecimal valor,
                                     Integer ano,
                                     Integer mes);

}
