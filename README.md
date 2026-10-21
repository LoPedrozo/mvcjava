# MVC Java - Cadastro de Produtos

Aplicação simples de console em Java, feita para a aula de MVC de Arquitetura de Software.
Permite **cadastrar** e **listar** produtos (id, nome, preço e estoque).

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

- **Model** (`Produto.java`): guarda os dados dos produtos e aplica as regras (nome não vazio, preço e estoque não negativos). Quando uma regra é quebrada, o Model diz qual foi.
- **View** (`ProdutoView.java`): conversa com o usuário: mostra o menu e as mensagens e lê o teclado. Só confere se o que foi digitado é um número; quem decide se o valor é válido é o Model.
- **Controller** (`ProdutoController.java`): faz a ponte entre a View e o Model, decidindo o que chamar em cada opção.

## Como compilar e rodar

```bash
cd mvcjava
javac Main.java model/*.java view/*.java controller/*.java
java Main
```

## Teste do fluxo

Cadastro de 3 produtos (opção 1) e listagem (opção 2):

```
===== PRODUTOS =====
ID: 1 | Nome: Teclado | Preço: R$ 150.50 | Estoque: 10
ID: 2 | Nome: Mouse | Preço: R$ 59.90 | Estoque: 25
ID: 3 | Nome: Monitor | Preço: R$ 899.00 | Estoque: 4
```

Entradas inválidas também foram testadas:

| Entrada | Resultado |
| --- | --- |
| Nome vazio | `Erro: o nome não pode ser vazio.` |
| Preço `-5` | `Erro: o preço não pode ser negativo.` |
| Estoque `-2` | `Erro: o estoque não pode ser negativo.` |
| Preço `abc` | A View pede o preço de novo |
| Opção `9` no menu | `Opção inválida!` |

## Desafio extra: campo estoque

Para adicionar o campo `estoque`, as três camadas mudaram, cada uma só na sua parte:

- **Model**: novo atributo, getter e a regra "estoque não pode ser negativo".
- **View**: pergunta o estoque e mostra o valor na listagem.
- **Controller**: uma linha, só para repassar o estoque da View para o Model.

Mudar as três camadas aqui é esperado, porque é um dado novo (precisa ser guardado, pedido e mostrado).
A separação aparece no fato de que a regra ficou só no Model e a leitura do teclado só na View.
