package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Produto;

// CAMADA VIEW
// Cuida só da interação com o usuário: mostra coisas na tela e lê o teclado.
// Não acessa a lista do Model e não decide nenhuma regra de negócio.
public class ProdutoView {

    // Scanner para ler o que o usuário digita
    private Scanner teclado = new Scanner(System.in);

    // Mostra o menu de opções
    public void mostrarMenu() {
        System.out.println();
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção digitada. Se não for número, devolve -1 (opção inválida)
    public int lerOpcao() {
        String texto = teclado.nextLine();
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    // Pede o nome do produto
    public String pedirNome() {
        System.out.print("Nome do produto: ");
        return teclado.nextLine();
    }

    // Pede o preço do produto. Aceita vírgula ou ponto (ex.: 59,90 ou 59.90).
    // Se o texto não for um número, pergunta de novo.
    // (A View só confere o formato; se o preço é válido quem decide é o Model.)
    public double pedirPreco() {
        while (true) {
            System.out.print("Preço do produto: ");
            String texto = teclado.nextLine().replace(",", ".");
            try {
                double preco = Double.parseDouble(texto.trim());
                if (Double.isFinite(preco)) {
                    return preco;
                }
            } catch (NumberFormatException erro) {
                // Não é número: cai na mensagem abaixo e pergunta de novo
            }
            System.out.println("Digite um número (ex.: 59,90).");
        }
    }

    // Pede a quantidade em estoque. Se o texto não for um número inteiro, pergunta de novo.
    public int pedirEstoque() {
        while (true) {
            System.out.print("Quantidade em estoque: ");
            String texto = teclado.nextLine();
            try {
                return Integer.parseInt(texto.trim());
            } catch (NumberFormatException erro) {
                System.out.println("Digite um número inteiro (ex.: 10).");
            }
        }
    }

    // Mostra um único produto
    public void exibirProduto(Produto produto) {
        System.out.println("ID: " + produto.getId()
                + " | Nome: " + produto.getNome()
                + " | Preço: R$ " + String.format("%.2f", produto.getPreco())
                + " | Estoque: " + produto.getEstoque());
    }

    // Mostra a lista de produtos que o Controller entregou
    public void exibirLista(ArrayList<Produto> produtos) {
        System.out.println();
        System.out.println("===== PRODUTOS =====");
        if (produtos.size() == 0) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                exibirProduto(produtos.get(i));
            }
        }
    }

    // Mostra uma mensagem (de sucesso ou de erro)
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
