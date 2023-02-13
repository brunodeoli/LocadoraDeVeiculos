package controller.gerenciadores;

import controller.gerenciadores.exception.RegistroJaExistenteException;
import controller.gerenciadores.exception.RegistroNaoEncontradoException;
import controller.repository.ClientesRepository;
import controller.repository.VeiculosRepository;
import model.entidades.Cliente;
import model.entidades.Veiculo;
import model.enums.TipoDeVeiculo;
import model.tipos.Contato;

import java.util.List;

public class GerenciadorDeVeiculos {
    public static final String DESCRICAO_CLASSE = "Veiculo";
    private final VeiculosRepository repository;

    public GerenciadorDeVeiculos(VeiculosRepository repository) {
        this.repository = repository;
    }

    public Veiculo cadastrarVeiculo(String marca, String modelo, String placa, TipoDeVeiculo tipo) {
        return repository.salvar(new Veiculo(marca, modelo, placa, tipo));
    }

    public void alterarVeiculo(String marca, String modelo, String placa, TipoDeVeiculo tipo) {
        repository.alterar(new Veiculo(marca, modelo, placa, tipo));
    }

    public Veiculo consultarPorId(String id) {
        return repository.buscar(id);
    }

    public boolean existeVeiculo(String id) {
        return repository.buscar(id) != null;
    }

    public List<Veiculo> listarTodos() {
        return repository.listarTodos();
    }
}