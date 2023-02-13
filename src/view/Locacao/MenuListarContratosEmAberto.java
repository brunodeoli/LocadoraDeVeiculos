package view.Locacao;

import controller.gerenciadores.GerenciadorDeLocacao;
import model.entidades.ContratoDeAluguel;
import view.Submenu;

import java.util.List;

public class MenuListarContratosEmAberto extends Submenu {

    private final GerenciadorDeLocacao gerenciadorDeLocacao;

    public MenuListarContratosEmAberto(GerenciadorDeLocacao gerenciadorDeLocacao) {
        super("Contratos em aberto de " + gerenciadorDeLocacao.DESCRICAO_CLASSE);
        this.gerenciadorDeLocacao = gerenciadorDeLocacao;
    }

    @Override
    public void acao() {
        List<ContratoDeAluguel> contratos = gerenciadorDeLocacao.listarTodosEmAberto();

        if(contratos.isEmpty()){
            System.out.println("Não existem contratos em aberto!");
            return;
        }

        System.out.println("Contratos em aberto: ");
        contratos.forEach(System.out::println);

    }
}
