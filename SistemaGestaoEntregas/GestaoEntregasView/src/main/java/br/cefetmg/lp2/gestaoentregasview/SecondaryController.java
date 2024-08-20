package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("telaInicial");
    }
}