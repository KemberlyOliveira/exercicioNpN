package com.example.projetoN.execicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.execicioN.Entity.Matricula;
import com.example.projetoN.execicioN.Repository.AlunoRepository;
import com.example.projetoN.execicioN.Repository.CursoRepository;
import com.example.projetoN.execicioN.Repository.MatriculaRepository;

// Camada de serviço (regras de negócio) para Matrícula.
// Também depende de AlunoRepository e CursoRepository, provavelmente para
// validar/buscar o Aluno e o Curso na hora de criar uma matrícula.
@Service
public class MatriculaService {

    // ===== ATRIBUTOS (campos) DA CLASSE =====

// private -> só pode ser acessado dentro desta própria classe (encapsulamento)
// final   -> só pode receber valor UMA vez (nesse caso, dentro do construtor);
//            depois disso não pode ser reatribuído
// MatriculaRepository -> tipo da variável (uma interface que sabe salvar,
//            buscar, deletar registros de Matricula no banco)
// matriculaRepository -> nome da variável (convenção camelCase)
private final MatriculaRepository matriculaRepository;

// mesma lógica acima, mas para acessar dados de Aluno no banco
private final AlunoRepository alunoRepository;

// mesma lógica acima, mas para acessar dados de Curso no banco
private final CursoRepository cursoRepository;


// ===== CONSTRUTOR =====

// public -> precisa ser público para o Spring conseguir chamá-lo de fora
//           e criar o objeto MatriculaService automaticamente
// MatriculaService -> nome do construtor é sempre igual ao nome da classe;
//           não tem tipo de retorno (nem void), pois serve para CRIAR o objeto
//
// Os parâmetros abaixo (entre parênteses) são o que essa classe EXIGE
// receber de fora para poder ser criada. Repare que têm o MESMO NOME
// dos atributos declarados acima — isso é proposital e é resolvido com "this"
public MatriculaService (MatriculaRepository matriculaRepository, 
                         AlunoRepository alunoRepository, 
                         CursoRepository cursoRepository) {

    // this.matriculaRepository -> refere-se ao ATRIBUTO da classe (o campo lá de cima)
    // matriculaRepository (sem "this.") -> refere-se ao PARÂMETRO que chegou
    //     pelo construtor (o objeto que o Spring está entregando)
    // "=" -> pega o valor da direita (parâmetro) e guarda na variável da esquerda (atributo)
    //
    // Sem o "this.", o Java não saberia diferenciar os dois, já que têm o mesmo nome.
    // O "this." deixa explícito: "o atributo DESTA classe", e não o parâmetro.
    this.matriculaRepository = matriculaRepository;

    // mesma lógica: guarda o AlunoRepository recebido no atributo da classe
    this.alunoRepository = alunoRepository;

    // mesma lógica: guarda o CursoRepository recebido no atributo da classe
    this.cursoRepository = cursoRepository;
}

// ===== RESUMO DO QUE ACONTECE AQUI =====
// Isso é chamado de "Injeção de Dependência via Construtor".
// Em vez de o MatriculaService criar seus próprios repositórios (ex: new AlunoRepository()),
// ele RECEBE prontos de fora — quem entrega é o Spring, automaticamente,
// pois essas interfaces já são gerenciadas por ele (@Repository).
//
// Fluxo resumido:
// 1) Spring precisa criar um MatriculaService (por causa do @Service)
// 2) Spring vê que o construtor pede 3 repositórios
// 3) Spring já tem instâncias prontas desses repositórios (JpaRepository)
// 4) Spring passa essas instâncias para o construtor
// 5) O construtor guarda cada uma no atributo correspondente
//
// A partir daí, qualquer método da classe pode usar, por exemplo:
// matriculaRepository.save(...), alunoRepository.findById(...), etc.

    // Retorna todas as matrículas cadastradas
    public List<Matricula> listarTodasMatriculas(){
        return matriculaRepository.findAll();
    }




    // Salva (insere ou atualiza) uma matrícula no banco de dados
    // OBS: os repositórios alunoRepository e cursoRepository ainda não estão
    // sendo utilizados aqui. Normalmente seriam usados para buscar o Aluno e
    // o Curso pelo ID antes de montar e salvar o objeto Matricula.
    public Matricula salvarMatricula(Matricula matricula){
        return matriculaRepository.save(matricula);
    }

}