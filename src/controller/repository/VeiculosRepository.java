package controller.repository;

import model.entidades.Veiculo;
import controller.gerenciadores.exception.RegistroJaExistenteException;
import controller.gerenciadores.exception.RegistroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class VeiculosRepository implements Repository<Veiculo>{

    private List<Veiculo> listaVeiculos;

    public VeiculosRepository(){
        this.listaVeiculos = new ArrayList<>();
    }

    public VeiculosRepository(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    @Override
    public Veiculo salvar(Veiculo entidade) {
        if(existe(entidade.getId())) {
            throw new RegistroJaExistenteException("Veiculo", entidade.getId());
        }
        listaVeiculos.add(entidade);
        return entidade;
    }

    @Override
    public void alterar(Veiculo entidade) {
        if (!existe(entidade.getId())) {
            throw new RegistroNaoEncontradoException("Veiculo", entidade.getId());
        }
        deletar(entidade.getId());
        salvar(entidade);
    }

    @Override
    public boolean deletar(String id) {
        if (existe(id)) {
            Veiculo veiculo = buscar(id);
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    @Override
    public Veiculo buscar(String id) {
        for (Veiculo veiculo: listaVeiculos) {
            if (veiculo.getId().equals(id)) {
                return veiculo;
            }
        }
        return null;
    }

    private boolean existe(String id) {
        return buscar(id) != null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(listaVeiculos);
    }
}
