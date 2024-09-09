package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.ProdutoController;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ListarProdutosController {

    @FXML
    private ListView<String> listViewProdutos;

    private ProdutoController produtoController = new ProdutoController();

    @FXML
    private void initialize() {
        listarProdutos();
    }
    
    
    @FXML
    void voltar() throws IOException {
        App.setRoot("TelaInicialAdministrador");
    }

    private void listarProdutos() {
        List<Produto> produtos = produtoController.listar();
        ObservableList<String> produtosTexto = FXCollections.observableArrayList();

        for (Produto funcionario : produtos) {
            String itemTexto = String.format("Nome: %s (  localização: %s )",
                    funcionario.getNome(), 
                    funcionario.getLocalizacao());
            produtosTexto.add(itemTexto);
        }

        listViewProdutos.setItems(produtosTexto);
    }

    @FXML
    public void salvarItemPedido() {
        listarProdutos();
    }
}
