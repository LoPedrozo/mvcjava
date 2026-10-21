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
    // Se não for um número, devolve -1 para o Model recusar.
    public double pedirPreco() {
        System.out.print("Preço do produto: ");
        String texto = teclado.nextLine().replace(",", ".");
        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    // Mostra um único produto
    public void exibirProduto(Produto produto) {
        System.out.println("ID: " + produto.getId()
                + " | Nome: " + produto.getNome()
                + " | Preço: R$ " + String.format("%.2f", produto.getPreco()));
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
