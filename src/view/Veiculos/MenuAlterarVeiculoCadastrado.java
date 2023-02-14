package view.Veiculos;

import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Veiculo;
import model.enums.TipoDeVeiculo;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<TipoDeVeiculo> tipo = Optional.empty();

        while(tipo.isEmpty()){
            tipo = TipoDeVeiculo.getIfPresent(TipoDeVeiculo.class,
                    CapturadorDeEntrada.capturarString("o tipo do veiculo "
                                    + EnumSet.allOf(TipoDeVeiculo.class)
                                    .stream()
                                    .map(e -> e.name())
                                    .collect(Collectors.toList()) + ": ")
                            .toUpperCase());

            if(tipo.isEmpty()){
                System.out.println("Entrada de tipo de veiculo não é válida, tente novamente.");
            }
        }

        gerenciadorDeVeiculos.alterarVeiculo(marca, modelo, placa, tipo.get());

        System.out.println(GerenciadorDeVeiculos.DESCRICAO_CLASSE + " alterado com sucesso");
    }
}
