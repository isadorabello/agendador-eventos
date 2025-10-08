package io.github.isadorabello.agendadoreventos.business.mapper;

import io.github.isadorabello.agendadoreventos.business.dto.EventoDTO;
import io.github.isadorabello.agendadoreventos.infrastructure.entity.Evento;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EventoMapper {

    Evento paraEntity(EventoDTO dto);

    EventoDTO paraDTO(Evento entity);

}
