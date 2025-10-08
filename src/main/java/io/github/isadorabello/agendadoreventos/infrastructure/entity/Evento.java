package io.github.isadorabello.agendadoreventos.infrastructure.entity;

import io.github.isadorabello.agendadoreventos.infrastructure.enums.StatusEventoEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("evento")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Evento {

    @Id
    private String id;
    private String emailUsuario;
    private int maxParticipantes;
    private LocalDateTime dataEvento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
    private String titulo;
    private String descricao;
    private StatusEventoEnum status;
}
