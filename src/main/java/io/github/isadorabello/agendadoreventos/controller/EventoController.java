package io.github.isadorabello.agendadoreventos.controller;

import io.github.isadorabello.agendadoreventos.business.dto.EventoDTO;
import io.github.isadorabello.agendadoreventos.business.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService service;

    @PostMapping
    public ResponseEntity<EventoDTO> salvarEvento(@RequestHeader("Authorization") String token, @RequestBody EventoDTO dto){
        return ResponseEntity.ok(service.salvarEvento(dto, token));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventoDTO>> buscaEventoPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal){
        return ResponseEntity.ok(service.buscarEventoPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> buscaEventoPorEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.buscarEventoPorEmail(token));
    }

}
