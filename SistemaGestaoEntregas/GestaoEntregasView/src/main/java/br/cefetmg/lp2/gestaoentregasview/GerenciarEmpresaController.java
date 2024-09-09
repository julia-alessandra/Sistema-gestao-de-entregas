package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class GerenciarEmpresaController implements Initializable {

    @FXML
    private Button buttonEditarEmpresa;

    @FXML
    private Button buttonEmitirRelatorio;

    @FXML
    private Button buttonVoltar;

    @FXML
    void editarEmpresa() throws IOException {
        App.setRoot("editarEmpresa");
    }
    
    @FXML
    void emitirRelatorio() throws IOException {
        App.setRoot("emitirRelatorio");
    }
    
    @FXML
    void voltar() throws IOException {
        App.setRoot("TelaInicialAdministrador");
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
