package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class TelaInicialAdministradorController implements Initializable {

    @FXML
    private Button buttonClientes;

    @FXML
    private Button buttonEmpresa;

    @FXML
    private Button buttonFuncionarios;

    @FXML
    private Button buttonPedidos;

    @FXML
    private Button buttonProdutos;

    @FXML
    private Button buttonSair;

    @FXML
    void abrirGerenciarClientes() throws IOException {
        App.setRoot("gerenciarClientes");
    }

    @FXML
    void abrirGerenciarEmpresa() throws IOException {
        App.setRoot("gerenciarEmpresa");
    }

    @FXML
    void abrirGerenciarFuncionarios() throws IOException {
        App.setRoot("gerenciarFuncionarios");
    }

    @FXML
    void abrirGerenciarPedidos() throws IOException {
        App.setRoot("gerenciarPedidos");
    }

    @FXML
    void abrirGerenciarProdutos() throws IOException {
        App.setRoot("gerenciarProdutos");
    }

    @FXML
    void sair() throws IOException {
        App.setRoot("telaLogin");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
