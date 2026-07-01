package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Aluno;
import com.example.projetoN.execicioN.Repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository oAlunoRepository;

    public void cadastrarAluno(Aluno oAluno) {
        oAlunoRepository.save(oAluno);
    }

    public List<Aluno> listarAlunos() {
        return oAlunoRepository.findAll();
    }

    public void deletarAluno(Long id) {
        oAlunoRepository.deleteById(id);
    }
}