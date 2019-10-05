public class Aluno {
    // Atributes
    private String rgm;
    private String nome;
    private String curso;
    private String semestre;
    private int idade;
    private Float media;


    // Accessor Methods
    public String getRgm() {
        return this.rgm;
    }

    public void setRgm(String rgm) {
        this.rgm = rgm;
    }    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSemestre() {
        return this.semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Float getMedia() {
        return this.media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }
    
    // Other Methods
    public static void printMenu() {
        System.out.println("\nMenu Interativo");
        System.out.println("===========================");
        System.out.println("Selecione alguma das opções abaixo:\n");
        System.out.println("1) Inserir novo aluno");
        System.out.println("2) Listar todos os Alunos");
        System.out.println("3) Alterar dados por RGM");
        System.out.println("4) Pesquisar por RGM");
        System.out.println("5) Pesquisar alunos de um Curso");
        System.out.println("6) Aluno com maior Média de um Curso");
        System.out.println("7) Alunos de uma faixa etária");
        System.out.println("8) Pressione '#' para encerrar o programa");
    }

    public String novoAluno(
    String rgm,
    String nome,
    String curso,
    String semestre,
    int idade,
    Float media){
        this.rgm = rgm;
        this.nome = nome;
        this.curso = curso;
        this.semestre = semestre;
        this.idade = idade;
        this.media = media;
        return "\nAluno criado com sucesso";
    }

    public void tableAlunos(){
        System.out.println("\nFicha Aluno");
        System.out.println("===============================");
        System.out.println("Nome: " + this.getNome() + 
                            "\nRGM: " + this.getRgm() + 
                            "\nCurso: " + this.getCurso() + 
                            "\nSemestre: " + this.getSemestre() +
                            "\nIdade: " + this.getIdade() +
                            "\nMedia Final: " + this.getMedia()
                            );
        
    }

    public void listAlunos() {
        System.out.println(
                "Nome: " + this.getNome() + " | " + 
                "RGM: " + this.getRgm() + " | " + 
                "Curso: " + this.getCurso());
    }

    public static Aluno pesquisaRGM(Aluno[] alunos, String rgm) {
        Aluno aluno = new Aluno();
        for (Aluno aluno1 : alunos) {
            if (aluno1 != null) {
                if (aluno1.getRgm().equals(rgm)) {
                    aluno = aluno1;
                }
            }
        }
        return aluno;                    
    }

    public static Aluno[] pesquisaCurso(Aluno[] alunos, String curso) {
        Aluno[] aluno = new Aluno[alunos.length];
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                if (alunos[i].getCurso().equals(curso)) {
                    aluno[i] = alunos[i];
                }

            }
        }
        return aluno;                    
    }
    
    public static Aluno maiorMediaCurso(Aluno[] alunos, String curso){
        Aluno aluno = new Aluno();
        int contador = 0;
        while(aluno.getRgm() == null){
            if(alunos[contador] != null){
                if(alunos[contador].getCurso().equals(curso)){
                    aluno = alunos[contador];
                } 
            } else {
            }
            contador++;
        }
        for (Aluno aluno1 : alunos) {
            if (aluno1 != null) {
                if (aluno1.getCurso().equals(curso)) {
                    if (aluno1.getMedia() > aluno.getMedia()) {
                        aluno = aluno1;
                    } 
                }
            }
        }
        return aluno;  
    }
    
    public static Aluno[] faixaEtaria(Aluno[] alunos, int idadeMenor, int idadeMaior){
        Aluno[] aluno = new Aluno[alunos.length];
        int contador = 0;
        for (Aluno aluno1 : alunos) {
            if (aluno1 != null) {
                if (aluno1.getIdade() >= idadeMenor && aluno1.getIdade() <= idadeMaior) {
                    aluno[contador] = aluno1;
                    contador++;
                }
            }
        }
        return aluno;
    }
}