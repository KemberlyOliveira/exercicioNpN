package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.DTO.MatriculaDTO;
import com.example.projetoN.execicioN.Entity.Curso;
import com.example.projetoN.execicioN.Entity.Matricula;
import com.example.projetoN.execicioN.Repository.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final CursoService cursoService;
    private final AlunoService alunoService;

    public MatriculaService(MatriculaRepository matriculaRepository,
            AlunoService alunoService,
            CursoService cursoService) {

        this.matriculaRepository = matriculaRepository;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    public List<Matricula> listarTodasMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula salvarMatricula(MatriculaDTO oMatriculaDTO) {

        Matricula novaMatricula = new Matricula();

        novaMatricula.setAluno(alunoService.buscaralunAlunoPorId(oMatriculaDTO.getId_aluno()));
        novaMatricula.setCurso(cursoService.buscarCursoPorId(oMatriculaDTO.getId_curso()));

        novaMatricula.setDataMatricula(oMatriculaDTO.getDataMatricula());
        novaMatricula.setStatus(oMatriculaDTO.getStatus());
        novaMatricula.setNotaFinal(oMatriculaDTO.getNotaFinal());

        return matriculaRepository.save(novaMatricula);
    }

    public Matricula buscarMatriculaPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrado com ID: " + id));
    }

    public Matricula editarMatricula (Long id, MatriculaDTO oMatriculaDTO){
        Matricula matriculaExintente = buscarMatriculaPorId(id);

        matriculaExintente.setAluno(alunoService.buscaralunAlunoPorId(oMatriculaDTO.getId_aluno()));
        matriculaExintente.setCurso(cursoService.buscarCursoPorId(oMatriculaDTO.getId_curso()));

        matriculaExintente.setDataMatricula(oMatriculaDTO.getDataMatricula());
        matriculaExintente.setStatus(oMatriculaDTO.getStatus());
        matriculaExintente.setNotaFinal(oMatriculaDTO.getNotaFinal());

        return matriculaRepository.save(matriculaExintente);
    }

    public void deletar(Long id) {
        Matricula matriculaExintente = buscarMatriculaPorId(id); 
        matriculaRepository.delete(matriculaExintente);
    }
}