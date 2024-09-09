package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.*;
import br.cefetmg.lp2.gestaoentregasentidades.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CadastroFuncionarioController implements Initializable {

    @FXML
    private Button ButtonCadastrarFuncionario;
    
    @FXML
    private Button buttonVoltar;

    @FXML
    private ComboBox<String> ComboBoxEmpresas;

    @FXML
    private TextField textNomeFuncionario;

    @FXML
    private TextField textSenhaFuncionario;

    @FXML
    private TextField textTelefoneFuncionario;

    @FXML
    private TextField textCpfFuncionario;

    @FXML
    private ComboBox<String> ComboBoxCargos;

    private EmpresaController empresaController = new EmpresaController();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private PerfilController perfilController = new PerfilController();

    public void cadastrarFuncionario() {
        String nome = textNomeFuncionario.getText();
        String telefone = textTelefoneFuncionario.getText();
        String senha = textSenhaFuncionario.getText();
        String cpf = textCpfFuncionario.getText();
        String cargos = ComboBoxCargos.getValue();
        Empresa empresa = empresaController.separaTextoRetornaEmpresa(ComboBoxEmpresas.getValue());

        TipoPerfil tipoPerfil = null;
        if (cargos.equals("Administrador")) {
            tipoPerfil = TipoPerfil.ADMINISTRADOR;
        } else if (cargos.equals("Atendente")) {
            tipoPerfil = TipoPerfil.ATENDENTE;
        } else if (cargos.equals("Entregador")) {
            tipoPerfil = TipoPerfil.ENTREGADOR;
        }

        Funcionario funcionario = new Funcionario(nome, telefone, cpf, senha, empresa);
        Perfil perfil = new Perfil(tipoPerfil, funcionario);
        funcionario.setPerfil(perfil);

        funcionarioController.cadastrar(funcionario);
        perfilController.cadastrar(perfil);
        System.out.println("controller ok");
    }

    public void carregaNomes() {
        List<Empresa> lista = new ArrayList<>();
        lista = empresaController.listar();
        for (Empresa empresa : lista) {
            ComboBoxEmpresas.getItems().add(empresa.getId() + " - " + empresa.getNome());
        }
    }
    
    @FXML
    void voltar() throws IOException {
        App.setRoot("gerenciarFuncionarios");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregaNomes();
        ComboBoxCargos.getItems().addAll("Administrador", "Entregador", "Atendente");
    }
}