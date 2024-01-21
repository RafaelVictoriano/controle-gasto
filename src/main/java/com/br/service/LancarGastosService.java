package com.br.service;

import com.br.dto.request.GastosRequestDTO;
import com.br.dto.response.GastosResponseDTO;


public interface LancarGastosService {

    GastosResponseDTO start(GastosRequestDTO requestDTO);

}
