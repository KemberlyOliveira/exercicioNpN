package com.example.projetoN.execicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.execicioN.Entity.Curso;
import com.example.projetoN.execicioN.Service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/listarCursos")
    public String listarCursos(Model oModel) {
        oModel.addAttribute("listarCursos", cursoService.listarCursos());
        return "listarCursos"; 
    }

    

    @GetMapping("/formCadastrar")
    public String telaCadastraCurso(Model oModel) {

        oModel.addAttribute("curso", new Curso());
        return "cadastrarCurso";
    }


    @PostMapping("/salvarCurso")
    public String salvarCurso(Curso oCurso, Model oModel) {

        cursoService.salvarCurso(oCurso);

        return "redirect:/curso/listarCursos";
    }


    @GetMapping("/deletarCurso/{id}")
    public String deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);

        return "redirect:/curso/listarCursos";
    }

}
