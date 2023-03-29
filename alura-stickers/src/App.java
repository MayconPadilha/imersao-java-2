import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size());

        // exibir e manipular os dados 
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            
            float rate = Float.parseFloat(filme.get("imDbRating"));
				
				if (rate > 0 && rate < 2) {
					System.out.println("Classificação: " + filme.get("imDbRating") + " ★✩✩✩✩");
				} else if (rate > 2 && rate < 4) {
					System.out.println("Classificação: " + filme.get("imDbRating") + " ★★✩✩✩");
				} else if (rate > 4 && rate < 6) {
					System.out.println("Classificação: " + filme.get("imDbRating") + " ★★★✩✩");
				} else if (rate > 6 && rate < 8) {
					System.out.println("Classificação: " + filme.get("imDbRating") + " ★★★★✩");
				} else if (rate > 8 && rate < 10) {
					System.out.println("Classificação: " + filme.get("imDbRating") + " ★★★★★");
				} else {
					System.out.println("Sem Avaliação");
				}
				System.out.println("\n");
				
        } 
    }
}
