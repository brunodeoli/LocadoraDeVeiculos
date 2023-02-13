package view.Veiculos;

import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Veiculo;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuBuscarVeiculo extends Submenu {

    private final GerenciadorDeVeiculos gerenciadorDeVeiculos;

    public MenuBuscarVeiculo(GerenciadorDeVeiculos gerenciadorDeVeiculos) {
        super("Buscar " + GerenciadorDeVeiculos.DESCRICAO_CLASSE);
        this.gerenciadorDeVeiculos = gerenciadorDeVeiculos;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a identificação (placa): ");

        if (!gerenciadorDeVeiculos.existeVeiculo(placa)) {
            System.out.println("Não existe um veiculo com essa placa");
            return;
        }

        Veiculo veiculo = gerenciadorDeVeiculos.consultarPorId(placa);

        System.out.println(GerenciadorDeVeiculos.DESCRICAO_CLASSE + " encontrado com sucesso");

        System.out.println(veiculo);
    }
}
