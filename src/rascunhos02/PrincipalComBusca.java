package rascunhos02;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rascunhos02.screenmatch.excecoes.ErroDeConversaoDeAnoException;
import rascunhos02.screenmatch.modelos.Titulo;
import rascunhos02.screenmatch.modelos.TituloOmdb;
//Programa Principal com Busca
//Minha chave de acesso ao OMDb API: d4ecd227
public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner pesquisa = new Scanner(System.in);
        String busca = "";
        //Lista que salva todos os titulos convertidos 
        List<Titulo> titulos = new ArrayList<>();
        
        //Faz com que os atributos sejam reconhecidos e não precise referencia-los com letra Maiuscula no Record.
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting().create();
        
        while(!busca.equalsIgnoreCase("sair")){
        System.out.println("Digite um filme para busca: ");
        busca = pesquisa.nextLine();
      
        if(busca.equalsIgnoreCase("sair")){
            break;
        }
        //Realiza uma busca no OMDb atravéz do nome do filme(digitado pelo usuario).
        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=d4ecd227";
        
        try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        String json = response.body();
        System.out.println(json);
        
 
        TituloOmdb tituloOmdb1 = gson.fromJson(json, TituloOmdb.class);
        System.out.println(tituloOmdb1);
        
        //Caso aconteça uma exceção, programa não para de rodar e me ajuda a identificar a exceção.
        //try {
            Titulo t1 = new Titulo(tituloOmdb1);
            System.out.println("Titulo convertido: ");
            System.out.println(t1);
            titulos.add(t1);
            
        }catch(NumberFormatException e){
            System.out.println("Aconteceu um erro! ");
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Algum erro de argumento na busca, verifique o endereco! ");
        }catch(ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }
        
        }       
        System.out.println(titulos);
        
        //Gravando dados em um arquivo ".txt", por exemplo.
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        
        System.out.println("O programa finalizou corretamente! ");            
    }
}
