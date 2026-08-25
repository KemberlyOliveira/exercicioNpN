package com.example.projetoN.execicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.execicioN.Entity.Aluno;
import com.example.projetoN.execicioN.Service.AlunoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Controller responsável por gerenciar as requisições HTTP relacionadas a Aluno.
// Faz a ponte entre as views (Thymeleaf) e a camada de serviço (AlunoService).
@Controller
@RequestMapping("/alunoCTR") // Prefixo de rota para todos os endpoints deste controller
public class AlunoController {

    // Injeção de dependência do serviço de Aluno (via construtor)
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Endpoint GET para listar todos os alunos cadastrados
    @GetMapping("/listarAlunos")
    public String listarAlunos(Model oModel) {
        // Adiciona a lista de alunos ao Model para ser exibida na view "listarAlunos"
        oModel.addAttribute("listAlunos", alunoService.listarAlunos());
        return "listarAlunos"; // Nome da view (template) que será renderizada
    }

    // Endpoint GET que exibe o formulário de cadastro de um novo aluno
    @GetMapping("/formCadastrar")
    public String telaCadastraAluno(Model oModel) {

        // Cria um objeto Aluno vazio para ser vinculado ao formulário (binding)
        oModel.addAttribute("aluno", new Aluno());
        return "cadastrarAluno";
    }

    // Endpoint POST que recebe os dados do formulário e salva o aluno (criação ou edição)
    @PostMapping("/salvarAluno")
    public String salvarAluno(Aluno oAluno, Model oModel) {

        // Persiste o aluno recebido do formulário no banco de dados
        alunoService.salvarAluno(oAluno);

        // Redireciona para a listagem de alunos após salvar
        return "redirect:/alunoCTR/listarAlunos";
    }

    // Endpoint GET para carregar os dados de um aluno existente no formulário de edição
    @GetMapping("/fromAlterar/{id}")
    public String getMethodName(@PathVariable Long id, Model oModel) {
        // Busca o aluno pelo ID informado na URL
        Aluno alunoExistente =alunoService.buscaralunAlunoPorId(id);
        // Envia o aluno encontrado para a view preencher o formulário
        oModel.addAttribute("aluno", alunoExistente);
        return "cadastrarAluno"; // Reutiliza a mesma tela de cadastro para edição
    }

    // Endpoint GET para excluir um aluno pelo ID
    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);

        // Após deletar, redireciona novamente para a listagem
        return "redirect:/alunoCTR/listarAlunos";
    }
}