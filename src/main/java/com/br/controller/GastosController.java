package com.br.controller;

import com.br.dto.request.GastosRequestDTO;
import com.br.dto.response.GastosResponseDTO;
import com.br.service.BuscarGastosService;
import com.br.service.LancarGastosService;
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

    private final BuscarGastosService buscarGastosService;
    private final LancarGastosService lancarGastosService;


    @GetMapping()
    public ResponseEntity<List<GastosResponseDTO>> getByParams(@RequestParam(required = false) String nome,
                                                               @RequestParam(required = false) BigDecimal valor,
                                                               @RequestParam(required = false) Integer ano,
                                                               @RequestParam(required = false) Integer mes) {
        final var gastosResponseDTOS = buscarGastosService.byParams(nome, valor, ano, mes);

        if (gastosResponseDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gastosResponseDTOS);
    }


    @PostMapping
    public ResponseEntity<GastosResponseDTO> post(@RequestBody @Validated GastosRequestDTO body) {
        return ResponseEntity.status(CREATED)
                .body(lancarGastosService.start(body));
    }
}
