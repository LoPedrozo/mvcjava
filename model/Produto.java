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

    // Lista estática: guarda todos os produtos cadastrados (nosso "banco de dados")
    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    // Contador usado para gerar o id automaticamente (1, 2, 3...)
    private static int proximoId = 1;

    // Construtor: cria um produto com id, nome e preço
    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    // Regra de negócio: valida os dados e salva o produto na lista.
    // Retorna true se salvou e false se os dados forem inválidos.
    public static boolean salvar(String nome, double preco) {
        // O nome não pode ser vazio
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        // O preço não pode ser negativo
        if (preco < 0) {
            return false;
        }

        // Dados válidos: cria o produto com o próximo id e guarda na lista
        Produto produto = new Produto(proximoId, nome.trim(), preco);
        listaProdutos.add(produto);
        proximoId = proximoId + 1;
        return true;
    }

    // Retorna a lista com todos os produtos cadastrados
    public static ArrayList<Produto> listarTodos() {
        return listaProdutos;
    }
}
