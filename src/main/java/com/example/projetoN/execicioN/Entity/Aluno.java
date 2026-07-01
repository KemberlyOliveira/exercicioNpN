package com.example.projetoN.execicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "aluno")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_aluno", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome_aluno", nullable = false, length = 50)
    private String nome;

    @Column(name = "cpf_aluno", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email_aluno", nullable = false, unique = true)
    private String email;

}