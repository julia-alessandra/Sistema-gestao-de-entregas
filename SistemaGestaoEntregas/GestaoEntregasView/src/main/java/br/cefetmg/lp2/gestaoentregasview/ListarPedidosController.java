package br.cefetmg.lp2.gestaoentregasview;

import br.cefetmg.lp2.gestaoentregascontroller.PedidoController;
import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ListarPedidosController {

    @FXML
    private ListView<String> listViewPedidos;

    private PedidoController pedidoController = new PedidoController();

    @FXML
    private void initialize() {
        listarPedidos();
    }

    @FXML
    void voltar() throws IOException {
        App.setRoot("TelaInicialAdministrador");
    }

    private void listarPedidos() {
        List<Pedido> pedidos = pedidoController.listar();
        ObservableList<String> pedidosTexto = FXCollections.observableArrayList();

        for (Pedido pedido : pedidos) {
            String itemTexto = String.format("Data: %s -  valor Total: %.2f  - Cliente: %s",
                    pedido.getStatus(),
                    pedido.getValorTotal(),
                    pedido.getCliente().getNome());
            pedidosTexto.add(itemTexto);
        }

        listViewPedidos.setItems(pedidosTexto);
    }

    @FXML
    public void salvarItemPedido() {
        listarPedidos();
    }
}
