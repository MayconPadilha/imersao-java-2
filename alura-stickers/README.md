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

## [Aula 2]

Importando imagens(arquivo local ou url), transformando em uma nova imagem .png com um texto em fundo transparente.

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
