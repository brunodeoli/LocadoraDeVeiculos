package model.entidades;

import model.enums.StatusDeVeiculo;
import model.enums.TipoDeVeiculo;

public class Veiculo implements Entidade {

    private static final long serialVersionUID = 1L;

    private String marca;
    private String modelo;
    private final String placa;
    private TipoDeVeiculo tipoDeVeiculo;
    private StatusDeVeiculo statusDeVeiculo;

    public Veiculo(String marca, String modelo, String placa, TipoDeVeiculo tipoDeVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa.toUpperCase();
        this.tipoDeVeiculo = tipoDeVeiculo;
        this.statusDeVeiculo = StatusDeVeiculo.DISPONIVEL;
    }

    public TipoDeVeiculo getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    public StatusDeVeiculo getStatusDeVeiculo(){
        return statusDeVeiculo;
    }

    public void setStatusDeVeiculo(StatusDeVeiculo statusDeVeiculo) {
        this.statusDeVeiculo = statusDeVeiculo;
    }

    @Override
    public String getId() {
        return placa;
    }

    @Override
    public String toString() {
        return "Veiculo: " +
                marca + ", " +
                modelo + ", " +
                placa + ", " +
                tipoDeVeiculo + ", " +
                statusDeVeiculo;
    }
}
