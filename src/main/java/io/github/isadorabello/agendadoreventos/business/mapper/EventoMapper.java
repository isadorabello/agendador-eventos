package io.github.isadorabello.agendadoreventos.business.mapper;

import io.github.isadorabello.agendadoreventos.business.dto.EventoDTO;
import io.github.isadorabello.agendadoreventos.infrastructure.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EventoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataAlteracao", target = "dataAlteracao")
    Evento paraEventoEntity(EventoDTO dto);

    EventoDTO paraEventoDTO(Evento entity);

    List<EventoDTO> paraListaDTOs(List<Evento> entities);

    List<Evento> paraListaEntities(List<EventoDTO> dtos);
}
