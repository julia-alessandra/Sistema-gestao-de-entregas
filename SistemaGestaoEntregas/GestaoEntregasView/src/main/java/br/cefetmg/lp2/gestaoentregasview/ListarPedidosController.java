package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    @FXML
    void atualizarDados() {
        
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
        // TODO
    }    
    
}
