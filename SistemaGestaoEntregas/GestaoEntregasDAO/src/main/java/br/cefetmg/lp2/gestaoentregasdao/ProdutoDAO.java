package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProdutoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ProdutoDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public Produto ler(int id) {
        return em.find(Produto.class, id);
    }

    public void atualizar(Produto produto) {
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.remove(produto);
        }
        em.getTransaction().commit();
    }

    public List<Produto> listarTodos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public Produto selecionar(int id) {
        em.getTransaction().begin();
        Produto x = em.find(Produto.class, id);
        return x;
    }

    public Produto pesquisarNome(String nome) {
        var cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> criteria = cb.createQuery(Produto.class);
        var root = criteria.from(Produto.class);
        criteria.select(root).where(cb.like(root.get("nome"), "%" + nome + "%"));
        List<Produto> lista = em.createQuery(criteria).getResultList();
        if (lista.size() > 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }

}