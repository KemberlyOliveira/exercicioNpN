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

    public Aluno buscaralunAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com ID: " + id));
    }

    public Aluno salvarAluno(Aluno oAluno) {
                return alunoRepository.save(oAluno);
            }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno alterarAluno(Long id, Aluno oAltAluno) {
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

// package com.example.projecoN.exercicioN.Service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.projecoN.exercicioN.Entity.Aluno;
// import com.example.projecoN.exercicioN.Repository.AlunoRepository;

// @Service
// public class AlunoService {
//     private final AlunoRepository alunoRepository;

//     public AlunoService(AlunoRepository alunoRepository) {
//         this.alunoRepository = alunoRepository; // note* utilize this method instead of @Autowired from now on
//                                                 // 
//     }

//     public List<Aluno> listarTodosAlunos() {
//         return alunoRepository.findAll();
//     }

//     public Aluno buscarAlunoPorId(Long id) {
//         return alunoRepository.findById(id)
//                 .orElseThrow(() -> new IllegalArgumentException("aluno não encontrado com o ID: " + id));
//     }

//     public Aluno salvarAluno(Aluno oAluno) {
//         return alunoRepository.save(oAluno);
//     }
//     public Aluno alterarAluno(Long id, Aluno altAluno){
//         Aluno alunoExistente = buscarAlunoPorId(id);
//         alunoExistente.setNome_aluno(altAluno.getNome_aluno());
//         alunoExistente.setCpf_aluno(altAluno.getCpf_aluno());
//         alunoExistente.setEmail_aluno(altAluno.getEmail_aluno());
//         return alunoRepository.save(alunoExistente);
//     }
//     public void deletarAluno(Long id){
//         Aluno alunoExistente = buscarAlunoPorId(id);
//         alunoRepository.delete(alunoExistente);
//     }
// }