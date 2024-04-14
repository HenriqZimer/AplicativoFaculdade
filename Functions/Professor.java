package appfaculdade;

import java.util.Scanner;

public class Professor {
    private String nome;
    private String endereco;
    private String materia;
    private Turma turma;

    public Professor(String nome, String endereco, String materia, Turma turma) {
        this.nome = nome;
        this.endereco = endereco;
        this.materia = materia;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getMateria() {
        return materia;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public static Professor criarProfessor(Scanner scanner, Turma turma) {
        System.out.println("Digite o nome do professor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço do professor:");
        String endereco = scanner.nextLine();
        System.out.println("Digite a matéria que o professor ensina:");
        String materia = scanner.nextLine();

        return new Professor(nome, endereco, materia, turma);
    }
}
