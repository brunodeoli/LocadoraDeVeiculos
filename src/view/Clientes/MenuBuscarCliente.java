package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import model.entidades.Cliente;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuBuscarCliente extends Submenu {
    private final GerenciadorDeClientes gerenciadorDeClientes;

    public MenuBuscarCliente(GerenciadorDeClientes gerenciadorDeClientes) {
        super("Buscar " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeClientes;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("o id: ");

        if (!gerenciadorDeClientes.existeCliente(id)) {
            System.out.println("Não existe um cliente com essa identificação");
            return;
        }

        Cliente cliente = gerenciadorDeClientes.consultarPorId(id);

        System.out.println(GerenciadorDeClientes.DESCRICAO_CLASSE + " encontrado com sucesso");

        System.out.println(cliente);
    }
}
