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
        //verificar cadastro
        String id = CapturadorDeEntrada.capturarString("a identificação (cpf/cnpj): ");

        if (!gerenciadorDeLocacao.existeCliente(id)) {
            System.out.println("Não existe um cliente com essa identificação, necessário realizar cadastro");
            return;
        }

        //listar veiculos disponiveis
        gerenciadorDeLocacao.listarVeiculosDisponiveis().forEach(System.out::println);

        //verificar veiculo
        Veiculo veiculoEscolhido = null;

        while(veiculoEscolhido == null){
            String veiculo = CapturadorDeEntrada.capturarString("o veiculo para alugar (placa): ");
            veiculoEscolhido = gerenciadorDeLocacao.escolherVeiculo(veiculo);
        }

        //informar data retirada
        String dataRetirada = CapturadorDeEntrada.capturarString("a data de retirada do veiculo (dd/MM/yyyy HH:mm)");

        //informar local de retirada

        //informar data devolução
        String dataDevolucao = CapturadorDeEntrada.capturarString("a data de retirada do veiculo (dd/MM/yyyy HH:mm)");

        //verificar se data devolução é dps da de retirada
        //informar local de retirada
        //criar
        //imprimir sucesso
        //imprimir contrato


    }
}