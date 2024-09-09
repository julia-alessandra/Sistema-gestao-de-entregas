package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.lp2.gestaoentregascontroller.PedidoController;
import br.cefetmg.lp2.gestaoentregascontroller.ProdutoController;
import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarPedidosController implements Initializable {

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonVoltar;

    @FXML
    private TableColumn<Pedido, String> colCPFCliente;

    @FXML
    private TableColumn<Pedido, String> colEndereco;

    @FXML
    private TableColumn<Pedido, String> colEntregador;

    @FXML
    private TableColumn<Pedido, String> colFormaPagamento;

    @FXML
    private TableColumn<Pedido, String> colObservacoes;

    @FXML
    private TableColumn<Pedido, String> colProdutos;

    @FXML
    private TableColumn<Pedido, String> colQuantidade;

    @FXML
    private TableColumn<String, String> colStatus;

    @FXML
    private TableColumn<Pedido, String> colValorTotal;

    @FXML
    private TableView<Pedido> tabelaPedidos;
    
    private ArrayList<Pedido> listaPedidos;
    
    private final PedidoController pedidoController = new PedidoController();
    
    private final ArrayList lista = new ArrayList<>();
    
    private final ProdutoController produtoController = new ProdutoController();
    
    private final FuncionarioController funcionarioController = new FuncionarioController();
    
    private int ultimoPedido;
    
    @FXML
    void atualizarDados() {
        listaPedidos = pedidoController.atualizaDadosPedido(ultimoPedido, null);
        tabelaPedidos.setItems(FXCollections.observableArrayList(listaPedidos));
    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("gerenciarPedidos");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ultimoPedido = 0;
        
        colProdutos.setCellValueFactory(
                new PropertyValueFactory<>("nomeCliente"));
        colQuantidade.setCellValueFactory(
                new PropertyValueFactory<>("endereco"));
        colValorTotal.setCellValueFactory(
                new PropertyValueFactory<>("nomeEntregador"));
        colFormaPagamento.setCellValueFactory(
                new PropertyValueFactory<>("marca"));
        colCPFCliente.setCellValueFactory(
                new PropertyValueFactory<>("quantidade"));
        colEndereco.setCellValueFactory(
                new PropertyValueFactory<>("valorTotal"));
        colObservacoes.setCellValueFactory(
                new PropertyValueFactory<>("valorUnitario"));
        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status"));
        
        atualizarDados();
     }    
    
}
