package br.cefetmg.lp2.gestaoentregasentidades.TiposPerfil;

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
