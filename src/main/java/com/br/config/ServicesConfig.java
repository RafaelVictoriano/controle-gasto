package com.br.config;

import com.br.adapters.inbound.mapper.GastosMapper;
import com.br.application.core.service.LancarGastosService;
import com.br.application.ports.outbound.GastosRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {


    @Bean
    public LancarGastosService lancarGastosService(GastosRepositoryPort gastosRepositoryPort,
                                                   GastosMapper mapper) {
        return new LancarGastosService(gastosRepositoryPort, mapper);
    }
}
