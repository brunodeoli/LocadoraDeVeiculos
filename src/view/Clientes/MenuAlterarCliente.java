package view.Clientes;

import controller.gerenciadores.GerenciadorDeClientes;
import model.enums.TipoDeCliente;
import model.tipos.Contato;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuAlterarCliente extends Submenu {

    private final GerenciadorDeClientes gerenciadorDeClientes;

    public MenuAlterarCliente(GerenciadorDeClientes gerenciadorDeCliente) {
        super("Alterar " + GerenciadorDeClientes.DESCRICAO_CLASSE);
        this.gerenciadorDeClientes = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("o id: ");

        if (!gerenciadorDeClientes.existeCliente(id)) {
            System.out.println("Não existe um cliente com essa identificação");
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome: ");

        Optional<TipoDeCliente> tipo = Optional.empty();

        while(tipo.isEmpty()){
            tipo = TipoDeCliente.getIfPresent(TipoDeCliente.class,
                    CapturadorDeEntrada.capturarString("o tipo do cliente "
                                    + EnumSet.allOf(TipoDeCliente.class)
                                    .stream()
                                    .map(e -> e.name())
                                    .collect(Collectors.toList()) + ": ")
                            .toUpperCase());

            if(tipo.isEmpty()){
                System.out.println("Entrada de tipo de cliente não é válida, tente novamente.");
            }
        }

        String email = CapturadorDeEntrada.capturarString("um email para contato: ");
        String telefone = CapturadorDeEntrada.capturarString("um telefone para contato: ");
        String endereco = CapturadorDeEntrada.capturarString("o endereço: ");

        gerenciadorDeClientes.alterarCliente(nome, id, tipo.get(), new Contato(email, telefone, endereco));

        System.out.println(GerenciadorDeClientes.DESCRICAO_CLASSE + " alterado com sucesso");
    }
}