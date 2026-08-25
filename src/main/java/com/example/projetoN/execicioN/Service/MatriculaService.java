package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Matricula;
import com.example.projetoN.execicioN.Repository.AlunoRepository;
import com.example.projetoN.execicioN.Repository.CursoRepository;
import com.example.projetoN.execicioN.Repository.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService (MatriculaRepository matriculaRepository, 
                             AlunoRepository alunoRepository, 
                             CursoRepository cursoRepository) {

        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Matricula> listarTodasMatriculas(){
        return matriculaRepository.findAll();
    }




    public Matricula salvarMatricula(Matricula matricula){
        return matriculaRepository.save(matricula);
    }

}
