package screenmatch.calculos;
import screenmatch.modelos.Titulo;
//Classe Isolada 02
public class CalculadoraDeTempo {
//Atributos    
    private int tempoTotal;
//Métodos Especiais
    public int getTempoTotal() {
        return tempoTotal;
    }
//Polimorfismo
    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }    
}
