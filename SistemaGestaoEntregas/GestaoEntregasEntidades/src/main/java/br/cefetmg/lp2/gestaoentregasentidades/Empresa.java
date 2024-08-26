package br.cefetmg.lp2.gestaoentregasentidades;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int id;
    
    @Column(name = "nome_empresa")
    private String nome;
    
    @Column(name = "cnpj_empresa")
    private String cnpj;
    
    @Column(name = "porcentagemComissao_empresa")
    private Double porcentagemComissaoEntregador;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> clientes;

    public Empresa(String nome, String cnpj, Double porcentagemComissaoEntregador) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.porcentagemComissaoEntregador = porcentagemComissaoEntregador;
    }

    public Empresa() {
    }
    
    

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getPorcentagemComissaoEntregador() {
        return porcentagemComissaoEntregador;
    }

    public void setPorcentagemComissaoEntregador(Double porcentagemComissaoEntregador) {
        this.porcentagemComissaoEntregador = porcentagemComissaoEntregador;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}