package controller.repository;

import controller.gerenciadores.exception.RegistroJaExistenteException;
import model.entidades.ContratoDeAluguel;
import model.enums.StatusDeContrato;
import model.enums.StatusDeVeiculo;

import java.util.ArrayList;
import java.util.List;

public class LocacaoRepository implements Repository<ContratoDeAluguel> {

    private List<ContratoDeAluguel> listaDeContratos;

    public LocacaoRepository(){
        this.listaDeContratos = new ArrayList<>();
    }

    @Override
    public ContratoDeAluguel salvar(ContratoDeAluguel entidade) {
        if(existe(entidade.getId())) {
            throw new RegistroJaExistenteException("Contrato de Aluguel", entidade.getId());
        }
        listaDeContratos.add(entidade);
        return entidade;
    }

    @Override
    public void alterar(ContratoDeAluguel entidade) {
        if(isConcluido(entidade.getId()))
            return;

        if(isEmAndamento(entidade.getId())){
            entidade.setStatusDeContrato(StatusDeContrato.CONCLUIDO);
            entidade.getVeiculoAlugado().setStatusDeVeiculo(StatusDeVeiculo.DISPONIVEL);
        }

        if(isAberto(entidade.getId())){
            entidade.setStatusDeContrato(StatusDeContrato.ANDAMENTO);
            entidade.getVeiculoAlugado().setStatusDeVeiculo(StatusDeVeiculo.ALUGADO);
        }
    }

    public boolean isAberto(String id){
        return buscar(id).getStatusDeContrato().equals(StatusDeContrato.ABERTO);
    }

    public boolean isEmAndamento(String id){
        return buscar(id).getStatusDeContrato().equals(StatusDeContrato.ANDAMENTO);
    }

    public boolean isConcluido(String id){
        return buscar(id).getStatusDeContrato().equals(StatusDeContrato.CONCLUIDO);
    }

    private boolean existe(String id) {
        return buscar(id) != null;
    }

    @Override
    public boolean deletar(String id) {
        return false;
    }

    @Override
    public ContratoDeAluguel buscar(String id) {
        for (ContratoDeAluguel contrato: listaDeContratos) {
            if (contrato.getId().equals(id)) {
                return contrato;
            }
        }
        return null;
    }

    @Override
    public List<ContratoDeAluguel> listarTodos() {
        return new ArrayList<>(listaDeContratos);
    }

    public List<ContratoDeAluguel> listarTodosEmAberto() {
        List<ContratoDeAluguel> contratosEmAberto = new ArrayList<>();
        for(ContratoDeAluguel contrato : listaDeContratos){
            if(contrato.getStatusDeContrato().equals(StatusDeContrato.ABERTO)){
                contratosEmAberto.add(contrato);
            }
        }
        return contratosEmAberto;
    }

    public List<ContratoDeAluguel> listarTodosFechados() {
        List<ContratoDeAluguel> contratosFechados = new ArrayList<>();
        for(ContratoDeAluguel contrato : listaDeContratos){
            if(contrato.getStatusDeContrato().equals(StatusDeContrato.CONCLUIDO)){
                contratosFechados.add(contrato);
            }
        }
        return contratosFechados;
    }


}
