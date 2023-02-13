package model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TipoDeCliente {
    PF,
    PJ;

    public static Optional<TipoDeCliente> getIfPresent(Class<TipoDeCliente> veiculoClass, String str) {
        return Arrays.stream(TipoDeCliente.values())
                .filter(alphabet -> str.equals(alphabet.name()))
                .findFirst();
    }
}
