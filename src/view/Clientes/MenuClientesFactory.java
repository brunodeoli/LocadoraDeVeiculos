package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import view.MenuComSubmenus;
import view.MenuFactory;

public class MenuClientesFactory implements MenuFactory {

    private final GerenciadorDeClientes gerenciadorDeClientes;

    public MenuClientesFactory(GerenciadorDeClientes gerenciadorDeClientes) {
        this.gerenciadorDeClientes = gerenciadorDeClientes;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeClientes = new MenuComSubmenus("Menu de Clientes");
        menuDeClientes.adicionarSubMenu(new MenuCadastrarCliente(gerenciadorDeClientes));
        menuDeClientes.adicionarSubMenu(new MenuAlterarCliente(gerenciadorDeClientes));
        menuDeClientes.adicionarSubMenu(new MenuClienteAlugarVeiculo(gerenciadorDeClientes));
        menuDeClientes.adicionarSubMenu(new MenuClienteDevolverVeiculo(gerenciadorDeClientes));
        return menuDeClientes;
    }
}