package io.github.isadorabello.agendadoreventos.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.isadorabello.agendadoreventos.infrastructure.enums.StatusEventoEnum;

import java.time.LocalDateTime;

public record EventoDTO(String id,
                        String titulo,
                        String descricao,
                        String emailUsuario,
                        int maxParticipantes,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                        LocalDateTime dataEvento,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                        LocalDateTime dataCriacao,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                        LocalDateTime dataAlteracao,
                        String localizacao,
                        String linkChamada,
                        StatusEventoEnum status) {
}
