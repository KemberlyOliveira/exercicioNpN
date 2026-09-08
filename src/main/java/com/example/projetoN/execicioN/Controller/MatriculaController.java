package com.example.projetoN.execicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.execicioN.DTO.MatriculaDTO;
import com.example.projetoN.execicioN.Service.AlunoService;
import com.example.projetoN.execicioN.Service.CursoService;
import com.example.projetoN.execicioN.Service.MatriculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("MatriculaCTR")
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

    @GetMapping("/listarMatriculas")
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

}
