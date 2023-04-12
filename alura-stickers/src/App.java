import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        var diretorio = new File("saida/"); // nome da pasta
        diretorio.mkdir(); // cria a pasta

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        // for (Map<String, String> conteudo : listaDeConteudos) {

        for (int i = 0; i < 3; i++) {
            
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/"+conteudo.titulo()+".png";

            // float rate = Float.parseFloat(conteudo.get("imDbRating"));
            String nome = "Conseguindo";

            // if (rate > 0 && rate < 10) {
            //     System.out.println("Classificação: " + conteudo.get("imDbRating") + " ★✩✩✩✩");
            //     nome = "Muito Ruim";
            // } else if (rate > 2 && rate < 4) {
            //     System.out.println("Classificação: " + conteudo.get("imDbRating") + " ★★✩✩✩");
            //     nome = "Ruim";
            // } else if (rate > 4 && rate < 6) {
            //     System.out.println("Classificação: " + conteudo.get("imDbRating") + " ★★★✩✩");
            //     nome = "Neutro";
            // } else if (rate > 6 && rate < 8) {
            //     System.out.println("Classificação: " + conteudo.get("imDbRating") + " ★★★★✩");
            //     nome = "Bom";
            // } else if (rate > 8 && rate < 10) {
            //     System.out.println("Classificação: " + conteudo.get("imDbRating") + " ★★★★★");
            //     nome = "Muito Bom";
            // } else {
            //     System.out.println("Sem Avaliação");
            //     nome = "Sem Avaliação";
            // }
            // System.out.println("\n");

            geradora.cria(inputStream, nomeArquivo, nome);

            System.out.println(conteudo.titulo());
            System.out.println();

        }
    }
}
