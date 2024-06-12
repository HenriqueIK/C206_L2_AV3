public class Aluno implements Comparable<Aluno>{
    private String Nome; // nome do aluno
    private int Matricula; // numero da matricula do aluno
    private String Curso; // curso do aluno
    private float Media; // media do aluno
    public String getNome(){
        return Nome;
    }
    public void setNome(String nome){
        Nome = nome;
    }
    public int getMatricula(){
        return Matricula;
    }
    public void setMatricula(int matricula){
        Matricula = matricula;
    }
    public String getCurso(){
        return Curso;
    }
    public void setCurso(String curso){
        Curso = curso;
    }
    public float getMedia(){
        return Media;
    }
    public void setMedia(float media){
        Media = media;
    }
    @Override
    public int compareTo(Aluno e){
        return Float.compare(Media, e.Media);
    }
}