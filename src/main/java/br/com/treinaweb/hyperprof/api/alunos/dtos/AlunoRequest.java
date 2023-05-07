package br.com.treinaweb.hyperprof.api.alunos.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class AlunoRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nome;

    @Email
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String email;

    @Future
    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime dataAula;
}
