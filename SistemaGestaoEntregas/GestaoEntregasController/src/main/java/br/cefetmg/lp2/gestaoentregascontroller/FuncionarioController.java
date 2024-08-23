package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.FuncionarioDAO;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;

public class FuncionarioController {
    
    FuncionarioDAO DAO = new FuncionarioDAO();
    
    public void inserirBD(Funcionario funcionario){
        DAO.inserir(funcionario);
    }
}
