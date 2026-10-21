package model;

import java.util.ArrayList;

// CAMADA MODEL
// Representa um produto e guarda a lista de produtos cadastrados.
// Aqui ficam os dados e as regras. Não tem println nem Scanner.
public class Produto {

    // Atributos do produto
    private int id;
    private String nome;
    private double preco;
    private int estoque;

    // Lista estática: guarda todos os produtos cadastrados (nosso "banco de dados")
    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    // Contador usado para gerar o id automaticamente (1, 2, 3...)
    private static int proximoId = 1;

    // Construtor: cria um produto com id, nome, preço e estoque
    public Produto(int id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Getters: permitem ler os atributos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    // Regra de negócio: valida os dados e salva o produto na lista.
    // Se algum dado for inválido, lança um erro com a mensagem da regra quebrada.
    // As mensagens ficam aqui porque as regras são do Model.
    public static void salvar(String nome, double preco, int estoque) {
        // O nome não pode ser vazio
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("o nome não pode ser vazio.");
        }

        // O preço não pode ser negativo
        if (preco < 0) {
            throw new IllegalArgumentException("o preço não pode ser negativo.");
        }

        // O estoque não pode ser negativo
        if (estoque < 0) {
            throw new IllegalArgumentException("o estoque não pode ser negativo.");
        }

        // Dados válidos: cria o produto com o próximo id e guarda na lista
        Produto produto = new Produto(proximoId, nome.trim(), preco, estoque);
        listaProdutos.add(produto);
        proximoId = proximoId + 1;
    }

    // Retorna a lista com todos os produtos cadastrados
    public static ArrayList<Produto> listarTodos() {
        return listaProdutos;
    }
}
