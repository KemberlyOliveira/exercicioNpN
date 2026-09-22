package com.example.projetoN.execicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.execicioN.DTO.MatriculaDTO;
import com.example.projetoN.execicioN.Service.AlunoService;
import com.example.projetoN.execicioN.Service.CursoService;
import com.example.projetoN.execicioN.Service.MatriculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("matriculaCTR")
public class MatriculaController {

    private final MatriculaService oMatriculaService;
    private final CursoService oCursoService;
    private final AlunoService oAlunoService;

    public MatriculaController(
            MatriculaService oMatriculaService,
            CursoService oCursoService,
            AlunoService oAlunoService) {
        this.oMatriculaService = oMatriculaService;
        this.oCursoService = oCursoService;
        this.oAlunoService = oAlunoService;
    }

    @GetMapping("/listar")
    public String listMatriculas(Model oModel) {
        oModel.addAttribute("matricula", oMatriculaService.listarTodasMatriculas());
        return "listarMatriculas";
    }

    @GetMapping("/formCadastrar")
    public String showFormCadastrarMatricula(Model oModel) {
        oModel.addAttribute("matriculaDTO", new MatriculaDTO());
        oModel.addAttribute("listAlunos", oAlunoService.listarAlunos());
        oModel.addAttribute("listCursos", oCursoService.listarCursos());

        return "cadastrarMatricula";
    }

    @PostMapping("/salvarMatricula")
    public String salvarMatricula(MatriculaDTO oMatriculaDTO) {
        if (oMatriculaDTO.getId_matricula() == null) {
            oMatriculaService.salvarMatricula(oMatriculaDTO);
        } else {
            oMatriculaService.editarMatricula(oMatriculaDTO.getId_matricula(), oMatriculaDTO);
        }
        
        // CORRIGIDO: Redirecionando para a URL correta mapeada no @GetMapping("/listar")
        return "redirect:/matriculaCTR/listar";
    }
}