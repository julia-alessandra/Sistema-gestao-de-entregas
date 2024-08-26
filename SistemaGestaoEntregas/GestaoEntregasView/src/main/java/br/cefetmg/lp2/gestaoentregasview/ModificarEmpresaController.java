package br.cefetmg.lp2.gestaoentregasview;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class ModificarEmpresaController {
    
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
}
