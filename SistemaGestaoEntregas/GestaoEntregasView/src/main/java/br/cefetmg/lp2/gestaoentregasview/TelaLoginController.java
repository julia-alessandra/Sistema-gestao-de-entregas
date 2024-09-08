package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.ClienteController;
import br.cefetmg.lp2.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.*;
import javafx.scene.control.*;

public class TelaLoginController {

    private App app;

    @FXML
    private TextField TextCpfUsuario;

    @FXML
    private PasswordField TextSenhaUsuario;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonVoltar;

    FuncionarioController funcionarioController = new FuncionarioController();
    ShowAlert s = new ShowAlert();

    @FXML
    void voltar() throws IOException {
        App.setRoot("telaInicial");
    }

    public void initialize(URL url, ResourceBundle rb) {
    }

    
    public Funcionario validarLogin() throws IOException {
        String cpfUsuario = TextCpfUsuario.getText();
        String senha = TextSenhaUsuario.getText();

        if (cpfUsuario == null || cpfUsuario.isEmpty() || senha == null || senha.isEmpty()) {
            s.showAlert("Login falhou", "CPF e senha não podem estar vazios.");
            return null;
        }

        Funcionario funcionario = new Funcionario();
        System.out.println("criou o funcionario" + cpfUsuario);

        funcionario = funcionarioController.procurarPorCPF(cpfUsuario);
        System.out.println("procurou o cpf" + funcionario.getNome());

        if (funcionario != null && funcionarioController.validarSenha(funcionario, senha)) {
            System.out.println("senha validada " + funcionario.getNome());

            return funcionario;
        } else {
            s.showAlert("Login falhou", "CPF ou senha incorretos. Por favor, tente novamente.");
            return null;
        }
    }
    public void trocaDeTela() throws IOException{
        if(validarLogin() !=null)
            App.setRoot("FXMLTelaInicialAdministrador");
    }
}
