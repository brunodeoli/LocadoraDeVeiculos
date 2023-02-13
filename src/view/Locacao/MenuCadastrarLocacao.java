package view.Locacao;

import controller.gerenciadores.GerenciadorDeLocacao;
import controller.gerenciadores.GerenciadorDeVeiculos;
import model.entidades.Veiculo;
import model.enums.TipoDeVeiculo;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuCadastrarLocacao extends Submenu {

    private final GerenciadorDeLocacao gerenciadorDeLocacao;

    public MenuCadastrarLocacao(GerenciadorDeLocacao gerenciadorDeLocacao) {
        super("Cadastrar nova " + gerenciadorDeLocacao.DESCRICAO_CLASSE);
        this.gerenciadorDeLocacao = gerenciadorDeLocacao;
    }

    @Override
    public void acao() {

    }
}