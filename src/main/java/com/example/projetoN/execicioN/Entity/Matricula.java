package com.example.projetoN.execicioN.Entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricula;

    @ManyToAny
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToAny
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(name = "data_matricula", nullable = false)
    private String dataMatricula;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "nota_final")
    private Double notaFinal;

}
