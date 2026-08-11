package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Aluno;
import com.example.projetoN.execicioN.Repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno buscaralunAlunoPorId (Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com ID: "+ id));
    }

    public void salvarAluno(Aluno oAluno) {
        alunoRepository.save(oAluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno alterarAluno (Long id, Aluno oAltAluno){
        Aluno alunoExixtente = buscaralunAlunoPorId(id);

        alunoExixtente.setNome(oAltAluno.getNome());
        alunoExixtente.setCpf(oAltAluno.getCpf());
        alunoExixtente.setEmail(oAltAluno.getEmail());

        return alunoRepository.save(alunoExixtente);
    }

    public void deletarAluno(Long id) {
        Aluno alunoExixtente = buscaralunAlunoPorId(id);
        alunoRepository.delete(alunoExixtente);
    }
}