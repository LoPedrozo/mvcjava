# MVC Java - Cadastro de Produtos

Aplicação simples de console em Java, feita para a aula de MVC de Arquitetura de Software.
Permite **cadastrar** e **listar** produtos (id, nome e preço).

## Estrutura de pastas

```
mvcjava/
├── Main.java
├── model/
│   └── Produto.java
├── view/
│   └── ProdutoView.java
└── controller/
    └── ProdutoController.java
```

## Papel de cada camada

- **Model** (`Produto.java`): guarda os dados dos produtos e aplica as regras (nome não vazio, preço não negativo).
- **View** (`ProdutoView.java`): conversa com o usuário: mostra o menu e as mensagens e lê o teclado.
- **Controller** (`ProdutoController.java`): faz a ponte entre a View e o Model, decidindo o que chamar em cada opção.

## Como compilar e rodar

```bash
cd mvcjava
javac Main.java model/*.java view/*.java controller/*.java
java Main
```
