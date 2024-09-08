package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import br.cefetmg.lp2.gestaoentregasentidades.Perfil;
import br.cefetmg.lp2.gestaoentregasentidades.TipoPerfil;

public class GestaoEntregasDAO {

    public static void main(String[] args) {

        FuncionarioDAO DAO = new FuncionarioDAO();
        EmpresaDAO EDAO = new EmpresaDAO();

        Empresa novaEmpresa = new Empresa("Empresa J", "12345678239195", 5.0);

        Funcionario novoAdministrador = new Funcionario("davi", "66666666", "151666316", "senha", novaEmpresa);
        Funcionario novoAtendente = new Funcionario("gabriel", "66348734366", "15166317", "senhe", novaEmpresa);
        Funcionario novoEntregador = new Funcionario("alessandro", "66662387398096", "151666318", "senhi", novaEmpresa);

        TipoPerfil tipo1 = TipoPerfil.ADMINISTRADOR;
        TipoPerfil tipo2 = TipoPerfil.ATENDENTE;
        TipoPerfil tipo3 = TipoPerfil.ENTREGADOR;

        Perfil perfil1 = new Perfil(tipo1, novoAdministrador);
                Perfil perfil2 = new Perfil(tipo2, novoAtendente);
        Perfil perfil3 = new Perfil(tipo3, novoEntregador);
        
       EDAO.inserir(novaEmpresa);
       DAO.inserir(novoEntregador);
       DAO.inserir(novoAtendente);
       DAO.inserir(novoAdministrador);

    }
}
