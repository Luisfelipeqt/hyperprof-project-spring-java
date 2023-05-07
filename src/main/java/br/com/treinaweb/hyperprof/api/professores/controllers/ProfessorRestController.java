package br.com.treinaweb.hyperprof.api.professores.controllers;

import java.util.List;

import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.api.professores.services.ProfessorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfessorRestController {

    private final ProfessorService professorService;

    @GetMapping(ApiRoutes.BUSCAR_PROFESSORES)
    public List<ProfessorResponse> buscarProfessores(
        @RequestParam(name = "q", required = false, defaultValue = "") String descricao
    ) {
        return professorService.buscarProfessores(descricao);
    }

    @GetMapping(ApiRoutes.BUSCAR_PROFESSOR_POR_ID)
    public ProfessorResponse buscarProfessorPorId(@PathVariable Long professorId) {
        return professorService.buscarProfessorPorId(professorId);
    }

    @PostMapping(ApiRoutes.CADASTRAR_PROFESSOR)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorResponse cadastrarProfessor(@RequestBody ProfessorRequest professorRequest) {
        return professorService.cadastrarProfessor(professorRequest);
    }
}
