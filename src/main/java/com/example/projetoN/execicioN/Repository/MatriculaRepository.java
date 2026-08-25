package com.example.projetoN.execicioN.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoN.execicioN.Entity.Matricula;

// Repositório de acesso a dados para a entidade Matricula.
// Herda automaticamente as operações de CRUD do JpaRepository.
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}