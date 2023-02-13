package view.Locacao;

import controller.gerenciadores.GerenciadorDeLocacao;
import model.entidades.ContratoDeAluguel;
import view.CapturadorDeEntrada;
import view.Menu;
import view.Submenu;

public class MenuEfetuarDevolucao extends Submenu {

    private final GerenciadorDeLocacao gerenciadorDeLocacao;

    public MenuEfetuarDevolucao(GerenciadorDeLocacao gerenciadorDeLocacao) {
        super("Efetuar devolucao de contrato de " + gerenciadorDeLocacao.DESCRICAO_CLASSE);
        this.gerenciadorDeLocacao = gerenciadorDeLocacao;
    }

    @Override
    public void acao() {
        String id = CapturadorDeEntrada.capturarString("a ordem de contrato: ");

        if (!gerenciadorDeLocacao.existeContrato(id)) {
            System.out.println("Não existe um contrato com essa identificação");
            return;
        }

        if(gerenciadorDeLocacao.isContratoEmAndamento(id)){
            System.out.println("O contrato não se encontra em andamento");
            return;
        }

        ContratoDeAluguel contrato = gerenciadorDeLocacao.consultarPorId(id);
        gerenciadorDeLocacao.alterarContrato(contrato);

        System.out.println("Status de " + gerenciadorDeLocacao.DESCRICAO_CLASSE + " atualizado para: Concluído");

        System.out.println(contrato);
    }
}
