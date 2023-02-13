package controller.gerenciadores;

import controller.repository.ClientesRepository;
import controller.repository.LocacaoRepository;
import controller.repository.VeiculosRepository;
import model.entidades.Cliente;
import model.entidades.ContratoDeAluguel;
import model.entidades.Veiculo;
import model.enums.StatusDeContrato;
import model.tipos.Agendamento;

import java.util.List;

public class GerenciadorDeLocacao {
    public static final String DESCRICAO_CLASSE = "Locação";
    private final LocacaoRepository locacaoRepository;
    private final ClientesRepository clientesRepository;
    private final VeiculosRepository veiculosRepository;
    private Long ordemDeContrato = 20230000L;

    public GerenciadorDeLocacao(LocacaoRepository locacaoRepository, ClientesRepository clientesRepository, VeiculosRepository veiculosRepository) {
        this.locacaoRepository = locacaoRepository;
        this.clientesRepository = clientesRepository;
        this.veiculosRepository = veiculosRepository;
    }

    public ContratoDeAluguel cadastrarCliente(Cliente cliente, Veiculo veiculoAlugado, Agendamento dataRetirada, Agendamento dataDevolucao) {
        this.ordemDeContrato += 1;
        return locacaoRepository.salvar(new ContratoDeAluguel(String.valueOf(this.ordemDeContrato), cliente, veiculoAlugado, dataRetirada, dataDevolucao));
    }

    public ContratoDeAluguel consultarPorId(String id) {
        return locacaoRepository.buscar(id);
    }

    public boolean isContratoAberto(String id){
        return locacaoRepository.isAberto(id);
    }

    public boolean isContratoEmAndamento(String id){
        return locacaoRepository.isEmAndamento(id);
    }

    public boolean existeContrato(String id){
        return locacaoRepository.buscar(id) != null;
    }

    public boolean existeCliente(String id) {
        return clientesRepository.buscar(id) != null;
    }

    public Cliente selecionarCliente(String id){
        return clientesRepository.buscar(id);
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculosRepository.listarDisponiveis();
    }

    public Veiculo escolherVeiculo(String placa){
        return veiculosRepository.buscar(placa);
    }

    public void alterarContrato(ContratoDeAluguel contrato){
        locacaoRepository.alterar(contrato);
    }

    public List<ContratoDeAluguel> listarTodos() {
        return locacaoRepository.listarTodos();
    }

    public List<ContratoDeAluguel> listarTodosEmAberto() {
        return locacaoRepository.listarTodosEmAberto();
    }

    public List<ContratoDeAluguel> listarTodosFechados() {
        return locacaoRepository.listarTodosFechados();
    }
}
