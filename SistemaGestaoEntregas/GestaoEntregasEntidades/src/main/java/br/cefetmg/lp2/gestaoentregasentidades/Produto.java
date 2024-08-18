package br.cefetmg.lp2.gestaoentregasentidades;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int id;

    @Column(name = "nome_produto")
    private String nome;
    
    @Column(name = "localizacao_produto")
    private String localizacao;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "produto")
    private List<ItemPedido> itemPedido;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }
}
