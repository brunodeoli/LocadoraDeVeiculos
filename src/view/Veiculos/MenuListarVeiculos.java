package view.Veiculos;

import controller.gerenciadores.GerenciadorDeClientes;
import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Cliente;
import model.entidades.Veiculo;
import view.Menu;
import view.Submenu;

import java.util.List;

public class MenuListarVeiculos extends Submenu {


    private final GerenciadorDeVeiculos gerenciadorDeVeiculos;


    public MenuListarVeiculos(GerenciadorDeVeiculos gerenciadorDeVeiculos) {
        super("Listar todos " + GerenciadorDeVeiculos.DESCRICAO_CLASSE);
        this.gerenciadorDeVeiculos = gerenciadorDeVeiculos;
    }

    @Override
    public void acao() {
        List<Veiculo> clientes = gerenciadorDeVeiculos.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Não existem veiculos cadastrados!");
            return;
        }

        System.out.println("Veiculos encontrados: ");
        clientes.forEach(System.out::println);

    }
}
