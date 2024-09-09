package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.PedidoController;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaEntregadorController implements Initializable {

    @FXML
    private Button buttonSair;

    @FXML
    private TableColumn<Pedido, String> colCliente;

    @FXML
    private TableColumn<Pedido, String> colEndereco;

    @FXML
    private TableColumn<Pedido, String> colPrazo;

    @FXML
    private TableColumn<Pedido, String> colStatus;

    @FXML
    private TableColumn<Pedido, String> colTelefone;

    @FXML
    private TableView<Pedido> tabelaEntregas;
    
    private ArrayList<Pedido> listaPedidos;
    
    private int ultimoPedido;
    
    private final PedidoController pedidoController = new PedidoController();
    
    private Funcionario entregador;

    @FXML
    void sair(ActionEvent event) throws IOException {
        App.setRoot("telaLogin");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ultimoPedido = 0;
        
        colCliente.setCellValueFactory(
                new PropertyValueFactory<>("nomeCliente"));
        colEndereco.setCellValueFactory(
                new PropertyValueFactory<>("endereco"));
        colTelefone.setCellValueFactory(
                new PropertyValueFactory<>("telefoneCliente"));
        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status"));
        colPrazo.setCellValueFactory(
                new PropertyValueFactory<>("prazo"));
    }

}
