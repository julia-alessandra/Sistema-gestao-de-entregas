package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.ClienteDAO;
import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import java.util.List;

public class ClienteController {
        private ClienteDAO dao;
    
    public ClienteController() {
        dao = new ClienteDAO();
    }
    
    public boolean cadastrar(Cliente x) {
        dao.inserir(x);
        return true;
    }
    
    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }
   
    
    public List<Cliente> listar() {
        return dao.listarTodos();
    }
    
    
    public Cliente pesquisarNome(String nome) {
        return dao.pesquisarNome(nome);
    }
    
    public Cliente selecionar(int id) {
        return dao.selecionar(id);
    }  
}
