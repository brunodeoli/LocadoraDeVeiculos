package view.Locacao;

import controller.gerenciadores.GerenciadorDeLocacao;
import model.entidades.ContratoDeAluguel;
import view.CapturadorDeEntrada;
import view.Menu;
import view.Submenu;

public class MenuEfetuarAluguel extends Submenu {

    private final GerenciadorDeLocacao gerenciadorDeLocacao;

    public MenuEfetuarAluguel(GerenciadorDeLocacao gerenciadorDeLocacao) {
        super("Efetuar aluguel de contrato de " + gerenciadorDeLocacao.DESCRICAO_CLASSE);
        this.gerenciadorDeLocacao = gerenciadorDeLocacao;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("a ordem de contrato: ");

        if (!gerenciadorDeLocacao.existeContrato(id)) {
            System.out.println("Não existe um contrato com essa identificação");
            return;
        }

        if(!gerenciadorDeLocacao.isContratoAberto(id)){
            System.out.println("O contrato não se encontra mais aberto");
            return;
        }

        ContratoDeAluguel contrato = gerenciadorDeLocacao.consultarPorId(id);
        gerenciadorDeLocacao.alterarContrato(contrato);

        System.out.println("Status de " + gerenciadorDeLocacao.DESCRICAO_CLASSE + " atualizado para: Em Andamento");

        System.out.println(contrato);
    }
}
