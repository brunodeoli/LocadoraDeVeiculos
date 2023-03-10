package controller.gerenciadores;

import controller.repository.ClientesRepository;
import model.entidades.Cliente;
import model.enums.TipoDeCliente;
import model.tipos.Contato;

import java.util.List;

public class GerenciadorDeClientes {

    public static final String DESCRICAO_CLASSE = "Cliente";
    private final ClientesRepository repository;

    public GerenciadorDeClientes(ClientesRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrarCliente(String nome, String id, TipoDeCliente tipoDeCliente, Contato contato) {
        return repository.salvar(new Cliente(nome, id, tipoDeCliente, contato));
    }

    public void alterarCliente(String nome, String id, TipoDeCliente tipoDeCliente, Contato contato) {
        repository.alterar(new Cliente(nome, id, tipoDeCliente, contato));
    }

    public Cliente consultarPorId(String id) {
        return repository.buscar(id);
    }

    public boolean existeCliente(String id) {
        return repository.buscar(id) != null;
    }

    public List<Cliente> listarTodos() {
        return repository.listarTodos();
    }
}