package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FuncionarioDAO {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public void inserir(Funcionario funcionario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
            System.out.println("Funcionário criado com sucesso!");
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao criar funcionário: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idFuncionario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Funcionario funcionario = entityManager.find(Funcionario.class, idFuncionario);
            if (funcionario != null) {
                entityManager.remove(funcionario);
                entityManager.getTransaction().commit();
                System.out.println("Funcionário excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o funcionário.");
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao excluir funcionário: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaQuery<Funcionario> criteria = entityManager.getCriteriaBuilder().createQuery(Funcionario.class);
            criteria.select(criteria.from(Funcionario.class));
            List<Funcionario> funcionarios = entityManager.createQuery(criteria).getResultList();
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Id: " + funcionario.getId() + "\nNome: " + funcionario.getNome() + "\nTelefone: " + funcionario.getTelefone());
            }
        } catch (Exception ex) {
            System.err.println("Erro ao listar funcionários: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Funcionario pesquisaId(int idFuncionario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Funcionario.class, idFuncionario);
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
