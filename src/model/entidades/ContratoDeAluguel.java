package model.entidades;

import model.tipos.Agendamento;

import java.math.BigDecimal;
import java.time.Duration;

public class ContratoDeAluguel implements Entidade{

    private static final long serialVersionUID = 1L;

    private final String ordemDeContrato;
    private final Cliente cliente;
    private final Veiculo veiculoAlugado;
    private Agendamento dataRetirada;
    private Agendamento dataDevolucao;
    private Double valorDoContrato;

    public ContratoDeAluguel(String ordemDeContrato, Cliente cliente, Veiculo veiculoAlugado, Agendamento dataRetirada, Agendamento dataDevolucao) {
        this.ordemDeContrato = ordemDeContrato;
        this.cliente = cliente;
        this.veiculoAlugado = veiculoAlugado;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;

        if(dataRetirada != null && dataDevolucao != null){
            //TODO calculo do desconto
            Double dias = Double.valueOf(Duration.between(dataRetirada.getData(),dataDevolucao.getData()).toDays());
            Double desconto = 0.0;

            Double diaria = switch (veiculoAlugado.getTipoDeVeiculo()) {
                case PEQUENO -> 100.0;
                case MEDIO -> 150.0;
                case SUV -> 200.0;
            };

            this.valorDoContrato = (dias *diaria)*(1-desconto);
        }
    }

    @Override
    public String getId() {
        return ordemDeContrato;
    }
}
