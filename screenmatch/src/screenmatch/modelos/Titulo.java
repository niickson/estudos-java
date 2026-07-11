package screenmatch.modelos;
import screenmatch.excecoes.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;
//Classe Mãe
public class Titulo implements Comparable<Titulo>{
    //Atributos
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
//Métodos Construtores
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }
    
    public Titulo(TituloOmdb tituloOmdb1){
        this.nome = tituloOmdb1.title();
        //Criando uma excecção própria, caso o ano do filme que o Omdb me retornar tiver mais de 04 digitos.
        if(tituloOmdb1.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Nao consegui converter o ano porque tem mais de 04 caracteres! ");
        }
        //Convertendo String para inteiro
        this.anoDeLancamento = Integer.valueOf(tituloOmdb1.year());
        //Converte apenas uma parte especifica da String
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb1.runtime().substring(0,3));
    }
//Métodos Especiais
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }
    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    
    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }
    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }
//Métodos    
    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Ano de lancamento: " + this.anoDeLancamento);
        System.out.println("Tempo de duracao: " + this.duracaoEmMinutos + " min");
        System.out.println("Incluso no plano: " + this.incluidoNoPlano);
    }
    
    public void avalia(double nota){
       this.somaDasAvaliacoes += nota;
       this.totalDeAvaliacoes++;
    }
    
    public double obterMedia(){
        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }
//Métodos implementados
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "( Nome: " + nome + " \\ Ano de lancamento: " + anoDeLancamento + 
                " \\ Duracao(min): " + duracaoEmMinutos + " )";
    }
    
}
