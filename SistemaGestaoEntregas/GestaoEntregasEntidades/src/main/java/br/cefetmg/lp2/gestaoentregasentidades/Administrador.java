package br.cefetmg.lp2.gestaoentregasentidades;

import br.cefetmg.lp2.gestaoentregasentidades.Perfil;
import br.cefetmg.lp2.gestaoentregasentidades.TipoPerfil;
import javax.persistence.*;

@Entity
@Table
public class Administrador extends Perfil {
    public Administrador() {
        this.setTipoPerfil(TipoPerfil.ADMINISTRADOR);
    }
}
