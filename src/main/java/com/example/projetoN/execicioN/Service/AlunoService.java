package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Aluno;
import com.example.projetoN.execicioN.Repository.AlunoRepository;

// Camada de serviço (regras de negócio) para Aluno.
// Fica entre o Controller e o Repository.
@Service
public class AlunoService {

    // Injeção de dependência do repositório via construtor
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Busca um aluno pelo ID; lança exceção caso não seja encontrado
    public Aluno buscaralunAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com ID: " + id));
    }

    // Salva (insere ou atualiza) um aluno no banco de dados
    public Aluno salvarAluno(Aluno oAluno) {
                return alunoRepository.save(oAluno);
            }

    // Retorna a lista completa de alunos cadastrados
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    // Altera os dados de um aluno existente com base no ID informado
    public Aluno alterarAluno(Long id, Aluno oAltAluno) {
        // Busca o aluno atual no banco (lança exceção se não existir)
        Aluno alunoExixtente = buscaralunAlunoPorId(id);

        // Atualiza os campos do aluno existente com os novos valores
        alunoExixtente.setNome(oAltAluno.getNome());
        alunoExixtente.setCpf(oAltAluno.getCpf());
        alunoExixtente.setEmail(oAltAluno.getEmail());

        // Persiste as alterações
        return alunoRepository.save(alunoExixtente);
    }

    // Remove um aluno do banco de dados com base no ID
    public void deletarAluno(Long id) {
        // Garante que o aluno existe antes de tentar deletar
        Aluno alunoExixtente = buscaralunAlunoPorId(id);
        alunoRepository.delete(alunoExixtente);
    }
}