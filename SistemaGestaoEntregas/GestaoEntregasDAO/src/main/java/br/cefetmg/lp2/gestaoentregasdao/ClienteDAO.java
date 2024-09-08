package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ClienteDAO {
   private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente ler(int id) {
        return em.find(Cliente.class, id);
    }

    public void atualizar(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.remove(cliente);
        }
        em.getTransaction().commit();
    }

    public List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
    
    public Cliente selecionar(int id) {
        em.getTransaction().begin();
        Cliente x = em.find(Cliente.class, id);
        return x;
    }
    
    public Cliente pesquisarNome(String nome) {
        var cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = cb.createQuery(Cliente.class);
        var root = criteria.from(Cliente.class);
        criteria.select(root).where(cb.like(root.get("nome"), "%" + nome + "%"));
        List<Cliente> lista = em.createQuery(criteria).getResultList();
        if (lista.size() > 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }
}
