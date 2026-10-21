package controller;

import java.util.ArrayList;

import model.Produto;
import view.ProdutoView;

// CAMADA CONTROLLER
// É o intermediário: recebe as ações do usuário (pela View),
// chama o Model para salvar/buscar e manda a View mostrar o resultado.
// Não tem println aqui: quem mostra na tela é a View.
public class ProdutoController {

    // Referência à View
    private ProdutoView view;

    // Construtor: recebe a View que o Controller vai usar
    public ProdutoController(ProdutoView view) {
        this.view = view;
    }

    // Cadastrar: pede os dados à View, tenta salvar no Model e avisa o resultado
    public void cadastrar() {
        String nome = view.pedirNome();
        double preco = view.pedirPreco();

        try {
            Produto.salvar(nome, preco);
            view.mostrarMensagem("Produto cadastrado com sucesso!");
        } catch (IllegalArgumentException erro) {
            // O Model diz qual regra foi quebrada; a View só mostra
            view.mostrarMensagem("Erro: " + erro.getMessage());
        }
    }

    // Listar: pega a lista do Model e manda a View exibir
    public void listar() {
        ArrayList<Produto> produtos = Produto.listarTodos();
        view.exibirLista(produtos);
    }

    // Iniciar: loop do menu até o usuário escolher 0 (Sair)
    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            view.mostrarMenu();
            opcao = view.lerOpcao();

            if (opcao == 1) {
                cadastrar();
            } else if (opcao == 2) {
                listar();
            } else if (opcao == 0) {
                view.mostrarMensagem("Saindo do sistema...");
            } else {
                view.mostrarMensagem("Opção inválida!");
            }
        }
    }
}
