package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class GerenciarPedidosController implements Initializable {

    @FXML
    private Button buttonCadastrarPedido;

    @FXML
    private Button buttonListarPedidos;

    @FXML
    private Button buttonVoltar;

    @FXML
    void cadastrarPedido() throws IOException {
        App.setRoot("cadastroPedido");
    }

    @FXML
    void listarPedidos() throws IOException {
        App.setRoot("listarPedidos");
    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("TelaInicialAdministrador");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
