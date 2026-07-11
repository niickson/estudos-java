package screenmatch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import screenmatch.modelos.Filme;
import screenmatch.modelos.Serie;
import screenmatch.modelos.Titulo;
//Classe Principal com Listas
//Minha chave de acesso ao OMDb API: d4ecd227
public class PrincipalComListas {
    public static void main(String[] args) {
        Filme f1 = new Filme("Interestelar", 2014);
        f1.avalia(7.50);
        Filme f2 = new Filme("Poderoso chefao", 1972);
        f2.avalia(8.50);
        Filme f3 = new Filme("O sexto sentido", 1999);
        f3.avalia(9.50);
        Serie s1 = new Serie("Invencivel", 2021);
        s1.avalia(9.75);
        
        List<Titulo> lista = new LinkedList<>();
        lista.add(f1);
        lista.add(f2);
        lista.add(f3);
        lista.add(s1);
        
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificacao: " + filme.getClassificacao());
            }
        }
        
        System.out.println("--- Lista dos titulos ordenados ---");
        Collections.sort(lista);
        System.out.println(lista);
        //Forma mais atual de se fazer comparações no JAVA
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("--- Ordenando por ano ---");
        System.out.println(lista);
    }
}
