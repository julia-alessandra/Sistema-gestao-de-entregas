package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Pedido;
import java.util.List;
import javax.persistence.*;

public class PedidoDAO {
      private EntityManagerFactory emf;
    private EntityManager em;

    public PedidoDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(Pedido pedido) {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
    }

    public Pedido ler(int id) {
        return em.find(Pedido.class, id);
    }

    public void atualizar(Pedido pedido) {
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        Pedido pedido = em.find(Pedido.class, id);
        if (pedido != null) {
            em.remove(pedido);
        }
        em.getTransaction().commit();
    }

    public List<Pedido> listarTodos() {
        return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }
    
    public Pedido selecionar(int id) {
        em.getTransaction().begin();
        Pedido x = em.find(Pedido.class, id);
        return x;
    }
        public Pedido pesquisaId(int idPedido) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT p FROM Pedido p WHERE p.id = :id");
        query.setParameter("id", idPedido);
        List<Pedido> pesquisa = query.getResultList();
        return pesquisa.isEmpty() ? null : pesquisa.get(0);
    }
    
}
