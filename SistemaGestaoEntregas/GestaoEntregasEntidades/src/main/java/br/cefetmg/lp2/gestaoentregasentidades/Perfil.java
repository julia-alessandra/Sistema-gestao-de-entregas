package br.cefetmg.lp2.gestaoentregasentidades;

import br.cefetmg.lp2.gestaoentregasentidades.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_tipoperfil", nullable = false)
    private TipoPerfil tipoPerfil;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Perfil(TipoPerfil tipoPerfil, Funcionario funcionario) {
        this.tipoPerfil = tipoPerfil;
        this.funcionario = funcionario;
    }

    public Perfil() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}