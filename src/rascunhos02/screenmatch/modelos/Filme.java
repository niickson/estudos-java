package rascunhos02.screenmatch.modelos;
import rascunhos02.screenmatch.calculos.Classificavel;
//Classe Filha 01
public class Filme extends Titulo implements Classificavel{
//Atributos    
    private String diretor;
//Método Construtor
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }
//Métodos Especiais
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }   
//Métodos implementados
    @Override
    public int getClassificacao() { 
        return (int) obterMedia() / 2;      
    }
    
    @Override
    public String toString(){
        return "Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}