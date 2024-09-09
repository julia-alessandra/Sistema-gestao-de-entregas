package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.ClienteController;
import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    private ArrayList<Cliente> listaClientes;
    
    private final ClienteController clienteController = new ClienteController();
    
    private int ultimoCliente;

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
        ultimoCliente = 0;
        
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(
                new PropertyValueFactory<>("telefone"));
        colCPF.setCellValueFactory(
                new PropertyValueFactory<>("CPF"));
        colLogradouro.setCellValueFactory(
                new PropertyValueFactory<>("logradouro"));
        colBairro.setCellValueFactory(
                new PropertyValueFactory<>("bairro"));
    }    
    
}
