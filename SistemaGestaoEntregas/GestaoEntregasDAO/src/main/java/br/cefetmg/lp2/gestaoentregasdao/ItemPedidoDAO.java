package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.ItemPedido;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class ItemPedidoDAO {
     private EntityManagerFactory emf;
    private EntityManager em;

    public  ItemPedidoDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(ItemPedido itemPedido){
        em.getTransaction().begin();
        em.persist(itemPedido);
        em.getTransaction().commit();
    }

    public ItemPedido ler(int id) {
        return em.find(ItemPedido.class, id);
    }

    public void atualizar(ItemPedido itemPedido) {
        em.getTransaction().begin();
        em.merge(itemPedido);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        ItemPedido itemPedido = em.find(ItemPedido.class, id);
        if (itemPedido != null) {
            em.remove(itemPedido);
        }
        em.getTransaction().commit();
    }

    public List<ItemPedido> listarTodos() {
        return em.createQuery("SELECT c FROM itemPedido c", ItemPedido.class).getResultList();
    }
    
    public ItemPedido selecionar(int id) {
        em.getTransaction().begin();
        ItemPedido x = em.find(ItemPedido.class, id);
        return x;
    }
    
    public ItemPedido pesquisaId(int idItemPedido) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT i FROM ItemPedido i WHERE i.id = :id");
        query.setParameter("id", idItemPedido);
        List<ItemPedido> pesquisa = query.getResultList();
        return pesquisa.isEmpty() ? null : pesquisa.get(0);
    }
}