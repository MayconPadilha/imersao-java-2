# Imersão Java

Este repositório contém os desafios da segunda edição da [Imersão Java da Alura](https://grupoalura.notion.site/Imers-o-Java-2-Edi-o-Guia-do-Mergulho-69e40005601f4d089a9add98251197de) [27 a 31 de março].

## [Aula 1] 

Utilizando Java no VS Code para acessar e consumir API do IMDB (Top 250 Filmes).

[App](https://github.com/WMarques25/Imersao-Java-Alura/blob/main/alura-stickers/src/App.java) - Aplicação principal, acessando e exibindo os dados da API.

[Parser](https://github.com/WMarques25/Imersao-Java-Alura/blob/main/alura-stickers/src/JsonParser.java) - Classe para "parsear", filtrando as informações do arquivo Json

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

### [Desafio 2]
<!-- 1. Criar diretório de saída das imagens, se ainda não existir;
2. Centralizar o texto na figurinha;
3. Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes;
4. Colocar contorno (outline) no texto da imagem; 
5. Colocar uma imagem de você que está fazendo esse curso sorrindo, fazendo joinha e fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB. -->

