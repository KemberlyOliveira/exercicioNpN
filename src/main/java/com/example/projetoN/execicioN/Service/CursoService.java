package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Curso;
import com.example.projetoN.execicioN.Repository.CursoRepository;
@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso buscarCursoPorId(Long id) {  
        return cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com ID: " + id));
    }

    public Curso salvarCurso(Curso oCurso) {  
        return cursoRepository.save(oCurso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
    public Curso alterarCurso(Long id, Curso oAltCurso) {
        Curso cursoExistente = buscarCursoPorId(id);
    
        cursoExistente.setNome(oAltCurso.getNome());
        cursoExistente.setCargaHoraria(oAltCurso.getCargaHoraria());  
        cursoExistente.setDescricao(oAltCurso.getDescricao());       
    
        return cursoRepository.save(cursoExistente);
    }

    public void deletarCurso(Long id) {
        Curso cursoExistente = buscarCursoPorId(id); 
        cursoRepository.delete(cursoExistente);
    }
}