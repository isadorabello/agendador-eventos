package io.github.isadorabello.agendadoreventos.controller;

import io.github.isadorabello.agendadoreventos.business.dto.EventoDTO;
import io.github.isadorabello.agendadoreventos.business.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService service;

    @PostMapping
    public ResponseEntity<EventoDTO> salvarEvento(@RequestHeader("Authorization") String token, @RequestBody EventoDTO dto){
        return ResponseEntity.ok(service.salvarEvento(dto, token));
    }

}
