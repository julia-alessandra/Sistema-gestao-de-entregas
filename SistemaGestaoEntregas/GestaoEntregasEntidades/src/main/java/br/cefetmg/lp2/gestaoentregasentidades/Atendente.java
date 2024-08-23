package br.cefetmg.lp2.gestaoentregasentidades;

import br.cefetmg.lp2.gestaoentregasentidades.Perfil;
import br.cefetmg.lp2.gestaoentregasentidades.TipoPerfil;
import javax.persistence.*;

@Entity 
@Table
public class Atendente extends Perfil {
    public Atendente() {
        this.setTipoPerfil(TipoPerfil.ATENDENTE);
    }
}
