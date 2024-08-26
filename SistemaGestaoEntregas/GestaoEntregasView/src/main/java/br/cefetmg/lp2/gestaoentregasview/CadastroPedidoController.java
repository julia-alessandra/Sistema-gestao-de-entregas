package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CadastroPedidoController {

    @FXML
    private Button BotaoCadastrarPedido;

    @FXML
    private TableColumn<?, ?> ColunaProdutosPedidos;

    @FXML
    private TableColumn<?, ?> ColunaValorUnitarioPedido;

    @FXML
    private ComboBox<?> ComboBoxAtendentePedido;

    @FXML
    private ComboBox<?> ComboBoxEntregadorPedido;

    @FXML
    private ComboBox<?> ComboBoxStatusPedido;

    @FXML
    private TextField TextIdProdutosPedido;

    @FXML
    private TextArea TextObservacoesPedido;

    @FXML
    private TextField TextValorTotalPedido;

    @FXML
    private void initialize() {
    }

//        @FXML
//        public void salvarPedido() {
//            String nomeProduto = comboBoxProduto.getSelectionModel().getSelectedItem();
//            String quantidade = textFieldQuantidade.getText();
//            String valorUnitario = textFieldValorUnitario.getText();
//            String valorTotal = textFieldValorTotal.getText();
//            String marca = textFieldMarca.getText();
//            String formaPagamento = textFieldFormaPagamento.getText();
//            String observacoes = textAreaObservacoes.getText();
//
//            ArrayList<Pedido> pedidos = new ArrayList<>();
//
//            Alert alert = new Alert(Alert.AlertType.NONE);
//            try {
//
//                if (nomeProduto == null || quantidade.isEmpty() || valorUnitario.isEmpty() || valorTotal.isEmpty() || marca.isEmpty() || formaPagamento.isEmpty() || observacoes.isEmpty()) {
//                    alert.setAlertType(Alert.AlertType.ERROR);
//                    alert.setContentText("Preencha todos os campos");
//
//                } else {
//                    Pedido pedido = new Pedido();
//
//                    pedidos.add(pedido);
//                    alert.setAlertType(Alert.AlertType.INFORMATION);
//                    alert.setContentText("Pedido cadastrado com sucesso! ");
//                }
//
//            } catch (Exception ex) {
//                System.out.println(ex.toString());
//                alert.setAlertType(Alert.AlertType.ERROR);
//                alert.setContentText("Error: " + ex.getMessage());
//            }
//            alert.show(); //exibe a mensagem
//            resetarCadastro(); //limpa os campos
//        }


//    private void resetarCadastro() {
//        comboBoxProduto.setValue(null);
//        textFieldQuantidade.setText(null);
//        textFieldValorUnitario.setText(null);
//        textFieldValorTotal.setText(null);
//        textFieldMarca.setText(null);
//        textFieldFormaPagamento.setText(null);
//        textAreaObservacoes.setText(null);
//    }
}
