package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.PerfilDAO;
import br.cefetmg.lp2.gestaoentregasentidades.*;

public class PerfilController {
    PerfilDAO DAO = new PerfilDAO();

    public void inserirBD(Perfil perfilFunc){
        Perfil perfil;
        perfil = perfilFunc;
        DAO.inserir(perfil);
    }    
}
