package com.example.projetoN.execicioN.Entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

// Entidade JPA que representa a matrícula de um Aluno em um Curso.
// É a entidade "de ligação" entre Aluno e Curso.
@Entity
@Data // Lombok: gera getters, setters, equals, hashCode e toString
public class Matricula {

    // Chave primária, gerada automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricula;

    // Referência ao aluno matriculado
    // OBS: a anotação usada aqui é @ManyToAny (do Hibernate), que serve para
    // relacionamentos polimórficos e normalmente precisa de configuração extra
    // (@AnyDiscriminator, @AnyKeyJavaClass, etc.). O uso mais comum para este
    // caso costuma ser @ManyToOne (relação simples N:1 com Aluno).
    @ManyToAny
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    // Referência ao curso da matrícula (mesma observação sobre @ManyToAny acima)
    @ManyToAny
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    // Data em que a matrícula foi realizada
    @Column(name = "data_matricula", nullable = false)
    private String dataMatricula;

    // Status da matrícula (ex.: ativa, cancelada, concluída)
    @Column(name = "status", nullable = false)
    private String status;

    // Nota final do aluno no curso (opcional, pode ser nula)
    @Column(name = "nota_final")
    private Double notaFinal;

}