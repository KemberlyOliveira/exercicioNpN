package com.example.projetoN.execicioN.Controller;

// Importações do Spring Framework para controle de rotas, injeção de dependência e modelos
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AlunoService oAlunoService;


    @GetMapping("/listarAlunos")
    public String telaListarAlunos(Model oModel) {
        oModel.addAttribute("alunos", oAlunoService.listarAlunos());
        return "listarAlunos";
    }

    @GetMapping("/formCadastrar")
    public String telaCadastraAluno(Model oModel) {

        oModel.addAttribute("aluno", new Aluno());
        return "cadastrarAluno";
    }


    @PostMapping("/salvarAluno")
    public String cadastrarAluno(@ModelAttribute Aluno oAluno) {

        oAlunoService.cadastrarAluno(oAluno);

        return "redirect:/alunoCTR/listarAlunos";
    }

    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable Long id) {
        oAlunoService.deletarAluno(id);

        return "redirect:/alunoCTR/listarAlunos";
    }
}
