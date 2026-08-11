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

    public Curso obterCursoPorId(Long id) {  // ✅ Renomeado
        return cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com ID: " + id));
    }

    public Curso salvarCurso(Curso oCurso) {  // ✅ Renomeado
        return cursoRepository.save(oCurso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso alterarCurso(Long id, Curso oAltCurso) {
        Curso cursoExistente = obterCursoPorId(id);  // ✅ Usando novo nome

        cursoExistente.setNome(oAltCurso.getNome());
        cursoExistente.setcargaHoraria(oAltCurso.getcargaHoraria());
        cursoExistente.setdescricao(oAltCurso.getdescricao());

        return cursoRepository.save(cursoExistente);
    }

    public void deletarCurso(Long id) {
        Curso cursoExistente = obterCursoPorId(id);  // ✅ Tipo correto
        cursoRepository.delete(cursoExistente);
    }
}