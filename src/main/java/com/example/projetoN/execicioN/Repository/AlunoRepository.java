package com.example.projetoN.execicioN.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoN.execicioN.Entity.Aluno;

// Repositório de acesso a dados para a entidade Aluno.
// Ao estender JpaRepository, já herda métodos prontos como save(), findById(),
// findAll(), deleteById(), etc., sem precisar de implementação manual.
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}