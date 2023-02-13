import controller.gerenciadores.GerenciadorDeClientes;
import controller.gerenciadores.GerenciadorDeVeiculos;
import controller.repository.ClientesRepository;
import controller.repository.VeiculosRepository;
import model.entidades.Cliente;
import view.Clientes.MenuClientesFactory;
import view.MenuComSubmenus;
import view.MenuGeralFactory;
import view.Veiculos.MenuDeVeiculosFactory;

public class App {
    public static void main(String[] args) {
        ClientesRepository repositorioDeClientes = new ClientesRepository();
        GerenciadorDeClientes gerenciadorDeClientes = new GerenciadorDeClientes(repositorioDeClientes);

        VeiculosRepository veiculosRepository = new VeiculosRepository();
        GerenciadorDeVeiculos gerenciadorDeVeiculos = new GerenciadorDeVeiculos(veiculosRepository);

        MenuClientesFactory menuClientesFactory = new MenuClientesFactory(gerenciadorDeClientes);
        MenuDeVeiculosFactory menuDeVeiculosFactory = new MenuDeVeiculosFactory(gerenciadorDeVeiculos);

        MenuComSubmenus menuGeral = new MenuGeralFactory(menuClientesFactory, menuDeVeiculosFactory).create();
        menuGeral.agir();
    }
}