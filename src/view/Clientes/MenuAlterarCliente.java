package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import model.entidades.Cliente;
import model.tipos.Contato;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuAlterarCliente extends Submenu {

    private final GerenciadorDeClientes gerenciadorDeClientes;

    public MenuAlterarCliente(GerenciadorDeClientes gerenciadorDeCliente) {
        super("Alterar " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("o id");

        if (!gerenciadorDeClientes.existeCliente(id)) {
            System.out.println("Não existe um cliente com essa identificação");
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome");

        String email = CapturadorDeEntrada.capturarString("um email para contato");
        String telefone = CapturadorDeEntrada.capturarString("um telefone para contato");
        String endereco = CapturadorDeEntrada.capturarString("o endereço");

        gerenciadorDeClientes.alterarCliente(nome, id, new Contato(email, telefone, endereco));

        System.out.println(GerenciadorDeClientes.DESCRICAO_CLASSE + " alterado com sucesso");
    }
}