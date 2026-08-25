package com.example.projetoN.execicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.execicioN.Entity.Curso;
import com.example.projetoN.execicioN.Service.CursoService;

// Controller responsável pelas requisições HTTP relacionadas a Curso
@Controller
@RequestMapping("/curso") // Prefixo de rota para os endpoints de curso
public class CursoController {

    // Injeção de dependência do serviço de Curso via construtor
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Endpoint GET para listar todos os cursos cadastrados
    @GetMapping("/listarCursos")
    public String listarCursos(Model oModel) {
        oModel.addAttribute("listarCursos", cursoService.listarCursos());
        return "listarCursos"; 
    }

    

    // Endpoint GET que exibe o formulário para cadastrar um novo curso
    @GetMapping("/formCadastrar")
    public String telaCadastraCurso(Model oModel) {

        // Cria um objeto Curso vazio para vincular ao formulário
        oModel.addAttribute("curso", new Curso());
        return "cadastrarCurso";
    }


    // Endpoint POST que salva (cria ou atualiza) um curso a partir do formulário
    @PostMapping("/salvarCurso")
    public String salvarCurso(Curso oCurso, Model oModel) {

        cursoService.salvarCurso(oCurso);

        return "redirect:/curso/listarCursos";
    }

    // Endpoint comentado (desativado) - seria usado para carregar um curso existente
    // para edição, semelhante ao "fromAlterar" do AlunoController.
    // Está incompleto/incorreto pois referencia "alunoService" em vez de "cursoService".
    // @GetMapping("/fromAlterar/{id}")
    // public String getMethodName(@PathVariable Long id, Model oModel) {
    //     Aluno alunoExistente =alunoService.buscaralunAlunoPorId(id);
    //     oModel.addAttribute("aluno", alunoExistente);
    //     return "cadastrarAluno";
    // }


    // Endpoint GET para excluir um curso pelo ID
    @GetMapping("/deletarCurso/{id}")
    public String deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);

        return "redirect:/curso/listarCursos";
    }

}