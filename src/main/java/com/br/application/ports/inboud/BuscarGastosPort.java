package com.br.application.ports.inboud;

import com.br.adapters.inbound.dto.GastosFiltrosDTO;
import com.br.adapters.outbound.dto.GastosResponseDTO;

import java.util.List;

public interface BuscarGastosPort {

    List<GastosResponseDTO> byParams(GastosFiltrosDTO paramsDTO);

}
