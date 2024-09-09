package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.ProdutoController;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    private final ProdutoController produtoController = new ProdutoController();

    private final ArrayList<TextField> listTextFields = new ArrayList<>();

    private final Alert alert = new Alert(Alert.AlertType.NONE);

    private ArrayList<Produto> listaProdutos;
    
    private int ultimoProduto;

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
        ultimoProduto = 0;
        
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colValorUnitario.setCellValueFactory(
                new PropertyValueFactory<>("valorUnitario"));
        colDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
    }    
    
}
