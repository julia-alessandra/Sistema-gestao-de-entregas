package br.cefetmg.lp2.gestaoentregasentidades;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id;

    @Column(name = "nome_cliente")
    private String nome;
    
    @Column(name = "logradouro_cliente")
    private String logradouro;
    
    @Column(name = "bairro_cliente")
    private String bairro;
    
    @Column(name = "telefone_cliente")
    private String telefone;
    
    @Column(name = "cnpj_cliente")
    private String cnpj;
    
    @Column(name = "cpf_cliente")
    private String cpf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;

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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
