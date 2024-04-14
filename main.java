package appfaculdade;

import java.util.Scanner;

public class AppFaculdade {
    public static Aluno[] alunos = new Aluno[50];
    public static Professor[] professores = new Professor[5];
    public static Curso[] cursos = new Curso[5];
    public static Turma[] turmas = new Turma[10];
    public static int numAlunos = 0;
    public static int numProfessores = 0;
    public static int numCursos = 0;
    public static int numTurmas = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("");
            System.out.println("Menu da Faculdade:");
            System.out.println("");
            System.out.println("----------------------");
            System.out.println("1 - Menu de alunos");
            System.out.println("2 - Menu de Professores");
            System.out.println("3 - Menu de Turmas");
            System.out.println("4 - Menu de Cursos");
            System.out.println("0 - Sair");
            System.out.println("----------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuAlunos();
                    break;
                case 2:
                    menuProfessores();
                    break;
                case 3:
                    menuTurmas();
                    break;
                case 4:
                    menuCursos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void menuAlunos() {
        int opcao;
        do {
            System.out.println("----------------------");
            System.out.println("Menu Alunos:");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("0 - Sair");
            System.out.println("----------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (numTurmas == 0) {
                        System.out.println("Nenhum turma cadastrada. Cadastre uma turma primeiro.");
                    } else {
                        System.out.println("Selecione uma turma para o aluno:");
                        for (int i = 0; i < numTurmas; i++) {
                            System.out.println((i + 1) + " - Turma: Semestre " + turmas[i].getSemestre() + " Ano "
                                    + turmas[i].getAno());
                        }
                        int turmaIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        System.out.println("----------------------");
                        System.out.println("Digite o nome do aluno:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o código do aluno:");
                        int codigo = scanner.nextInt();
                        scanner.nextLine(); // limpa o buffer
                        System.out.println("Digite o endereço do aluno:");
                        String endereco = scanner.nextLine();

                        Aluno novoAluno = new Aluno(nome, codigo, endereco, turmas[turmaIndex]);
                        turmas[turmaIndex].addAluno(novoAluno);
                        alunos[numAlunos++] = novoAluno;
                    }
                    break;
                case 2:
                    for (int i = 0; i < numAlunos; i++) {
                        Aluno aluno = alunos[i];
                        System.out.println("----------------------");
                        System.out.println("Aluno " + (i + 1) + ": Nome: " + aluno.getNome() + ", Código: "
                                + aluno.getCodigo() + ", Endereço: " + aluno.getEndereco());
                        if (aluno.getTurma() != null) {
                            Turma turma = aluno.getTurma();
                            System.out.println("Turma: Semestre " + turma.getSemestre() + ", Ano " + turma.getAno());
                        }
                        System.out.println("----------------------");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void menuProfessores() {
        int opcao;
        do {
            System.out.println("----------------------");
            System.out.println("Menu Professores:");
            System.out.println("1 - Cadastrar professor");
            System.out.println("2 - Listar professores");
            System.out.println("0 - Sair");
            System.out.println("----------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (numTurmas == 0) {
                        System.out.println("Nenhuma turma cadastrada. Cadastre uma turma primeiro.");
                    } else {
                        System.out.println("Selecione uma turma para o professor:");
                        for (int i = 0; i < numTurmas; i++) {
                            System.out.println((i + 1) + " - Turma: Semestre " + turmas[i].getSemestre() + " Ano "
                                    + turmas[i].getAno());
                        }
                        int turmaIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        System.out.println("Digite o nome do professor:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o endereço do professor:");
                        String endereco = scanner.nextLine();
                        System.out.println("Digite a matéria que o professor ensina:");
                        String materia = scanner.nextLine();

                        Professor novoProfessor = new Professor(nome, endereco, materia, turmas[turmaIndex]);
                        turmas[turmaIndex].setProfessor(novoProfessor);
                        professores[numProfessores++] = novoProfessor;
                    }
                    break;
                case 2:
                    for (int i = 0; i < numProfessores; i++) {
                        Professor professor = professores[i];
                        System.out.println("----------------------");
                        System.out.println("Professor " + (i + 1) + ": Nome: " + professor.getNome() + ", Endereço: "
                                + professor.getEndereco() + ", Matéria: " + professor.getMateria());
                        if (professor.getTurma() != null) {
                            Turma turma = professor.getTurma();
                            System.out.println("Turma: Semestre " + turma.getSemestre() + ", Ano " + turma.getAno());
                        }
                        System.out.println("----------------------");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void menuTurmas() {
        int opcao;
        do {
            System.out.println("----------------------");
            System.out.println("Menu Turmas:");
            System.out.println("1 - Cadastrar turma");
            System.out.println("2 - Listar turmas");
            System.out.println("0 - Sair");
            System.out.println("----------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (numCursos == 0) {
                        System.out.println("Nenhum curso cadastrado. Cadastre um curso primeiro.");
                    } else {
                        if (numTurmas < turmas.length) {
                            Turma novaTurma = Turma.criarTurma(scanner, cursos, numCursos);
                            if (novaTurma != null) {
                                turmas[numTurmas++] = novaTurma;
                                System.out.println("Turma criada com sucesso.");
                            } else {
                                System.out.println("Falha ao criar a turma.");
                            }
                        } else {
                            System.out.println("Número máximo de turmas cadastradas.");
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < numTurmas; i++) {
                        Turma turma = turmas[i];
                        if (turma != null) {
                            System.out.println("----------------------");
                            System.out.println("Turma - Semestre: " + turma.getSemestre() + ", Ano: " + turma.getAno());
                            if (turma.getCurso() != null) {
                                System.out.println("Curso Associado: " + turma.getCurso().getNome());
                            }
                            if (turma.getProfessor() != null) {
                                System.out.println("Professor: " + turma.getProfessor().getNome());
                            } else {
                                System.out.println("Nenhum professor associado.");
                            }
                            if (!turma.getAlunos().isEmpty()) {
                                System.out.println("Alunos:");
                                for (Aluno aluno : turma.getAlunos()) {
                                    System.out.println("- " + aluno.getNome() + ", Código: " + aluno.getCodigo());
                                }
                            } else {
                                System.out.println("Nenhum aluno associado.");
                            }
                            System.out.println("----------------------");
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void menuCursos() {
        int opcao;
        do {
            System.out.println("----------------------");
            System.out.println("Menu Cursos:");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Listar cursos");
            System.out.println("0 - Sair");
            System.out.println("----------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (numCursos < cursos.length) {
                        Curso novoCurso = Curso.criarCurso();
                        cursos[numCursos++] = novoCurso;
                    } else {
                        System.out.println("Número máximo de cursos cadastrados.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < numCursos; i++) {
                        System.out.println("----------------------");
                        System.out.println("Curso " + (i + 1) + ":");
                        System.out.println("Nome: " + cursos[i].getNome());
                        System.out.println("Sigla: " + cursos[i].getSigla());
                        System.out.println("----------------------");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

}
