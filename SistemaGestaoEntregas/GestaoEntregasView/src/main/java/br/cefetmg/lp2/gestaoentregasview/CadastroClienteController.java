package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.ClienteController;
import br.cefetmg.lp2.gestaoentregascontroller.EmpresaController;
import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CadastroClienteController implements Initializable {

    @FXML
    private Button ButtonCadastrarCliente;

    @FXML
    private TextField TextBairroCliente;

    @FXML
    private ComboBox<String> ComboBoxEmpresas;

    @FXML
    private TextField TextCPFCliente;

    @FXML
    private TextField TextLogradouroCliente;

    @FXML
    private TextField TextNomeCliente;

    @FXML
    private TextField TextTelefoneCliente;

    EmpresaController empresaController = new EmpresaController();
    ClienteController clienteController = new ClienteController();

    public void cadastroCliente() {
        String nome = TextNomeCliente.getText();
        String cpf = TextCPFCliente.getText();
        String logradouro = TextLogradouroCliente.getText();
        String bairro = TextBairroCliente.getText();
        String telefone = TextTelefoneCliente.getText();
        Empresa empresa = empresaController.separaTextoRetornaEmpresa(ComboBoxEmpresas.getValue());

        Cliente cliente = new Cliente(nome, logradouro, bairro, telefone, cpf, empresa);

        clienteController.cadastrar(cliente);
    }

    public void carregaNomes() {
        List<Empresa> lista = new ArrayList<>();
        lista = empresaController.listar();
        for (Empresa empresa : lista) {
            ComboBoxEmpresas.getItems().add(empresa.getId() + " - " + empresa.getNome());
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        carregaNomes();
        
    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("TelaInicialAdministrador");
    }
}
