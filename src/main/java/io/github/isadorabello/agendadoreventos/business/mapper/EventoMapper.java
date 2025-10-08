package io.github.isadorabello.agendadoreventos.business.mapper;

import io.github.isadorabello.agendadoreventos.business.dto.EventoDTO;
import io.github.isadorabello.agendadoreventos.infrastructure.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EventoMapper {

    Evento paraEventoEntity(EventoDTO dto);

    EventoDTO paraEventoDTO(Evento entity);

    List<EventoDTO> paraListaDTOs(List<Evento> entities);

    List<Evento> paraListaEntities(List<EventoDTO> dtos);
}
