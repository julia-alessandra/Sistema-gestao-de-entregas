package br.cefetmg.lp2.gestaoentregasentidades;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import br.cefetmg.lp2.gestaoentregasentidades.TipoPerfil;
import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPerfil", discriminatorType = DiscriminatorType.STRING)
public abstract class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private TipoPerfil tipoPerfil;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFuncionario", nullable = false)
    private Funcionario funcionario;

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
