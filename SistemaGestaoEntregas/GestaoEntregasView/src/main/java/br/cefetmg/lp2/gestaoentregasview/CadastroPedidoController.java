package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.*;
import br.cefetmg.lp2.gestaoentregasentidades.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastroPedidoController {

    @FXML
    private Button BotaoCadastrarPedido;

    @FXML
    private ComboBox<String> ComboBoxCliente;

    @FXML
    private ComboBox<String> ComboBoxStatus;

    @FXML
    private Label LabelValorTotal;

    @FXML
    private Button BotaoCadastrarItemPedido;

    @FXML
    private TableColumn<ItemPedido, String> ColunaProdutosPedidos;

    @FXML
    private TableColumn<ItemPedido, Double> ColunaValorUnitarioPedido;

    @FXML
    private ComboBox<String> ComboBoxProdutosPedido;

    @FXML
    private TableView<ItemPedido> TabelaProdutosPedido;

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
        /*carregaItensPedidos();*/
        carregaClientes();
        ComboBoxStatus.getItems().addAll("Em Preparação", "Saiu para entrega", "Entregue");
    }

    public void salvarItemPedido() {

        Produto produto = produtoController.pesquisarNome(ComboBoxProdutosPedido.getValue());
        Double valorUnitario = Double.valueOf(TextValorProdutolPedido.getText());
        Double quantidadeProduto = Double.valueOf(TextQntProdutolPedido.getText());

        ItemPedido itemPedido = new ItemPedido(valorUnitario, quantidadeProduto, pedido, produto);

        itemController.cadastrar(itemPedido);
    }

    void carregaProdutos() {
        List<Produto> lista = new ArrayList<>();
        lista = produtoController.listar();
        for (Produto produto : lista) {
            ComboBoxProdutosPedido.getItems().add(produto.getNome());
        }
    }

    void carregaClientes() {
        List<Cliente> lista = new ArrayList<>();
        lista = clienteController.listar();
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
    }

    Double calculaValorTotal() {
        List<ItemPedido> listaItens = itemController.listar();
        for (ItemPedido itemPedido : listaItens) {
            valorTotal += itemPedido.getValorUnitario();
        }
        return valorTotal;

    }

/*
 * void carregaItensPedidos() { List<ItemPedido> listaItens =
 * itemController.listar(); ObservableList<ItemPedido> observableListaItens =
 * FXCollections.observableArrayList(listaItens);
 *
 * ColunaProdutosPedidos.setCellValueFactory(cellData -> new
 * SimpleStringProperty(cellData.getValue().getProduto().getNome());
 * ColunaValorUnitarioPedido.setCellValueFactory(cellData -> new
 * SimpleObjectProperty<>(cellData.getValue().getValorUnitario()));
 *
 * TabelaProdutosPedido.setItems(observableListaItens);}
 */
}
