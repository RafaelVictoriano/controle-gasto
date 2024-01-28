package com.br.application.ports.inboud;

import com.br.adapters.inbound.dto.GastosRequestDTO;
import com.br.adapters.outbound.dto.GastosResponseDTO;
import com.br.application.core.domain.GastosDomain;


public interface LancarGastosPort {

    GastosResponseDTO start(GastosDomain gastosDomain);

}
