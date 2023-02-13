package view;

import java.util.Scanner;

public class CapturadorDeEntrada {
    private static final Scanner scanner = new Scanner(System.in);

    public static String capturarString(String informacao){
        System.out.printf("Informar %s ", informacao);
        String entrada = scanner.nextLine();
        return entrada;
    }
}
