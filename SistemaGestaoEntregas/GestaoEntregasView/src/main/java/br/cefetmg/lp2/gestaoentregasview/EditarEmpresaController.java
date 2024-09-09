package br.cefetmg.lp2.gestaoentregasview;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class EditarEmpresaController {
    
    @FXML
    private Button buttonVoltar;
    
    @FXML
    private TableColumn<?, ?> ColunaCPFFuncionarioEmpresa;

    @FXML
    private TableColumn<?, ?> ColunaFuncaoFuncionarioEmpresa;

    @FXML
    private TableColumn<?, ?> ColunaNomeFuncionarioEmpresa;

    @FXML
    private TableView<?> TabelaFuncionariosEmpresa;

    @FXML
    private Text TextCNPJEmpresa;

    @FXML
    private Text TextComissaoEntregsadorEmpresa;

    @FXML
    private Text TextNomeEmpresa;
    
    @FXML
    void voltar() throws IOException {
        App.setRoot("gerenciarEmpresa");
    }
}
