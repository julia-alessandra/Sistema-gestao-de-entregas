package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaEntregadorController {
    @FXML
    private Button buttonPedidos;

    @FXML
    private Button buttonSair;

    @FXML
    void abrirGerenciarPedidos() throws IOException {
        App.setRoot("gerenciarPedidos");
    }

    @FXML
    void sair() throws IOException {
        App.setRoot("telaLogin");
    }
}
