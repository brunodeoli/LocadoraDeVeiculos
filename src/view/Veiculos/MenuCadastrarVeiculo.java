package view.Veiculos;

import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Veiculo;
import model.enums.TipoDeVeiculo;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuCadastrarVeiculo extends Submenu {

    private final GerenciadorDeVeiculos gerenciadorDeVeiculos;

    public MenuCadastrarVeiculo(GerenciadorDeVeiculos gerenciadorDeVeiculos) {
        super("Cadastrar " + GerenciadorDeVeiculos.DESCRICAO_CLASSE);
        this.gerenciadorDeVeiculos = gerenciadorDeVeiculos;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a identificação (placa): ");

        if (gerenciadorDeVeiculos.existeVeiculo(placa)) {
            System.out.println("Já existe um veiculo com essa placa");
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


        Veiculo veiculoCadastrado = gerenciadorDeVeiculos.cadastrarVeiculo(marca, modelo, placa, tipo.get());

        System.out.println(GerenciadorDeVeiculos.DESCRICAO_CLASSE + " adicionado com sucesso");
        System.out.println(veiculoCadastrado);
    }
}