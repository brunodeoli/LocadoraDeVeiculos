package view.Locacao;

import controller.gerenciadores.GerenciadorDeLocacao;
import model.entidades.ContratoDeAluguel;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuBuscarContrato extends Submenu {

    private final GerenciadorDeLocacao gerenciadorDeLocacao;

    public MenuBuscarContrato(GerenciadorDeLocacao gerenciadorDeLocacao) {
        super("Buscar contrato de " + gerenciadorDeLocacao.DESCRICAO_CLASSE);
        this.gerenciadorDeLocacao = gerenciadorDeLocacao;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("a ordem de contrato: ");

        if (!gerenciadorDeLocacao.existeContrato(id)) {
            System.out.println("Não existe um contrato com essa identificação");
            return;
        }

        ContratoDeAluguel contrato = gerenciadorDeLocacao.consultarPorId(id);

        System.out.println(gerenciadorDeLocacao.DESCRICAO_CLASSE + " encontrado com sucesso");

        System.out.println(contrato);

    }
}
