package view;

import view.Clientes.MenuClientesFactory;
import view.Locacao.MenuLocacaoFactory;
import view.Veiculos.MenuDeVeiculosFactory;

public class MenuGeralFactory implements MenuFactory {

    private final MenuClientesFactory menuClientesFactory;
    private final MenuDeVeiculosFactory menuDeVeiculosFactory;
    private final MenuLocacaoFactory menuLocacaoFactory;

    public MenuGeralFactory(MenuClientesFactory menuClientesFactory, MenuDeVeiculosFactory menuDeVeiculosFactory, MenuLocacaoFactory menuLocacaoFactory) {
        this.menuClientesFactory = menuClientesFactory;
        this.menuDeVeiculosFactory = menuDeVeiculosFactory;
        this.menuLocacaoFactory = menuLocacaoFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();

        menuGeral.adicionarSubMenu(menuClientesFactory.create());
        menuGeral.adicionarSubMenu(menuDeVeiculosFactory.create());
        menuGeral.adicionarSubMenu(menuLocacaoFactory.create());
        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}