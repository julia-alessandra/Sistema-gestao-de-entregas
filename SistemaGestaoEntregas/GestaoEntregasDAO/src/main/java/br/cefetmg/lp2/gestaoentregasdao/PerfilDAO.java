package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Perfil;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PerfilDAO {
 private EntityManagerFactory emf;
    private EntityManager em;

    public PerfilDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(Perfil perfil){
        em.getTransaction().begin();
        em.persist(perfil);
        em.getTransaction().commit();
    }

    public void atualizar(Perfil perfil) {
        em.getTransaction().begin();
        em.merge(perfil);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        Perfil perfil = em.find(Perfil.class, id);
        if (perfil != null) {
            em.remove(perfil);
        }
        em.getTransaction().commit();
    }
}
