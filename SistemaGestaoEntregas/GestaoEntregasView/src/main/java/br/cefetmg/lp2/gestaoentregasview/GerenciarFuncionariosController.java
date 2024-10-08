package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class GerenciarFuncionariosController implements Initializable {

    @FXML
    private Button buttonCadastrarFuncionario;

    @FXML
    private Button buttonListarFuncionarios;

    @FXML
    private Button buttonVoltar;

    @FXML
    void cadastrarFuncionario() throws IOException {
        App.setRoot("cadastroFuncionario");
    }

    @FXML
    void listarFuncionarios() throws IOException {
        App.setRoot("listarFuncionarios");
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
