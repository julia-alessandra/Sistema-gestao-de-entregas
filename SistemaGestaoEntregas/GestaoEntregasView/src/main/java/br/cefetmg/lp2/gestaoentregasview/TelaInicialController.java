package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaInicialController {

    App app;

    @FXML
    private Button buttomEntrarSistema;

    public void cadastrarNovaEmpresa() throws IOException {
        App.setRoot("CadastrarEmpresa");

    }

}
