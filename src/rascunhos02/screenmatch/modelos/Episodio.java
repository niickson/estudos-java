package rascunhos02.screenmatch.modelos;
import rascunhos02.screenmatch.calculos.Classificavel;
//Classe Isolada 01
public class Episodio implements Classificavel{
//Atributos    
    private int numero;
    private String nome;
    private Serie serie; //Referencia a série a qual ele pertence
    private int totalVisu;
//Métodos Especiais
    public int getTotalVisu() {
        return totalVisu;
    }
    public void setTotalVisu(int totalVisu) {
        this.totalVisu = totalVisu;
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }        
//Métodos implementados
    @Override
    public int getClassificacao() {
        if(totalVisu >= 400){
            return 4;
        }else{
            return 2;
        }
    }
}
