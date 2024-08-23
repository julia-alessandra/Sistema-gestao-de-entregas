package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.EmpresaController;
import br.cefetmg.lp2.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class CadastroFuncionarioController implements Initializable {

    @FXML
    private Button ButtonCadastrarFuncionario;

    @FXML
    private ComboBox<String> ComboBoxEmpresas;

    @FXML
    private TextField textNomeFuncionario;

    @FXML
    private TextField textSenhaFuncionario;

    @FXML
    private TextField textTelefoneFuncionario;

    @FXML
    private ComboBox<String> ComboBoxCargos;

    private EmpresaController empresas = new EmpresaController();

    public void cadastrarFuncionario() {

        String nome = textNomeFuncionario.getText();
        String telefone = textTelefoneFuncionario.getText();
        String senha = textSenhaFuncionario.getText();
        String empresa = ComboBoxEmpresas.getValue();
        String cargos = ComboBoxCargos.getValue();
        
        
    }

    private void carregaNomes() {
        ComboBoxEmpresas.getItems().addAll(empresas.getNome());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregaNomes();
        ComboBoxCargos.getItems().addAll("Administrador", "Entregador", "Atendente");
    }
}
