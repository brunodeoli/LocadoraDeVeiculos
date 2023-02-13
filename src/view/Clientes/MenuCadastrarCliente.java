package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import model.entidades.Cliente;
import model.tipos.Contato;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.util.Locale;

public class MenuCadastrarCliente extends Submenu {

    private final GerenciadorDeClientes gerenciadorDeClientes;


    public MenuCadastrarCliente(GerenciadorDeClientes gerenciadorDeCliente) {
        super("Cadastrar " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("a identificação (cpf/cnpj): ");

        if (gerenciadorDeClientes.existeCliente(id)) {
            System.out.println("Já existe um cliente com essa identificação");
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome: ");

        String email = CapturadorDeEntrada.capturarString("um email para contato: ");
        String telefone = CapturadorDeEntrada.capturarString("um telefone para contato: ");
        String endereco = CapturadorDeEntrada.capturarString("o endereço: ");

        //TODO tipo de cliente

        Cliente clienteCadastrado = gerenciadorDeClientes.cadastrarCliente(nome, id, new Contato(email, telefone, endereco));

        System.out.println(GerenciadorDeClientes.DESCRICAO_CLASSE + " adicionado com sucesso");
        System.out.println(clienteCadastrado);
    }
}
