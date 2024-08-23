package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.EmpresaDAO;
import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import java.util.List;

public class EmpresaController {

    private EmpresaDAO nomesEmpresas = new EmpresaDAO();

    public List<String> getNome() {
        return nomesEmpresas.retornarNome();
}


}