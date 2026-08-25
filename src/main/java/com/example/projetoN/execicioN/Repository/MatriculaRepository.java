package com.example.projetoN.execicioN.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoN.execicioN.Entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
