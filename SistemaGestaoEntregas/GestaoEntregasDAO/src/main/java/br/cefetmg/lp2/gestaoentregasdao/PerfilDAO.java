package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Perfil;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PerfilDAO {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public void inserir(Perfil perfil) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(perfil);
            entityManager.getTransaction().commit();
            System.out.println("Perfil criado com sucesso!");
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao criar perfil: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idPerfil) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Perfil perfil = entityManager.find(Perfil.class, idPerfil);
            if (perfil != null) {
                entityManager.remove(perfil);
                entityManager.getTransaction().commit();
                System.out.println("Perfil excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o perfil.");
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao excluir perfil: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaQuery<Perfil> criteria = entityManager.getCriteriaBuilder().createQuery(Perfil.class);
            criteria.select(criteria.from(Perfil.class));
            List<Perfil> perfis = entityManager.createQuery(criteria).getResultList();
            for (Perfil perfil : perfis) {
                System.out.println("Id: " + perfil.getId() + "\nTipo: " + perfil.getTipoPerfil());
            }
        } catch (Exception ex) {
            System.err.println("Erro ao listar perfis: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Perfil pesquisaNome(String nomePerfil) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("FROM Perfil WHERE tipoPerfil = :nome");
            query.setParameter("nome", nomePerfil);
            List<Perfil> pesquisa = query.getResultList();
            return pesquisa.isEmpty() ? null : pesquisa.get(0);
        } catch (Exception e) {
            System.err.println("Erro na pesquisa por nome: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public Perfil pesquisaId(int idPerfil) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("FROM Perfil WHERE id = :id");
            query.setParameter("id", idPerfil);
            List<Perfil> pesquisa = query.getResultList();
            return pesquisa.isEmpty() ? null : pesquisa.get(0);
        } catch (Exception e) {
            System.err.println("Erro na pesquisa por ID: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void close() {
        if (entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
