package com.example.projetoN.execicioN.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoN.execicioN.Entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}