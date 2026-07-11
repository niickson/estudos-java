package screenmatch;
import java.util.ArrayList;
import screenmatch.calculos.CalculadoraDeTempo;
import screenmatch.modelos.Episodio;
import screenmatch.modelos.Filme;
import screenmatch.modelos.FiltroRecomendacao;
import screenmatch.modelos.Serie;
//Programa Principal
public class Principal {
    public static void main(String[] args) {
        Filme f1 = new Filme("Interestelar", 2014);
        Filme f2 = new Filme("O poderoso chefao", 1972);
        Serie s1 = new Serie("Invencivel", 2021);
        Episodio episodio = new Episodio();
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        
        f1.setIncluidoNoPlano(true);
        f1.setDuracaoEmMinutos(180);
        
        f1.exibeFichaTecnica();
        f1.avalia(8.96);
        f1.avalia(6.05);
        f1.avalia(9.08);
        f1.avalia(7.52);
        f1.avalia(8.31);
        f1.setDiretor("Christopher Nolan");
        
        System.out.println("Diretor: " + f1.getDiretor());
        System.out.println("Soma das avaliacoes: " + f1.getSomaDasAvaliacoes());
        System.out.println("Total de avaliacoes: " + f1.getTotalDeAvaliacoes());
        System.out.println(String.format("Nota geral do filme: %.2f",f1.obterMedia()));
        
        f2.setIncluidoNoPlano(true);
        f2.setDuracaoEmMinutos(175);
        
        System.out.println("-------------------------------------------------------");
        s1.setIncluidoNoPlano(false);
        s1.exibeFichaTecnica();
        s1.setTemporadas(5);
        s1.setEpisodiosPorTemporada(8);
        s1.setMinutosPorEpisodio(45);
        s1.avalia(3.90);
        s1.avalia(7.56);
        s1.avalia(7.70);
        s1.avalia(8.80);
        s1.avalia(5.69);
        episodio.setNumero(1);
        episodio.setSerie(s1);
        episodio.setTotalVisu(500);
       
        
        System.out.println("Duracao em Minutos: " + s1.getDuracaoEmMinutos() + " min");
        System.out.println("Soma das avaliacoes: " + s1.getSomaDasAvaliacoes());
        System.out.println("Total de avaliacoes: " + s1.getTotalDeAvaliacoes());
        System.out.println(String.format("Nota geral da serie: %.2f",s1.obterMedia()));
        System.out.println("Episodio: " + episodio.getNumero() + " // Visualizacoes: " + episodio.getTotalVisu());
        filtro.filtra(episodio);
        
        System.out.println("-------------------------------------------------------");
        calculadora.inclui(f1);
        calculadora.inclui(s1);
        System.out.println("Tempo total para maratonar[filmes e series disponiveis]: " + calculadora.getTempoTotal());
        
        System.out.println("--------------------------------------------------------");
        System.out.println(f1.getNome());
        filtro.filtra(f1);
        
        System.out.println("=========================================================");
        listaDeFilmes.add(f1);
        listaDeFilmes.add(f2);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0));
        System.out.println(listaDeFilmes);
    }    
}

