package rascunhos02.screenmatch.modelos;
//Classe Filha 02
public class Serie extends Titulo{
//Atributos    
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
//Método Construtor
    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }
//Métodos Especiais
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
//Métodos Sobrepostos
    @Override
    public int getDuracaoEmMinutos(){
        return this.temporadas * this.episodiosPorTemporada * this.minutosPorEpisodio;
    }
    
    @Override
    public void exibeFichaTecnica(){
    System.out.println("Nome da serie: " + this.getNome());
    System.out.println("Ano de lancamento: " + this.getAnoDeLancamento());
    System.out.println("Incluso no plano: " + this.isIncluidoNoPlano());
    }
    
    @Override
    public String toString(){
        return "Serie: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
