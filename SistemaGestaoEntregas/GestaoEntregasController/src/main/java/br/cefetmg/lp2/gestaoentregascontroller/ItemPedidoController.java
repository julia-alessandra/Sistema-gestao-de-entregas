package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.ItemPedidoDAO;
import br.cefetmg.lp2.gestaoentregasentidades.ItemPedido;
import java.util.List;

public class ItemPedidoController {
        private ItemPedidoDAO dao;
    
    public ItemPedidoController() {
        dao = new ItemPedidoDAO();
    }
    
    public boolean cadastrar(ItemPedido x) {
        dao.inserir(x);
        return true;
    }
    
    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }
    
    public List<ItemPedido> listar() {
        return dao.listarTodos();
    }

    public ItemPedido pesquisarId(int id) {
        return dao.pesquisaId(id);
    }
    
    public ItemPedido selecionar(int id) {
        return dao.selecionar(id);
    }  
}
