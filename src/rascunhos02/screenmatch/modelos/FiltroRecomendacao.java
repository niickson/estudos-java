package rascunhos02.screenmatch.modelos;
import rascunhos02.screenmatch.calculos.Classificavel;
//Classe Isolada 03
public class FiltroRecomendacao {
    public void filtra(Classificavel classificavel){
        if(classificavel.getClassificacao() >= 4){
            System.out.println("Esta entre os preferidos da turma. ");
        }else if(classificavel.getClassificacao() >= 2){
            System.out.println("Muito bem avaliado entre a turma. ");
        }else{
            System.out.println("Coloque na sua lista para assistir depois. ");
        }
    }
}
