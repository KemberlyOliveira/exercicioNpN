package com.example.projetoN.execicioN.DTO;

import lombok.Data;

@Data
public class MatriculaDTO {

    private Long id_aluno;
    private Long id_curso;
    private String dataMatricula;
    private String status;
    private Double notaFinal;
    
}
