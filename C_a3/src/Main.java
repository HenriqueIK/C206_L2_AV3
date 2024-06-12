import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Aluno p = new Aluno();
        Arquivo a = new Arquivo();
        boolean flag = true;

        while (flag){
            // ArrayList auxiliar para ler dados dos alunos
            ArrayList<Aluno> alunos = a.ler();

            System.out.println("====== Seja Bem-Vindo ao Sistema Acadêmico ======");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Listar alunos em ordem crescente(em relação à média)");
            System.out.println("4 - Ver a quantidade de alunos em cada curso");
            System.out.println("5 - Sair do sistema");
            System.out.println("=================================================");

            int op = sc.nextInt(); // operador para switch
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.println("Cadastrando novo aluno: ");
                    System.out.print("Nome: ");
                    p.setNome(sc.nextLine());
                    System.out.print("Curso: ");
                    try{
                        String Curso = sc.nextLine(); // adicionando o curso do aluno
                        p.setCurso(Curso);

                        if(!Curso.equals("GEC") && !Curso.equals("GES") && !Curso.equals("GET")){
                            throw new InfoInvalidaException(Curso);
                        }
                    }catch (InfoInvalidaException e){ // para o sistema por detectar tipo invalido
                        break;
                    }
                    System.out.println("Média: ");
                    p.setMedia(Float.parseFloat(sc.nextLine()));
                    System.out.print("Matricula: ");
                    try{
                        int Matricula = sc.nextInt(); // adicionando a matricula do aluno

                        if(Matricula <= 0){ // se matricula for menor ou igual a zero gerar exceção
                            throw new InfoInvalidaException(Matricula);
                        }
                        else{
                            p.setMatricula(Matricula); // salvando matricula
                        }
                    } catch (InfoInvalidaException e){ // para o sistema por detectar tipo invalido
                        break;
                    }
                    a.escrever(p); // escrevendo dados no arquivo
                    break;
                case 2:
                    System.out.println("Lista de alunos: "); // mostrando alunos.txt
                    for (int i = 0; i < alunos.size(); i++){
                        System.out.println("Nome: " + alunos.get(i).getNome());
                        System.out.println("Matricula: " + alunos.get(i).getMatricula());
                        System.out.println("Curso: " + alunos.get(i).getCurso());
                        System.out.println("Media: " + alunos.get(i).getMedia());
                    }
                    break;
                case 3:
                    ArrayList<Aluno> alunMedia = a.ler();
                    // ordenando de forma crescente as medias
                    Collections.sort(alunMedia);

                    System.out.println("Media dos alunos em ordem crescente: ");
                    for (int i = 0; i < alunMedia.size(); i++){
                        System.out.println("Informacoes do aluno "+ (i+1) + ":");
                        System.out.println("\t" + alunMedia.get(i).getNome());
                        System.out.println("\t" + alunMedia.get(i).getMatricula());
                        System.out.println("\t" + alunMedia.get(i).getCurso());
                        System.out.println("\t" + alunMedia.get(i).getMedia());
                    }
                    break;
                case 4:
                    int comp = 0; // variaveis auxiliares para cursos
                    int soft = 0;
                    int telecom = 0;

                    System.out.println("Quantidade de alunos em cada curso: ");
                    for(int i = 0; i < alunos.size(); i++){
                        if(alunos.get(i).getCurso().equals("GEC")){
                            comp++;
                        }
                        if(alunos.get(i).getCurso().equals("GES")){
                            soft++;
                        }
                        if(alunos.get(i).getCurso().equals("GET")){
                            telecom++;
                        }
                    }
                    System.out.println("Computação: " + comp);
                    System.out.println("Software: " + soft);
                    System.out.println("Telecomunicações: " + telecom);
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}