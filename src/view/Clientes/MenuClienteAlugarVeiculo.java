package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import view.Submenu;

public class MenuClienteAlugarVeiculo extends Submenu {
    private final GerenciadorDeClientes gerenciadorDeClientes;

    public MenuClienteAlugarVeiculo(GerenciadorDeClientes gerenciadorDeClientes) {
        super("Alugar para " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeClientes;
    }

    @Override
    public void acao() {

    }
}
