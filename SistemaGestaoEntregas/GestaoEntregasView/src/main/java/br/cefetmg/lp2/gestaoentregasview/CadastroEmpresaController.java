package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.*;
import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastroEmpresaController {
    
    @FXML
    private Button ButtonCriarEmpresa;

    @FXML
    private TextField TextCNPJEmpresa;

    @FXML
    private TextField TextNomeAdministradorEmpresa;

    @FXML
    private TextField TextNomeEmpresa;

    @FXML
    private TextField TextPorcentagemEntregadorEmpresa;

    @FXML
    private TextField TextSenhaAdministradorEmpresa;

    @FXML
    private TextField TextTelefoneAdministradorEmpresa;
    
        private FuncionarioController funcionarioController = new FuncionarioController();
    private PerfilController perfilController = new PerfilController();
        private EmpresaController empresaController = new EmpresaController();

    
    public void cadastrarEmpresa(){
        String nome = TextNomeEmpresa.getText();
        String CNPJ = TextCNPJEmpresa.getText();
        Double porcentagem = Double.parseDouble(TextPorcentagemEntregadorEmpresa.getText());
        
        Empresa empresa = new Empresa(nome, CNPJ, porcentagem);
        empresaController.inserirBD(empresa);
    }

}
