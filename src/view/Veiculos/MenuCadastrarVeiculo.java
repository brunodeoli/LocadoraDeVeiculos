package view.Veiculos;

import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Veiculo;
import model.enums.TipoDeVeiculo;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuCadastrarVeiculo extends Submenu {

    private final GerenciadorDeVeiculos gerenciadorDeVeiculos;

    public MenuCadastrarVeiculo(GerenciadorDeVeiculos gerenciadorDeVeiculos) {
        super("Cadastrar " + GerenciadorDeVeiculos.DESCRICAO_CLASSE);
        this.gerenciadorDeVeiculos = gerenciadorDeVeiculos;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a identificação (placa)");

        if (gerenciadorDeVeiculos.existeVeiculo(placa)) {
            System.out.println("Já existe um veiculo com essa placa");
            return;
        }


        String marca = CapturadorDeEntrada.capturarString("a marca");
        String modelo = CapturadorDeEntrada.capturarString("o modelo");
        //TODO tratar tipo do veiculo
        String tipo = CapturadorDeEntrada.capturarString("o tipo do veiculo");

        Veiculo veiculoCadastrado = gerenciadorDeVeiculos.cadastrarVeiculo(marca, modelo, placa, TipoDeVeiculo.valueOf(tipo));

        System.out.println(GerenciadorDeVeiculos.DESCRICAO_CLASSE + " adicionado com sucesso");
        System.out.println(veiculoCadastrado);
    }
}