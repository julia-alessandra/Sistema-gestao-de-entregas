package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    private ArrayList<Funcionario> listaFuncionarios;
    
    private final FuncionarioController funcionarioController = new FuncionarioController();
    
    private int ultimoFuncionario;

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
        ultimoFuncionario = 0;
        
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(
                new PropertyValueFactory<>("telefone"));
        colCargo.setCellValueFactory(
                new PropertyValueFactory<>("cargo"));
    }    
    
}
