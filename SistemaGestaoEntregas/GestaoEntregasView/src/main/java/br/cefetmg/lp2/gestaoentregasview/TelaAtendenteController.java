package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaAtendenteController {
    @FXML
    private Button buttonClientes;

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
}
