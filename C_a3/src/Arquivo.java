import java.util.ArrayList;
import java.io.*;

public class Arquivo{
    public void escrever(Aluno a){

        OutputStream os = null; // fluxo de entrada
        OutputStreamWriter osw = null; //leitor de fluxo de entrada
        BufferedWriter bw = null; //buffer entrada

        try{
            os = new FileOutputStream("Alunos.txt", true); // abrindo saida de dados
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("=======ALUNOS=======\n"); // escrevendo no arquivo texto nome, curso, matricula e media
            bw.write(a.getNome() + "\n");
            bw.write(a.getCurso() + "\n");
            bw.write(a.getMatricula() + "\n");
            bw.write(a.getMedia() + "\n");

        }catch (Exception e){
            System.out.println("erro " + e);
        }finally{
            try{
                bw.close();
            }catch (Exception e){
            }
        }
    }
    public ArrayList<Aluno> ler(){

        ArrayList<Aluno> listando = new ArrayList<>();

        InputStream is = null; //fluxo saida
        InputStreamReader isr = null; //gerador de fluxo de saida
        BufferedReader br = null; // buffer de saida

        String aux; // variavel auxiliar

        try{
            // instanciando os objetos
            is = new FileInputStream("Alunos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // colocando o cursor no inicio do arquivo
            aux = br.readLine();

            while (aux != null){
                if (aux.contains("=======ALUNOS=======")){
                    Aluno a1 = new Aluno();

                    a1.setNome(br.readLine());
                    a1.setCurso(br.readLine());
                    a1.setMatricula(Integer.parseInt(br.readLine()));
                    a1.setMedia(Float.parseFloat(br.readLine()));

                    listando.add(a1); // adicionando aluno na lista
                }
                aux = br.readLine();
            }
        }catch (Exception e){
        } finally{
            try{
                br.close();
            }catch (Exception e){
            }
        }
        return listando;
    }
}