package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InicioController {

    App app;

    @FXML
    private Button buttonCadastrarEmpresa;
    
    @FXML
    private Button buttonEntrar;

    public void cadastrarNovaEmpresa() throws IOException {
        App.setRoot("FXMLCadastrarEmpresa");
    }
    
    public void entrarNoSistema() throws IOException {
        App.setRoot("FXMLTelaLogin");
    }

}