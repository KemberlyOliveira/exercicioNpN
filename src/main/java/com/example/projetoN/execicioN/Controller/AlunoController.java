package com.example.projetoN.execicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.execicioN.Entity.Aluno;
import com.example.projetoN.execicioN.Service.AlunoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alunoCTR")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listarTodosAlunos")
    public String ListarTodosAlunos(Model oModel) {
        oModel.addAttribute("listAlunos", alunoService.listarAlunos());
        return "listarAlunos";
    }

    @GetMapping("/formCadastrar")
    public String telaCadastraAluno(Model oModel) {

        oModel.addAttribute("aluno", new Aluno());
        return "cadastrarAluno";
    }

    @PostMapping("/salvarAluno")
    public String salvarAluno( Aluno oAluno, Model oModel) {

        alunoService.salvarAluno(oAluno);

        return "redirect:/alunoCTR/listarAlunos";
    }
    

    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);

        return "redirect:/alunoCTR/listarAlunos";
    }
}
