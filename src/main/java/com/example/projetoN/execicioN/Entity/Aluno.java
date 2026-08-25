package com.example.projetoN.execicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// Entidade JPA que representa a tabela "aluno" no banco de dados
@Entity
@Table(name = "aluno")
@Data     // Lombok: gera getters, setters, equals, hashCode e toString automaticamente
@Getter   // Redundante junto com @Data, mas gera explicitamente os getters
@Setter   // Redundante junto com @Data, mas gera explicitamente os setters
public class Aluno {

    // Chave primária da tabela, gerada automaticamente pelo banco (auto increment)
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_aluno", unique = true, nullable = false)
    private Long id;

    // Nome do aluno - obrigatório, limitado a 50 caracteres
    @Column(name = "nome_aluno", nullable = false, length = 50)
    private String nome;

    // CPF do aluno - obrigatório e único, limitado a 15 caracteres
    @Column(name = "cpf_aluno", nullable = false, unique = true, length = 15)
    private String cpf;

    // E-mail do aluno - obrigatório, limitado a 100 caracteres
    @Column(name = "email_aluno", nullable = false, length = 100)
    private String email;

}