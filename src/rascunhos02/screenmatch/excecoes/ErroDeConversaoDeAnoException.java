package rascunhos02.screenmatch.excecoes;
//Classe para as exceções
public class ErroDeConversaoDeAnoException extends RuntimeException{
//Atributos
    private String mensagem;
//Métodos    
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }
//Método implementado
    @Override
    public String getMessage(){
        return this.mensagem;
    }
}
