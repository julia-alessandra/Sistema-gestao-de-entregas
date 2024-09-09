package br.cefetmg.lp2.gestaoentregasentidades;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date data;
    private String status;
    private Double valorTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itensPedido;

    public Pedido(Date data, String status, Double valorTotal, Cliente cliente, List<ItemPedido> itensPedido) {
        this.data = data;
        this.status = status;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.itensPedido = itensPedido;
    }
    
    public Pedido() {

    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

}