package controller.repository;

import controller.gerenciadores.exception.RegistroJaExistenteException;
import controller.gerenciadores.exception.RegistroNaoEncontradoException;
import model.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepository implements Repository<Cliente>{

    private List<Cliente> listaClientes;

    public ClientesRepository() {
        this.listaClientes = new ArrayList<>();
    }

    public ClientesRepository(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public Cliente salvar(Cliente entidade) {
        if(existe(entidade.getId())) {
            throw new RegistroJaExistenteException("Cliente", entidade.getId());
        }
        listaClientes.add(entidade);
        return entidade;
    }

    @Override
    public void alterar(Cliente entidade) {
        if (!existe(entidade.getId())) {
            throw new RegistroNaoEncontradoException("Cliente", entidade.getId());
        }
        deletar(entidade.getId());
        salvar(entidade);
    }

    @Override
    public boolean deletar(String id) {
        if (existe(id)) {
            Cliente cliente = buscar(id);
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    @Override
    public Cliente buscar(String id) {
        for (Cliente cliente: listaClientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    private boolean existe(String id) {
        return buscar(id) != null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(listaClientes);
    }
}
