# Imersão Java

Este repositório contém os desafios da segunda edição da [Imersão Java da Alura](https://grupoalura.notion.site/Imers-o-Java-2-Edi-o-Guia-do-Mergulho-69e40005601f4d089a9add98251197de) [27 a 31 de março].

## [Aula 1] 

Utilizando Java no VS Code para acessar e consumir API do IMDB (Top 250 Filmes).

### Desafios Aula 1
1 - Utilizando End-Point para acessar as séries mais populares do site.

    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";

2 - Configurando a estética da apresentação das informações.

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

Mude seu terminal no vscode para o “cmd”
• Digite o comando para ver o emoji: chcp 65001                

3 - Utilizando variavel de ambiente para esconder chave de acesso. 
    SET IMDB_API_KEY="variavel que vai ser usada"

    String imdbKey = System.getenv("IMDB_API_KEY");
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json" + imdbKey;


## [Aula 2]

Nesta segunda aula vamos criar um gerador de figurinhas explorando outras bibliotecas nativas do Java, para que possamos enviar por Whatsapp os nossos filmes preferidos!

### Desafios Aula 2

1 - Criando diretório para saida das imagens caso não exista.

    // Gerando o diretório "saida/".
    var diretorio = new File("saida/"); // nome da pasta
    diretorio.mkdir(); // cria a pasta                            

    // Criando a imagem no diretório "saida/" + nome do titulo. 
    String nomeArquivo = "saida/"+titulo+".png";

2 - Centralizando o texto na nova imagem.

    // Escrever a frase na nova imagem centralizada
    FontMetrics FontMetrics = graphics.getFontMetrics();
    Rectangle2D retangulo = FontMetrics.getStringBounds(nome, graphics);
    int larguratexto = (int) retangulo.getWidth();

    // Posição do texto em X e Y.
    int posicaotextoX = (largura - larguratexto)/2;
    int posicaotextoY = novaAltura - 100;

    // Desenhando o texto na nova imagem.
    graphics.drawString(nome, posicaotextoX, posicaotextoY);

3 - Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.

    // configurar a fonte
    var fonte = new Font("Impact", Font.BOLD, 100);

4 - Colocar contorno (outline) no texto da imagem.

    FontRenderContext fontRenderContext = graphics.getFontRenderContext();
    var textLayout = new TextLayout(texto, fonte, fontRenderContext);

    Shape outline = textLayout.getOutline(null);
    AffineTransform transform = graphics.getTransform();
    transform.translate(posicaotextoX, posicaotextoY);
    graphics.setTransform(transform);

    var outlineStroke = new BasicStroke(largura * 0.004f);
    graphics.setStroke(outlineStroke);

    graphics.setColor(Color.BLACK);
    graphics.draw(outline);
    graphics.setClip(outline);

## [Aula 3]

Chegou o momento de pegarmos os filmes do IMDb e gerar figurinhas com os pôsteres, aproveitando para melhorar nosso código com as refatorações necessárias para torná-lo mais flexível e fácil de entender.

### Desafios Aula 3

1 - Transformar a classe que representa os conteúdos em um Record, disponível a partir do Java 16. 

    public record Conteudo(String titulo, String urlImagem ) {}

2 - Criar as suas próprias exceções e usá-las na classe que implementa o cliente HTTP. 

    catch (IOException | InterruptedException ex) {
        throw new ClienteHttoException("Erro ao consultar a URL :(");
    }

    fazemos uma nova classe Exception extanciando a classe mãe

    public class ClienteHttoException extends RuntimeException{

        public ClienteHttoException(String message) {
            super(message);
        }

    }

3 - Usar recursos do Java 8 e posterior, como Streams e Lambdas, para mapear uma lista em uma outra. 

    Codigo do Extrator Nasa
    return listaDeAtributos.stream()
        .map(atributos -> new Conteudo(atributos.get("title"),atributos.get("url"))).toList();

    Codigo do Extrator IMDB
    return listaDeAtributos.stream()
        .map(atributos -> new Conteudo(atributos.get("title"),atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg"))).toList();

4 - Criar uma Enum que une, como configurações, a URL da API e o extrator utilizado.

    public enum API {
        IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()),
        IMDB_TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtratorDeConteudoDoIMDB()),
        NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new ExtratorDeConteudoDaNasa());

        private String url;
        private ExtratorDeConteudo extrator;

        API(String url, ExtratorDeConteudo extrator){
            this.url = url;
            this.extrator = extrator;
        }

        public String getUrl(){
            return url;
        }

        public ExtratorDeConteudo getExtrator() {
            return extrator;
        }

    }

    mudança no main
    API api = API.IMDB_TOP_MOVIES;
        
    String url = api.getUrl();
    ExtratorDeConteudo extrator = api.getExtrator();