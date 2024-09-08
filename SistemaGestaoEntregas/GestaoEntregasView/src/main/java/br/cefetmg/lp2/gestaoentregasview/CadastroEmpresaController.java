package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.*;
import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastroEmpresaController {
    

    @FXML
    private Button ButtonCriarEmpresa;

    @FXML
    private TextField TextCNPJEmpresa;

    @FXML
    private TextField TextNomeEmpresa;

    @FXML
    private TextField TextPorcentagemEntregadorEmpresa;

        private EmpresaController empresaController = new EmpresaController();

    
    @FXML
    public void cadastrarEmpresa()  throws IOException{
        String nome = TextNomeEmpresa.getText();
        String CNPJ = TextCNPJEmpresa.getText();
        Double porcentagem = Double.parseDouble(TextPorcentagemEntregadorEmpresa.getText());
        
        Empresa empresa = new Empresa(nome, CNPJ, porcentagem);
        empresaController.cadastrar(empresa);
        
        App.setRoot("cadastroFuncionario");

    }
   
}
