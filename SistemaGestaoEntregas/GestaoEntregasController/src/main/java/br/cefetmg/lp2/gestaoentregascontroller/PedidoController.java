package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.PedidoDAO;
import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {
         private PedidoDAO dao;
    
    public PedidoController() {
        dao = new PedidoDAO();
    }
    
    public boolean cadastrar(Pedido x) {
        dao.inserir(x);
        return true;
    }
    
    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }
   
    
    public List<Pedido> listar() {
        return dao.listarTodos();
    }
    
    public Pedido pesquisarId(int id) {
        return dao.pesquisaId(id);
    }
    
    public Pedido selecionar(int id) {
        return dao.selecionar(id);
    }
    
    public ArrayList<Pedido> atualizaDadosPedido(int ultimoPedido, Funcionario usuario) {
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        List<Pedido> pedidos = listar();
        Pedido pedido = new Pedido();

        for (int i = ultimoPedido; i < pedidos.size(); i++) {
            pedido = pedidos.get(i);
            listaPedidos.add(pedido);
        }
        return listaPedidos;
    }
}