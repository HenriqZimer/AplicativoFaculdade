package appfaculdade;

import java.util.Scanner;

public class Aluno {
    private String nome;
    private int codigo;
    private String endereco;
    private Turma turma;

    public Aluno(String nome, int codigo, String endereco, Turma turma) {
        this.nome = nome;
        this.codigo = codigo;
        this.endereco = endereco;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public static Aluno criarAluno(Scanner scanner, Turma turma) {
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite o código do aluno:");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();

        return new Aluno(nome, codigo, endereco, turma);
    }
}
