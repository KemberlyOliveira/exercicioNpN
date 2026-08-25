package com.example.projetoN.execicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// Entidade JPA que representa a tabela "curso" no banco de dados
@Entity
@Table(name = "curso")
@Data // Lombok: gera getters, setters, equals, hashCode e toString automaticamente
public class Curso {

    // Chave primária, gerada automaticamente (auto increment)
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_curso", unique = true, nullable = false)
    private Long id;

    // Nome do curso - obrigatório, até 50 caracteres
    @Column(name = "nome_curso", nullable = false, length = 50)
    private String nome;

    // Carga horária do curso - obrigatório
    // Observação: está como String, poderia ser numérico (Integer) dependendo da regra de negócio
    @Column(name = "carga_horaria_curso", nullable = false, length = 5)
    private String cargaHoraria;

    // Descrição do curso - obrigatório, até 100 caracteres
    @Column(name = "descricao_curso", nullable = false, length = 100)
    private String descricao;
}