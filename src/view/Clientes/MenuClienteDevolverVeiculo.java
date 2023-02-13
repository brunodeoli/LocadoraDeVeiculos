package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import view.Submenu;

public class MenuClienteDevolverVeiculo extends Submenu {
    private final GerenciadorDeClientes gerenciadorDeClientes;
    public MenuClienteDevolverVeiculo(GerenciadorDeClientes gerenciadorDeClientes) {
        super("Devolução de veiculo de " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeClientes;
    }

    @Override
    public void acao() {

    }
}
