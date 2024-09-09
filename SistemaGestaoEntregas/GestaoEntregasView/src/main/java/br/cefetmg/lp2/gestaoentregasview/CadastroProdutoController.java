package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.ProdutoController;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class CadastroProdutoController implements Initializable {

    @FXML
    private Button ButtonCadastrarProduto;

    @FXML
    private TextArea TextLocalizacaoProduto;

    @FXML
    private TextField TextNomeProduto;

    ProdutoController controller = new ProdutoController();

    public void cadastrarProduto() {
        String nome = TextNomeProduto.getText();
        String localizacao = TextLocalizacaoProduto.getText();

        Produto produto = new Produto(nome, localizacao);
        
        controller.cadastrar(produto);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}