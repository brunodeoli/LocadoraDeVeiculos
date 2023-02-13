package view;

import view.Clientes.MenuClientesFactory;
import view.Veiculos.MenuDeVeiculosFactory;

public class MenuGeralFactory implements MenuFactory {

    private final MenuClientesFactory menuClientesFactory;
    private final MenuDeVeiculosFactory menuDeVeiculosFactory;

    public MenuGeralFactory(MenuClientesFactory menuClientesFactory, MenuDeVeiculosFactory menuDeVeiculosFactory) {
        this.menuClientesFactory = menuClientesFactory;
        this.menuDeVeiculosFactory = menuDeVeiculosFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();
        MenuComSubmenus menuDeClientes = menuClientesFactory.create();

        menuGeral.adicionarSubMenu(menuDeClientes);
        menuGeral.adicionarSubMenu(menuDeVeiculosFactory.create());
        menuGeral.adicionarSubMenu(new MenuComSubmenus("Menu de Empréstimos"));
        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}