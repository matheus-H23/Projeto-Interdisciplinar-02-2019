import java.util.Scanner;

public class TesteAluno {
    public static void main(String[] args) {
        //Initialize Classes
        Aluno[] aluno = new Aluno[100];
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        
        //Create Variables
        String digito = "0";
        int position = 0;
        String rgm;
        String curso;
        
        //Main Loop
        while(!digito.equals("#")){
            boolean alterou = false;
            Aluno.printMenu();
            digito = scanner.next();
            Aluno[] retorno = new Aluno[aluno.length];
            switch(digito){

                case "1":
                    System.out.println("\nCadastrar um novo aluno");
                    System.out.println("");
                    System.out.println("Insira o Nome do aluno: (Nome Completo)");
                    aluno[position].setNome(scanner.next());
                    System.out.println("Insira o RGM do aluno: ");
                    aluno[position].setRgm(scanner.next());
                    System.out.println("Insira o Curso do aluno: ");
                    aluno[position].setCurso(scanner.next());
                    System.out.println("Insira o Semestre do aluno: (1º Semestre) ");
                    aluno[position].setSemestre(scanner.next());
                    System.out.println("Insira a Idade do aluno: ");
                    aluno[position].setIdade(scanner.nextInt());
                    System.out.println("Insira a Media Final do aluno: ");
                    aluno[position].setMedia(scanner.nextFloat());
                    position++;
                    System.out.println("\n=============================");
                    System.out.println("Aluno cadastrado com Sucesso!");
                    System.out.println("=============================");
                    break;

                case "2":
                    for(int i = 0; i < aluno.length; i++){
                        if(aluno[i] != null){
                            aluno[i].listAlunos();
                        }
                        i++;
                    }
                    break;

                case "3":
                    System.out.println("\nInsira um RGM para alterar os dados: ");
                    rgm = scanner.nextLine();
                    for (int i = 0; i < aluno.length; i++) {
                        if(aluno[i] != null){
                            if(aluno[i].getRgm().equals(rgm)) {
                                System.out.println("\nAlterar dados cadastrais do Aluno:");
                                System.out.println("");
                                System.out.println("Insira o Nome do aluno: (Nome Completo)");
                                aluno[i].setNome(scanner.next());
                                System.out.println("Insira o RGM do aluno: ");
                                aluno[i].setRgm(scanner.next());
                                System.out.println("Insira o Curso do aluno: ");
                                aluno[i].setCurso(scanner.next());
                                System.out.println("Insira o Semestre do aluno: (1º Semestre) ");
                                aluno[i].setSemestre(scanner.next());
                                System.out.println("Insira a Idade do aluno: ");
                                aluno[i].setIdade(scanner.nextInt());
                                System.out.println("Insira a Media Final do aluno: ");
                                aluno[i].setMedia(scanner.nextFloat());
                                alterou = true;
                            }
                        }
                        i++;
                    }
                    if(alterou){
                        System.out.println("Dados do aluno foram alterados!");
                    } else {
                        System.out.println("\n=============================");
                        System.out.println("Aluno não encontrado!");
                        System.out.println("=============================");
                    }
                    break;
                case "4":
                    System.out.println("\nInsira um RGM: ");
                    rgm = scanner.next();
                    retorno[0] = Aluno.pesquisaRGM(aluno, rgm);
                    if(retorno[0].getRgm() != null){
                        retorno[0].tableAlunos();
                    } else {
                        System.out.println("\n=============================");
                        System.out.println("Nenhum registro encontrado!");
                        System.out.println("=============================");
                    }
                    break;

                case "5":
                System.out.println("\nInsira um Curso: ");
                curso = scanner.next();
                retorno = Aluno.pesquisaCurso(aluno, curso);
                System.out.println("\nAlunos: ");
                for (int i = 0; i < retorno.length; i++) {
                    if (retorno[i] != null) {
                        retorno[i].listAlunos();
                        alterou = true;
                    }
                }
                if(!alterou){
                    System.out.println("\n=================================");
                    System.out.println("Nenhum aluno matriculado no Curso!");
                    System.out.println("===================================");
                }
                break;
        
                case "6":
                    System.out.println("\nInsira um Curso: ");
                    curso = scanner.next();
                    retorno[0] = Aluno.maiorMediaCurso(aluno, curso);
                    if(retorno[0].getRgm() != null){
                        retorno[0].tableAlunos();
                    } else {
                        System.out.println("\n==================================");
                        System.out.println("Nenhum aluno matriculado no Curso!");
                        System.out.println("====================================");
                    }                
                    break;
                case "7":
                    System.out.println("\nInsira a Menor Idade: ");
                    int idadeMenor = scanner.nextInt();
                    System.out.println("\nInsira a Maior Idade: ");
                    int idadeMaior = scanner.nextInt();
                    retorno = Aluno.faixaEtaria(aluno, idadeMenor, idadeMaior);
                    System.out.println("\nAlunos: ");
                    for (int i = 0; i < retorno.length; i++) {
                        if (retorno[i] != null) {
                            retorno[i].listAlunos();
                            alterou = true;
                        }
                    }
                    if(!alterou){
                        System.out.println("\n==================================");
                        System.out.println("Nenhum aluno atende a esta Faixa Etária!");
                        System.out.println("====================================");
                    }                
                    break;
            }            
        }
    }
}