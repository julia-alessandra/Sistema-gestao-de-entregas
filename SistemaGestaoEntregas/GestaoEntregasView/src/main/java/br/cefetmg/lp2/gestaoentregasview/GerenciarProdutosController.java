package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class GerenciarProdutosController implements Initializable {

    @FXML
    private Button buttonCadastrarProduto;

    @FXML
    private Button buttonListarProdutos;

    @FXML
    private Button buttonVoltar;

    @FXML
    void cadastrarProduto() throws IOException {
        App.setRoot("cadastroProduto");
    }

    @FXML
    void listarProdutos() throws IOException {
        App.setRoot("listarProdutos");
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
