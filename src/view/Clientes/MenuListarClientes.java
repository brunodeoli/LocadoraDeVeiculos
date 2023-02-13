package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import model.entidades.Cliente;
import view.Submenu;

import java.util.List;

public class MenuListarClientes extends Submenu {

    private final GerenciadorDeClientes gerenciadorDeClientes;


    public MenuListarClientes(GerenciadorDeClientes gerenciadorDeClientes) {
        super("Listar todos " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeClientes;
    }

    @Override
    public void acao() {
        List<Cliente> clientes = gerenciadorDeClientes.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Não existem clientes cadastrados!");
            return;
        }

        System.out.println("Clientes encontrados: ");
        clientes.forEach(System.out::println);

    }
}