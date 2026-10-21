import controller.ProdutoController;
import view.ProdutoView;

// Ponto de partida do programa.
// Só monta as peças (View e Controller) e inicia o sistema.
public class Main {

    public static void main(String[] args) {
        // Cria a View (tela)
        ProdutoView view = new ProdutoView();

        // Cria o Controller passando a View
        ProdutoController controller = new ProdutoController(view);

        // Começa o menu
        controller.iniciar();
    }
}
