package model.entidades;

import model.enums.StatusDeContrato;
import model.enums.TipoDeCliente;
import model.tipos.Agendamento;

import java.time.Duration;

public class ContratoDeAluguel implements Entidade{

    private static final long serialVersionUID = 1L;

    private final String ordemDeContrato;
    private final Cliente cliente;
    private final Veiculo veiculoAlugado;
    private Agendamento dataRetirada;
    private Agendamento dataDevolucao;
    private Double valorDoContrato;
    private StatusDeContrato statusDeContrato;

    public ContratoDeAluguel(String ordemDeContrato, Cliente cliente, Veiculo veiculoAlugado, Agendamento dataRetirada, Agendamento dataDevolucao) {
        this.ordemDeContrato = ordemDeContrato;
        this.cliente = cliente;
        this.veiculoAlugado = veiculoAlugado;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.statusDeContrato = StatusDeContrato.ABERTO;


        if(dataRetirada != null && dataDevolucao != null){
            Double diferencaDeDias = Double.valueOf(Duration.between(dataRetirada.getData(),dataDevolucao.getData()).toDays())+1;
            Double desconto = 0.0;

            if(cliente.getTipoDeCliente().equals(TipoDeCliente.PF)
                && diferencaDeDias > 5){
                desconto = 0.05;
            }

            if(cliente.getTipoDeCliente().equals(TipoDeCliente.PJ)
                && diferencaDeDias > 3){
                desconto = 0.10;
            }

            Double diaria = switch (veiculoAlugado.getTipoDeVeiculo()) {
                case PEQUENO -> 100.0;
                case MEDIO -> 150.0;
                case SUV -> 200.0;
            };

            this.valorDoContrato = (diferencaDeDias*diaria)*(1-desconto);
        }
    }

    public Veiculo getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public StatusDeContrato getStatusDeContrato() {
        return statusDeContrato;
    }

    public void setStatusDeContrato(StatusDeContrato statusDeContrato) {
        this.statusDeContrato = statusDeContrato;
    }

    @Override
    public String getId() {
        return ordemDeContrato;
    }

    @Override
    public String toString() {
        return "Contrato " + ordemDeContrato + ": \n" +
                cliente + "\n" +
                veiculoAlugado + "\n" +
                "Data de retirada: " + dataRetirada + "\n" +
                "Data de devolução: " + dataDevolucao + "\n" +
                "Valor do contrato: " + valorDoContrato + "\n" +
                "Status do contrato: " + statusDeContrato;
    }
}
