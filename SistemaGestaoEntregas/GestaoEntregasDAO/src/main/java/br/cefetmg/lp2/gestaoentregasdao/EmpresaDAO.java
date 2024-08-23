package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class EmpresaDAO {

    public void inserir(Empresa empresa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empresa);
            entityManager.getTransaction().commit();
            System.out.println("empresa criado com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar empresa");
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idEmpresa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Empresa empresa = entityManager.find(Empresa.class, idEmpresa);
            if (empresa != null) {
                entityManager.remove(empresa);
                System.out.println("empresa excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o empresa");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a empresa");
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery<Empresa> criteria = entityManager.getCriteriaBuilder().createQuery(Empresa.class);
        criteria.select(criteria.from(Empresa.class));
        List<Empresa> empresas = entityManager.createQuery(criteria).getResultList();
        for (Empresa empresa : empresas) {
            System.out.println("Id: " + empresa.getId() + "\nNome: " + empresa.getNome() + "\nLocalização: " + empresa.getCnpj());
            entityManager.close();
        }
    }

    public Empresa pesquisaNome(String nomeEmpresa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Empresa AS u WHERE u.nome_empresa =:nome ");
            query.setParameter("nomeEmpresa", entityManager);
            List<Empresa> pesquisa = query.getResultList();
            if (!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("empresa não encontrado");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> retornarNome() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> nomes = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT e.nome_empresa FROM empresa e");
            nomes = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return nomes;
    }
    
}