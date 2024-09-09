package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.FuncionarioController;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ListarFuncionariosController {

    @FXML
    private ListView<String> listViewFuncionarios;

    private FuncionarioController funcionarioController = new FuncionarioController();

    @FXML
    private void initialize() {
        listarFuncionarios();
    }
    
    
    @FXML
    void voltar() throws IOException {
        App.setRoot("TelaInicialAdministrador");
    }

    private void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioController.listar();
        ObservableList<String> funcionariosTexto = FXCollections.observableArrayList();

        for (Funcionario funcionario : funcionarios) {
            String itemTexto = String.format("Nome: %s (  CPF: %s ) - Empresa: %s",
                    funcionario.getNome(), 
                    funcionario.getCpf(), 
                    funcionario.getEmpresa().getNome());
            funcionariosTexto.add(itemTexto);
        }

        listViewFuncionarios.setItems(funcionariosTexto);
    }

    @FXML
    public void salvarItemPedido() {
        listarFuncionarios();
    }
}
