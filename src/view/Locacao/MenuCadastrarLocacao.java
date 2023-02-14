package view.Locacao;

import controller.gerenciadores.GerenciadorDeClientes;
import controller.gerenciadores.GerenciadorDeLocacao;
import model.entidades.ContratoDeAluguel;
import model.entidades.Veiculo;
import model.enums.StatusDeVeiculo;
import model.tipos.Agendamento;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.time.LocalDateTime;

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

            if(veiculoEscolhido==null){
                System.out.println("Veiculo não existe ou indisponível.");
            }
        }

        //informar data retirada
        String data = CapturadorDeEntrada.capturarString("a data e hora de retirada do veiculo (dd/MM/yyyy HH:mm): ");
        LocalDateTime dataRetirata = LocalDateTime.parse(data, Agendamento.getFmt());
        //informar local de retirada
        String localRetirada = CapturadorDeEntrada.capturarString("o local de retirada: ");

        //informar data devolução e verifica se data devolução é dps da de retirada
        LocalDateTime dataDevolucao;

        do{
            data = CapturadorDeEntrada.capturarString("a data e hora de devolução do veiculo (dd/MM/yyyy HH:mm)");
            dataDevolucao = LocalDateTime.parse(data, Agendamento.getFmt());

            if(dataRetirata.isAfter(dataDevolucao)){
                System.out.println("A data de devolucação informada é anterior a data de retirada.");
            }
        } while (dataRetirata.isAfter(dataDevolucao));

        //informar local de retirada
        String localDevolucao = CapturadorDeEntrada.capturarString("o local de devolucao: ");

        //cadastra contrato de aluguel
        ContratoDeAluguel contratoCadastrado = gerenciadorDeLocacao.cadastrarContrato(
                gerenciadorDeLocacao.selecionarCliente(id),
                veiculoEscolhido,
                new Agendamento(dataRetirata, localRetirada),
                new Agendamento(dataDevolucao, localDevolucao)
        );

        //imprimir sucesso
        System.out.println(GerenciadorDeLocacao.DESCRICAO_CLASSE + " cadastrada com sucesso");
        //imprimir contrato
        System.out.println(contratoCadastrado);
    }
}