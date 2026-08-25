package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Curso;
import com.example.projetoN.execicioN.Repository.CursoRepository;

// Camada de serviço (regras de negócio) para Curso
@Service
public class CursoService {

    // Injeção de dependência do repositório via construtor
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Busca um curso pelo ID; lança exceção caso não seja encontrado
    public Curso buscarCursoPorId(Long id) {  
        return cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com ID: " + id));
    }

    // Salva (insere ou atualiza) um curso no banco de dados
    public Curso salvarCurso(Curso oCurso) {  
        return cursoRepository.save(oCurso);
    }

    // Retorna a lista completa de cursos cadastrados
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // Altera os dados de um curso existente com base no ID informado
    public Curso alterarCurso(Long id, Curso oAltCurso) {
        // Busca o curso atual (lança exceção se não existir)
        Curso cursoExistente = buscarCursoPorId(id);
    
        // Atualiza os campos com os novos valores recebidos
        cursoExistente.setNome(oAltCurso.getNome());
        cursoExistente.setCargaHoraria(oAltCurso.getCargaHoraria());  
        cursoExistente.setDescricao(oAltCurso.getDescricao());       
    
        // Persiste as alterações
        return cursoRepository.save(cursoExistente);
    }

    // Remove um curso do banco de dados com base no ID
    public void deletarCurso(Long id) {
        Curso cursoExistente = buscarCursoPorId(id); 
        cursoRepository.delete(cursoExistente);
    }
}