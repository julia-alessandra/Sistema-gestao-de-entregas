package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import br.cefetmg.lp2.gestaoentregasentidades.Perfil;
import br.cefetmg.lp2.gestaoentregasentidades.TipoPerfil;
import static br.cefetmg.lp2.gestaoentregasentidades.TipoPerfil.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class TelaInicialAdministradorController {

    private App app;

    @FXML
    private Text LabelNomeUsuario;

    @FXML
    private Button buttonCadastrarClientes;

    @FXML
    private Button buttonCadastrarFuncionarios;

    @FXML
    private Button buttonCadastrarPedido;

    @FXML
    private Button buttonCadastrarProduto;

    @FXML
    private Button buttonGerarRelatorio;

    @FXML
    private Button buttonListarClientes;

    @FXML
    private Button buttonListarFuncionarios;

    @FXML
    private Button buttonListarPedidos;

    public void setApp(App app) {
        this.app = app;
    }

    TelaLoginController login = new TelaLoginController();

    public void initialize(URL url, ResourceBundle rb) throws IOException {
    }

    void administraTela(Funcionario funcionario) {
        Perfil perfil = funcionario.getPerfil();
        TipoPerfil tipoPerfil = perfil.getTipoPerfil();

        if (tipoPerfil == ADMINISTRADOR) {
            buttonCadastrarClientes.setVisible(true);
            buttonListarClientes.setVisible(true);
            buttonCadastrarPedido.setVisible(true);
            buttonCadastrarFuncionarios.setVisible(true);
            buttonCadastrarProduto.setVisible(true);
            buttonListarFuncionarios.setVisible(true);
            buttonListarPedidos.setVisible(true);
            buttonGerarRelatorio.setVisible(true);

        } else if (tipoPerfil == ATENDENTE) {
            buttonCadastrarClientes.setVisible(true);
            buttonListarClientes.setVisible(true);
            buttonCadastrarPedido.setVisible(true);

        } else if (tipoPerfil == ENTREGADOR) {
            buttonListarPedidos.setVisible(true);

        }
    }

    @FXML
    private void buttonCadastrarPedido() throws IOException {
        app.setRoot("FXMLCadastrarPedido");
    }

    @FXML
    private void buttonListarClientes() throws IOException {
        app.setRoot("FXMLGerenciarClientes");
    }

    @FXML
    private void buttonCadastrarClientes() throws IOException {
        app.setRoot("FXMLCadastrarCliente");
    }

    @FXML
    private void buttonCadastrarFuncionarios() throws IOException {
        app.setRoot("FXMLCadastrarFuncionario");
    }

    @FXML
    private void buttonCadastrarProduto() throws IOException {
        app.setRoot("FXMLCadastrarProduto");
    }

    @FXML
    private void buttonListarFuncionarios() throws IOException {
        app.setRoot("FXMLGerenciarFuncionario");
    }

    @FXML
    private void buttonListarPedidos() throws IOException {
        app.setRoot("FXMLGerenciarPedido");
    }

    @FXML
    private void buttonGerarRelatorio() throws IOException {
        app.setRoot("GerarRelatorio");
    }
}
