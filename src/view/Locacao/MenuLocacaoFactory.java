package view.Locacao;

import controller.gerenciadores.GerenciadorDeLocacao;
import view.MenuComSubmenus;
import view.MenuFactory;
import view.Veiculos.MenuAlterarVeiculoCadastrado;

public class MenuLocacaoFactory implements MenuFactory {

    private final GerenciadorDeLocacao gerenciadorDeLocacao;

    public MenuLocacaoFactory(GerenciadorDeLocacao gerenciadorDeLocacao) {
        this.gerenciadorDeLocacao = gerenciadorDeLocacao;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeVeiculos = new MenuComSubmenus("Menu de Locação");
        menuDeVeiculos.adicionarSubMenu(new MenuCadastrarLocacao(gerenciadorDeLocacao));
        menuDeVeiculos.adicionarSubMenu(new MenuEfetuarAluguel(gerenciadorDeLocacao));
        menuDeVeiculos.adicionarSubMenu(new MenuEfetuarDevolucao(gerenciadorDeLocacao));
        menuDeVeiculos.adicionarSubMenu(new MenuListarContratosEmAberto(gerenciadorDeLocacao));
        menuDeVeiculos.adicionarSubMenu(new MenuBuscarContrato(gerenciadorDeLocacao));
        return menuDeVeiculos;
    }
}
