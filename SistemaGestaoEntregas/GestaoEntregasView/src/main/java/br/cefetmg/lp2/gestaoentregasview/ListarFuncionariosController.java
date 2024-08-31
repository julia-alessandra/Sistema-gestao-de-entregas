package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ListarFuncionariosController implements Initializable {

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonVoltar;

    @FXML
    private TableColumn<Funcionario, String> colCargo;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario, String> colTelefone;

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;

    @FXML
    void atualizarDados() {

    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("gerenciarFuncionarios");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
