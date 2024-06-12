public class InfoInvalidaException extends Exception{
    public InfoInvalidaException(int Matricula){
        System.out.println("A matrícula: " + Matricula + ", é inválida, tente novamente");
    }
    public InfoInvalidaException(String Curso){
        System.out.println("O curso: " + Curso + ", é inválido, tente novamente");
    }
}