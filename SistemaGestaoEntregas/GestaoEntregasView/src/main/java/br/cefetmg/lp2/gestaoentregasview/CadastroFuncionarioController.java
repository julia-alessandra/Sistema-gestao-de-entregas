package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.*;
import br.cefetmg.lp2.gestaoentregasentidades.*;
import java.net.URL;
import java.util.*;
import javafx.fxml.*;
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

    private EmpresaController empresaController = new EmpresaController();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private PerfilController perfilController = new PerfilController();

    public void cadastrarFuncionario() {

        String nome = textNomeFuncionario.getText();
        String telefone = textTelefoneFuncionario.getText();
        String senha = textSenhaFuncionario.getText();
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

        Funcionario funcionario = new Funcionario(nome, telefone, senha, empresa);
        Perfil perfil = new Perfil(tipoPerfil, funcionario);
        funcionario.setPerfil(perfil);
        
        
        funcionarioController.inserirBD(funcionario);
        perfilController.inserirBD(perfil);
    }

    public void carregaNomes() {
        List<Empresa> lista = new ArrayList<>();
        lista = empresaController.getEmpresa();
        for (Empresa empresa : lista) {
            ComboBoxEmpresas.getItems().add(empresa.getId() + " - " + empresa.getNome());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregaNomes();
        ComboBoxCargos.getItems().addAll("Administrador", "Entregador", "Atendente");
    }
}
