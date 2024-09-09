package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.*;
import br.cefetmg.lp2.gestaoentregasentidades.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DoubleStringConverter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastroPedidoController {

    @FXML
    private Button BotaoCadastrarPedido;

    @FXML
    private ComboBox<String> ComboBoxCliente;

    @FXML
    private ComboBox<String> ComboBoxStatus;

    @FXML
    private ComboBox<String> ComboBoxAtendente;

    @FXML
    private Label LabelValorTotal;

    @FXML
    private Button BotaoCadastrarItemPedido;

    @FXML
    private ComboBox<String> ComboBoxProdutosPedido;

    @FXML
    private ListView<String> TabelaProdutosPedido;

    @FXML
    private TextField TextValorProdutolPedido;

    @FXML
    private TextField TextQntProdutolPedido;

    Double valorTotal = 0.0;

    PedidoController pedidoController = new PedidoController();
    ClienteController clienteController = new ClienteController();
    ProdutoController produtoController = new ProdutoController();
    ItemPedidoController itemController = new ItemPedidoController();

    Pedido pedido = new Pedido();

    @FXML
    private void initialize() {
        carregaProdutos();
        carregaClientes();
        ComboBoxStatus.getItems().addAll("Em Preparação", "Saiu para entrega", "Entregue");
    }

    public void salvarItemPedido() {
        Produto produto = produtoController.pesquisarNome(ComboBoxProdutosPedido.getValue());
        Double valorUnitario = Double.valueOf(TextValorProdutolPedido.getText());
        Double quantidadeProduto = Double.valueOf(TextQntProdutolPedido.getText());

        ItemPedido itemPedido = new ItemPedido(valorUnitario, quantidadeProduto, pedido, produto);

        itemController.cadastrar(itemPedido);

        adicionarItemALista(produto, valorUnitario, quantidadeProduto);
        valorTotal += valorUnitario * quantidadeProduto;
        LabelValorTotal.setText(String.format("R$ %.2f", valorTotal));

        TextValorProdutolPedido.clear();
        TextQntProdutolPedido.clear();
    }

    void carregaProdutos() {
        List<Produto> lista = produtoController.listar();
        for (Produto produto : lista) {
            ComboBoxProdutosPedido.getItems().add(produto.getNome());
        }
    }

    void carregaClientes() {
        List<Cliente> lista = clienteController.listar();
        for (Cliente cliente : lista) {
            ComboBoxCliente.getItems().add(cliente.getNome());
        }
    }

    public void salvarPedido() {
        List<ItemPedido> listaItens = itemController.listar();
        Date dataHoraAtual = new Date();
        String status = ComboBoxStatus.getValue();
        Double valor = calculaValorTotal();
        Cliente cliente = clienteController.pesquisarNome(ComboBoxCliente.getValue());

        Pedido pedido = new Pedido((java.sql.Date) dataHoraAtual, status, valor, cliente, listaItens);

        pedidoController.cadastrar(pedido);

        TabelaProdutosPedido.getItems().clear();
        LabelValorTotal.setText("R$ 0.00");

        ComboBoxProdutosPedido.getSelectionModel().clearSelection();
        ComboBoxCliente.getSelectionModel().clearSelection();
        ComboBoxStatus.getSelectionModel().clearSelection();
    }

    Double calculaValorTotal() {
        Double total = 0.0;
        List<String> items = TabelaProdutosPedido.getItems();
        for (String item : items) {
            String[] parts = item.split(" - ");
            String[] valueQuantity = parts[1].split(" x ");
            Double valorUnitario = Double.valueOf(valueQuantity[0].replace("R$", "").trim());
            Double quantidade = Double.valueOf(valueQuantity[1].trim());
            total += valorUnitario * quantidade;
        }
        return total;
    }

    private void adicionarItemALista(Produto produto, Double valorUnitario, Double quantidade) {
        String itemTexto = String.format("%s - R$ %.2f x %.0f", produto.getNome(), valorUnitario, quantidade);
        TabelaProdutosPedido.getItems().add(itemTexto);
    }
}

