package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.ProdutoDAO;
import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.util.List;

public class ProdutoController {
     private ProdutoDAO dao;
    
    public ProdutoController() {
        dao = new ProdutoDAO();
    }
    
    public boolean cadastrar(Produto x) {
        dao.inserir(x);
        return true;
    }
    
    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }
   
    
    public List<Produto> listar() {
        return dao.listarTodos();
    }
    
    
    public Produto pesquisarNome(String nome) {
        return dao.pesquisarNome(nome);
    }
    
    public Produto selecionar(int id) {
        return dao.selecionar(id);
    }  
}