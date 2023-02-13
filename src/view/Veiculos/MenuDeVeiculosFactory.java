package view.Veiculos;

import controller.gerenciadores.GerenciadorDeVeiculos;
import view.MenuComSubmenus;
import view.MenuFactory;

public class MenuDeVeiculosFactory implements MenuFactory {

    private final GerenciadorDeVeiculos gerenciadorDeVeiculos;

    public MenuDeVeiculosFactory(GerenciadorDeVeiculos gerenciadorDeVeiculos) {
        this.gerenciadorDeVeiculos = gerenciadorDeVeiculos;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeVeiculos = new MenuComSubmenus("Menu de Veiculos");
        menuDeVeiculos.adicionarSubMenu(new MenuCadastrarVeiculo(gerenciadorDeVeiculos));
        menuDeVeiculos.adicionarSubMenu(new MenuAlterarVeiculoCadastrado(gerenciadorDeVeiculos));
        menuDeVeiculos.adicionarSubMenu(new MenuBuscarVeiculo(gerenciadorDeVeiculos));
        menuDeVeiculos.adicionarSubMenu(new MenuListarVeiculos(gerenciadorDeVeiculos));
        return menuDeVeiculos;
    }
}
