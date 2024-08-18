package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class FuncionarioDAO {
    
    public void inserir(Funcionario funcionario) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
            System.out.println("funcionario criado com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar funcionario");
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idFuncionario) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Funcionario funcionario = entityManager.find(Funcionario.class, idFuncionario);
            if (funcionario != null) {
                entityManager.remove(funcionario);
                System.out.println("funcionario excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o funcionario");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a funcionario");
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery<Funcionario> criteria = entityManager.getCriteriaBuilder().createQuery(Funcionario.class);
        criteria.select(criteria.from(Funcionario.class));
        List<Funcionario> funcionarios = entityManager.createQuery(criteria).getResultList();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Id: " + funcionario.getId() + "\nNome: " + funcionario.getNome() + "\nTelefone: " + funcionario.getTelefone());
            entityManager.close();
        }
    }

    public Funcionario pesquisaId(int idFuncionario) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Funcionario AS u WHERE u.id_funcionario =:id ");
            query.setParameter("id", entityManager);
            List<Funcionario> pesquisa = query.getResultList();
            if (!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("funcionario não encontrado");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
