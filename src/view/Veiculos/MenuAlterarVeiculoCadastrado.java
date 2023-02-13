package view.Veiculos;

import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Veiculo;
import model.enums.TipoDeVeiculo;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuAlterarVeiculoCadastrado extends Submenu {

    private final GerenciadorDeVeiculos gerenciadorDeVeiculos;

    public MenuAlterarVeiculoCadastrado(GerenciadorDeVeiculos gerenciadorDeVeiculos) {
        super("Alterar " + GerenciadorDeVeiculos.DESCRICAO_CLASSE);
        this.gerenciadorDeVeiculos = gerenciadorDeVeiculos;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a identificação (placa): ");

        if (!gerenciadorDeVeiculos.existeVeiculo(placa)) {
            System.out.println("Não existe um veiculo com essa placa");
            return;
        }

        String marca = CapturadorDeEntrada.capturarString("a marca: ");
        String modelo = CapturadorDeEntrada.capturarString("o modelo: ");
        //TODO tratar tipo do veiculo
        String tipo = CapturadorDeEntrada.capturarString("o tipo do veiculo: ");

        gerenciadorDeVeiculos.alterarVeiculo(marca, modelo, placa, TipoDeVeiculo.valueOf(tipo));

        System.out.println(GerenciadorDeVeiculos.DESCRICAO_CLASSE + " alterado com sucesso");
    }
}
