package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class TelaLoginController implements Initializable {
    
    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonVoltar;

    @FXML
    void fazerLogin() {

    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("telaInicial");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
