package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.EmpresaDAO;
import br.cefetmg.lp2.gestaoentregasentidades.*;
import java.util.List;

public class EmpresaController {

    private EmpresaDAO daoEmpresa = new EmpresaDAO();

    public void inserirBD(Empresa empresa){
        daoEmpresa.inserir(empresa);
    }
    
    public List<Empresa> getEmpresa() {
        return daoEmpresa.retornarEmpresas();
    }

    public Empresa separaTextoRetornaEmpresa(String texto) {
        int id;
        String[] partes = texto.split(" - ");
        id = Integer.parseInt(partes[0]);

        Empresa empresaSelecionada = new Empresa();
        empresaSelecionada = daoEmpresa.pesquisaId(id);

        return empresaSelecionada;

    }
    
    public void adicionaFuncionario(int idEmpresa, Funcionario funcionario){
        daoEmpresa.adicionarFuncionario(idEmpresa, funcionario);
    }
}

