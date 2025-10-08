package io.github.isadorabello.agendadoreventos.infrastructure.repository;

import io.github.isadorabello.agendadoreventos.infrastructure.entity.Evento;
import io.github.isadorabello.agendadoreventos.infrastructure.enums.StatusEventoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String> {

    List<Evento> findByDataEventoBetween(LocalDateTime dataInical, LocalDateTime dataFinal);

    List<Evento> findByDataEventoBetweenAndStatus(LocalDateTime dataInical, LocalDateTime dataFinal, StatusEventoEnum status);

    List<Evento> findByEmailUsuario(String email);
}
