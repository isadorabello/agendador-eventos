package io.github.isadorabello.agendadoreventos.infrastructure.repository;

import io.github.isadorabello.agendadoreventos.infrastructure.entity.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String> {
}
