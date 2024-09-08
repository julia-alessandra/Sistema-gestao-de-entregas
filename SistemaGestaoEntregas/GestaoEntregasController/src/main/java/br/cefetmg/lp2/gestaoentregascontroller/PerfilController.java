package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.PerfilDAO;
import br.cefetmg.lp2.gestaoentregasentidades.*;

public class PerfilController {
       private PerfilDAO dao;
    
    public PerfilController() {
        dao = new PerfilDAO();
    }
    
    public boolean cadastrar(Perfil x) {
        dao.inserir(x);
        return true;
    }
    
    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }

}
