package model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TipoDeVeiculo {

    PEQUENO,
    MEDIO,
    SUV;

    public static Optional<TipoDeVeiculo> getIfPresent(Class<TipoDeVeiculo> veiculoClass, String str) {
        return Arrays.stream(TipoDeVeiculo.values())
                .filter(alphabet -> str.equals(alphabet.name()))
                .findFirst();
    }

}
