package appfaculdade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
public class Turma {
    private int semestre;
    private int ano;
    private Curso curso;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(int semestre, int ano, Curso curso) {
        this.semestre = semestre;
        this.ano = ano;
        this.curso = curso;
        this.professor = null;
        this.alunos = new ArrayList<>();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public int getSemestre() {
        return semestre;
    }

    public int getAno() {
        return ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public static Turma criarTurma(Scanner scanner, Curso[] cursos, int numCursos) {
        System.out.println("Digite o semestre da turma:");
        int semestre = scanner.nextInt();
        System.out.println("Digite o ano da turma:");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        if (numCursos > 0) {
            System.out.println("Selecione um curso para associar à turma:");
            for (int i = 0; i < numCursos; i++) {
                System.out.println((i + 1) + " - " + cursos[i].getNome());
            }
            int cursoIndex = scanner.nextInt() - 1;
            scanner.nextLine(); 
            if (cursoIndex >= 0 && cursoIndex < numCursos) {
                return new Turma(semestre, ano, cursos[cursoIndex]);
            } else {
                System.out.println("Índice de curso inválido.");
                return null;
            }
        } else {
            System.out.println("Não há cursos disponíveis. Cadastre cursos primeiro.");
            return null;
        }
    }
}
