import controller.gerenciadores.GerenciadorDeClientes;
import controller.gerenciadores.GerenciadorDeLocacao;
import controller.gerenciadores.GerenciadorDeVeiculos;
import controller.repository.ClientesRepository;
import controller.repository.LocacaoRepository;
import controller.repository.VeiculosRepository;
import view.Clientes.MenuClientesFactory;
import view.Locacao.MenuLocacaoFactory;
import view.MenuComSubmenus;
import view.MenuGeralFactory;
import view.Veiculos.MenuDeVeiculosFactory;

public class App {
    public static void main(String[] args) {
        ClientesRepository clientesRepository = new ClientesRepository();
        GerenciadorDeClientes gerenciadorDeClientes = new GerenciadorDeClientes(clientesRepository);

        VeiculosRepository veiculosRepository = new VeiculosRepository();
        GerenciadorDeVeiculos gerenciadorDeVeiculos = new GerenciadorDeVeiculos(veiculosRepository);

        LocacaoRepository locacaoRepository = new LocacaoRepository();
        GerenciadorDeLocacao gerenciadorDeLocacao = new GerenciadorDeLocacao(locacaoRepository, clientesRepository, veiculosRepository);

        MenuClientesFactory menuClientesFactory = new MenuClientesFactory(gerenciadorDeClientes);
        MenuDeVeiculosFactory menuDeVeiculosFactory = new MenuDeVeiculosFactory(gerenciadorDeVeiculos);
        MenuLocacaoFactory menuLocacaoFactory = new MenuLocacaoFactory(gerenciadorDeLocacao);

        MenuComSubmenus menuGeral = new MenuGeralFactory(menuClientesFactory, menuDeVeiculosFactory, menuLocacaoFactory).create();
        menuGeral.agir();
    }
}