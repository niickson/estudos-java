# ScreenMatch

Projeto de estudo de **Programação Orientada a Objetos** em Java. O ScreenMatch modela um catálogo de mídia — filmes, séries e episódios —, calcula médias de avaliação, recomenda títulos com base nas notas e ainda busca dados reais de filmes na API pública do [OMDb](https://www.omdbapi.com/).

## O que o projeto faz

- Cadastra filmes e séries, com avaliações e cálculo de nota média.
- Calcula o tempo total para "maratonar" os títulos disponíveis.
- Classifica e recomenda títulos de acordo com a avaliação.
- Ordena catálogos por nome e por ano de lançamento.
- Busca informações reais de um filme pelo nome, consumindo a API do OMDb e convertendo o JSON de resposta em objetos Java.

## Conceitos de POO praticados

- **Herança** — `Filme` e `Serie` estendem a classe base `Titulo`.
- **Interface** — `Classificavel` define um contrato de classificação.
- **Polimorfismo** — `CalculadoraDeTempo` opera sobre qualquer `Titulo`.
- **Encapsulamento** — atributos privados com métodos de acesso.
- **Exceção personalizada** — `ErroDeConversaoDeAnoException`.
- **Record** — `TituloOmdb` representa a resposta da API.
- **Generics e Collections** — listas de títulos.
- **`Comparable` / `Comparator`** — ordenação de catálogos.
- **Pattern matching** — `instanceof` com variável de padrão.

## Estrutura

```
screenmatch/
└── src/
    └── screenmatch/
        ├── modelos/     # Titulo, Filme, Serie, Episodio, TituloOmdb, FiltroRecomendacao
        ├── calculos/    # CalculadoraDeTempo, Classificavel
        └── excecoes/    # ErroDeConversaoDeAnoException
```

As classes de entrada (com `main`) ficam no pacote base e demonstram etapas diferentes do projeto.

## Como executar

1. Abra o projeto no NetBeans.
2. Crie um arquivo `config.properties` na raiz do projeto com sua chave da API do OMDb:
   ```
   omdb.apikey=SUA_CHAVE_AQUI
   ```
   > Esse arquivo está no `.gitignore` e **não** é enviado ao GitHub, para manter a chave em segredo. Você obtém uma chave gratuita em [omdbapi.com](https://www.omdbapi.com/apikey.aspx).
3. Execute a classe principal.

## Tecnologias

- Java 17+
- [Gson](https://github.com/google/gson) 2.14.0 (conversão de JSON)
- API pública do OMDb

---

Projeto desenvolvido como estudo, com base no curso ScreenMatch da Alura.
