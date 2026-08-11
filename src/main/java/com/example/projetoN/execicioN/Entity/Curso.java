package com.example.projetoN.execicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "curso")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_curso", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome_curso", nullable = false, length = 50)
    private String nome;

    @Column(name = "carga_horaria_curso", nullable = false, length = 5)
    private String cargaHoraria;

    @Column(name = "descricao_curso", nullable = false, length = 100)
    private String descricao;
}
