package br.cefetmg.lp2.gestaoentregasview;
/*
import br.cefetmg.lp2.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.lp2.gestaoentregascontroller.ItemPedidoController;
import br.cefetmg.lp2.gestaoentregascontroller.PedidoController;
import br.cefetmg.lp2.gestaoentregascontroller.ProdutoController;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import br.cefetmg.lp2.gestaoentregasentidades.ItemPedido;
import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;


public class RelatoriosController {

    @FXML
    private TableView<ItemPedido> tableProdutos;
    @FXML
    private TableColumn<ItemPedido, Integer> colunaIdProduto;
    @FXML
    private TableColumn<ItemPedido, String> colunaNomeProduto;
    @FXML
    private TableColumn<ItemPedido, Double> colunaPrecoProduto;
    @FXML
    private BarChart<String, Number> graficoVendasProdutos;

    @FXML
    private TableView<Funcionario> tableFuncionarios;
    @FXML
    private TableColumn<Funcionario, Integer> colunaIdFuncionario;
    @FXML
    private TableColumn<Funcionario, String> colunaNomeFuncionario;
    @FXML
    private TableColumn<Funcionario, String> colunaCargoFuncionario;
    @FXML
    private TableColumn<Funcionario, String> colunaPedidosAtendidosFuncionario;
    @FXML
    private PieChart graficoDesempenhoFuncionarios;

    @FXML
    private TableView<Pedido> tablePedidos;
    @FXML
    private TableColumn<Pedido, Integer> colunaIdPedido;
    @FXML
    private TableColumn<Pedido, String> colunaClientePedido;
    @FXML
    private TableColumn<Pedido, String> colunaStatusPedido;
    @FXML
    private TableColumn<Pedido, String> colunaValorTotalPedido;
    @FXML
    private AreaChart<String, Number> graficoPedidosMes;

    private ItemPedidoController itemPedidoController = new ItemPedidoController();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private PedidoController pedidoController = new PedidoController();

    @FXML
    public void initialize() {
        carregarProdutos();
        carregarFuncionarios();
        carregarPedidos();
    }

    private void carregarProdutos() {
        List<ItemPedido> itemPedido = itemPedidoController.listar();
        ObservableList<ItemPedido> observableProdutos = FXCollections.observableArrayList(itemPedido);

        colunaIdProduto.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getId()));
        colunaNomeProduto.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getProduto().getNome()));
        colunaPrecoProduto.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getValorUnitario()));
        tableProdutos.setItems(observableProdutos);

        // Preencher o gráfico de vendas de produtos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (ItemPedido produto : itemPedido) {
            series.getData().add(new XYChart.Data<>(produto.getProduto().getNome(), produto.getValorUnitario()));
        }
        graficoVendasProdutos.getData().add(series);
    }

    private void carregarFuncionarios() {
        
        List<Funcionario> funcionarios = funcionarioController.listar();
        ObservableList<Funcionario> observableFuncionarios = FXCollections.observableArrayList(funcionarios);

        colunaIdFuncionario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getId()));
        colunaNomeFuncionario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNome()));
        colunaCargoFuncionario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCpf()));
        tableFuncionarios.setItems(observableFuncionarios);

        // Preencher o gráfico de desempenho dos funcionários
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Funcionario funcionario : funcionarios) {
            pieChartData.add(new PieChart.Data(funcionario.getNome(), funcionario.getEmpresa().getPorcentagemComissaoEntregador()));
        }
        graficoDesempenhoFuncionarios.setData(pieChartData);
    }

    private void carregarPedidos() {
        List<Pedido> pedidos = pedidoController.listar();
        ObservableList<Pedido> observablePedidos = FXCollections.observableArrayList(pedidos);

        colunaIdPedido.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getId()));
        colunaClientePedido.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        colunaStatusPedido.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        tablePedidos.setItems(observablePedidos);
    }
}

*/
