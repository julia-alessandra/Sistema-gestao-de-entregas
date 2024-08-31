package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ListarClientesController implements Initializable {

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonVoltar;

    @FXML
    private TableColumn<Cliente, String> colBairro;

    @FXML
    private TableColumn<Cliente, String> colCPF;

    @FXML
    private TableColumn<Cliente, String> colLogradouro;

    @FXML
    private TableColumn<Cliente, String> colNome;

    @FXML
    private TableColumn<Cliente, String> colTelefone;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    void atualizarDados() {

    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("gerenciarClientes");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
