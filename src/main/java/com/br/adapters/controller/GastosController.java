package com.br.adapters.controller;

import com.br.adapters.inbound.dto.GastosFiltrosDTO;
import com.br.adapters.inbound.dto.GastosRequestDTO;
import com.br.adapters.inbound.mapper.GastosMapper;
import com.br.adapters.outbound.dto.GastosResponseDTO;
import com.br.application.ports.inboud.BuscarGastosPort;
import com.br.application.ports.inboud.LancarGastosPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/gastos")
public class GastosController {

    private final BuscarGastosPort buscarGastosPort;
    private final LancarGastosPort lancarGastosPort;
    private final GastosMapper gastosMapper;


    @GetMapping()
    public ResponseEntity<List<GastosResponseDTO>> getByParams(@RequestParam(required = false) String nome,
                                                               @RequestParam(required = false) BigDecimal valor,
                                                               @RequestParam(required = false) Integer ano,
                                                               @RequestParam(required = false) Integer mes) {
        final var gastosResponseDTOS = buscarGastosPort.byParams(new GastosFiltrosDTO(nome, valor, ano, mes));

        if (gastosResponseDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gastosResponseDTOS);
    }


    @PostMapping
    public ResponseEntity<GastosResponseDTO> post(@RequestBody @Validated GastosRequestDTO body) {
        return ResponseEntity.status(CREATED)
                .body(lancarGastosPort.start(gastosMapper.toDomain(body)));
    }
}
