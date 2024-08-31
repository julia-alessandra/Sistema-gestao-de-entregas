package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ListarProdutosController implements Initializable {

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonVoltar;

    @FXML
    private TableColumn<Produto, String> colDescricao;

    @FXML
    private TableColumn<Produto, String> colNome;

    @FXML
    private TableColumn<Produto, String> colValorUnitario;

    @FXML
    private TableView<Produto> tabelaProdutos;

    @FXML
    void atualizarDados() {

    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("gerenciarProdutos");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
