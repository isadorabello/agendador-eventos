package io.github.isadorabello.agendadoreventos.business.service;

import io.github.isadorabello.agendadoreventos.business.dto.EventoDTO;
import io.github.isadorabello.agendadoreventos.business.mapper.EventoMapper;
import io.github.isadorabello.agendadoreventos.infrastructure.entity.Evento;
import io.github.isadorabello.agendadoreventos.infrastructure.enums.StatusEventoEnum;
import io.github.isadorabello.agendadoreventos.infrastructure.repository.EventoRepository;
import io.github.isadorabello.agendadoreventos.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository repository;
    private final EventoMapper mapper;
    private final JwtUtil jwtUtil;


    public EventoDTO salvarEvento(EventoDTO dto, String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        EventoDTO eventoDTO = new EventoDTO(dto.id(), dto.titulo(), dto.descricao(), email,dto.maxParticipantes(),
                dto.dataEvento(), LocalDateTime.now(), dto.dataAlteracao(), dto.localizacao(), dto.linkChamada(), StatusEventoEnum.AGENDADO
        );

        Evento evento = repository.save(mapper.paraEventoEntity(eventoDTO));
        return mapper.paraEventoDTO(evento);
    }

    public List<EventoDTO> buscarEventoPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return mapper.paraListaDTOs(repository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<EventoDTO> buscarEventoPorEmail(String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        return mapper.paraListaDTOs(repository.findByEmailUsuario(email));
    }

}
