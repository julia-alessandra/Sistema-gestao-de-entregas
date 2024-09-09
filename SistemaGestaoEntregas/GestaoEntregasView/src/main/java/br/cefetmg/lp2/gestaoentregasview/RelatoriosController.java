package br.cefetmg.lp2.gestaoentregasview;

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
import javafx.scene.control.cell.PropertyValueFactory;


public class RelatoriosController {

    @FXML
    private TableView<Pedido> tablePedidos;

    @FXML
    private TableColumn<Pedido, String> colunaCliente;

    @FXML
    private TableColumn<Pedido, String> colunaStatus;

    @FXML
    private TableColumn<Pedido, String> colunaData;

    @FXML
    private TableColumn<Pedido, String> colunaValorTotal;

    private PedidoController pedidoController = new PedidoController();

    @FXML
    private void initialize() {
        configurarColunas();
        atualizarRelatorio();
    }

    private void configurarColunas() {
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataFormatada"));
        colunaValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorFormatado"));
    }

    @FXML
    private void atualizarRelatorio() {
        List<Pedido> listaPedidos = pedidoController.listar();
        ObservableList<Pedido> observablePedidos = FXCollections.observableArrayList(listaPedidos);
        tablePedidos.setItems(observablePedidos);
    }
}


