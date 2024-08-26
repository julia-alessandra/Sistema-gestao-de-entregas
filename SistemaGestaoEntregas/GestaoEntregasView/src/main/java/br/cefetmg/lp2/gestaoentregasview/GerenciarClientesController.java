package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class GerenciarClientesController implements Initializable {

    @FXML
    private Button buttonCadastrarCliente;

    @FXML
    private Button buttonListarClientes;

    @FXML
    private Button buttonVoltar;

    @FXML
    void cadastrarCliente() throws IOException {
        App.setRoot("cadastroCliente");
    }

    @FXML
    void listarClientes() {

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
