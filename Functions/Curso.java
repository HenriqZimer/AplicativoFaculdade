package appfaculdade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private String nome;
    private String sigla;
    private List<Turma> turmas;

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public static Curso criarCurso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do curso:");
        String nome = scanner.nextLine();
        System.out.println("Digite a sigla do curso:");
        String sigla = scanner.nextLine();
        return new Curso(nome, sigla);
    }
}
