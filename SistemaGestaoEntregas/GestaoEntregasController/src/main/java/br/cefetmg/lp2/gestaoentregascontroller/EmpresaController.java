package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.EmpresaDAO;
import br.cefetmg.lp2.gestaoentregasentidades.*;
import java.util.List;

public class EmpresaController {

    private EmpresaDAO dao;
    
    public EmpresaController() {
        dao = new EmpresaDAO();
    }
    
    public boolean cadastrar(Empresa x) {
        dao.inserir(x);
        return true;
    }
    
    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }
  
    public List<Empresa> listar() {
        return dao.listarTodos();
    }
    
    
    public List<Empresa> pesquisarNome(String nome) {
        return dao.pesquisarNome(nome);
    }
    
    public Empresa selecionar(int id) {
        return dao.selecionar(id);
    }  

    public Empresa separaTextoRetornaEmpresa(String texto) {
        int id;
        String[] partes = texto.split(" - ");
        id = Integer.parseInt(partes[0]);

        Empresa empresaSelecionada = new Empresa();
        empresaSelecionada = dao.pesquisaId(id);

        return empresaSelecionada;

    }
    
}