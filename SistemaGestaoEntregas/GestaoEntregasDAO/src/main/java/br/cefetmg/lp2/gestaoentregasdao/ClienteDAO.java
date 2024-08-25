package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ClienteDAO {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public void inserir(Cliente cliente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            System.out.println("Cliente criado com sucesso!");
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao criar cliente: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idCliente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, idCliente);
            if (cliente != null) {
                entityManager.remove(cliente);
                entityManager.getTransaction().commit();
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o cliente.");
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao excluir cliente: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaQuery<Cliente> criteria = entityManager.getCriteriaBuilder().createQuery(Cliente.class);
            criteria.select(criteria.from(Cliente.class));
            List<Cliente> clientes = entityManager.createQuery(criteria).getResultList();
            for (Cliente cliente : clientes) {
                System.out.println("Id: " + cliente.getId() + "\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf()
                        + "\nEndereço: " + cliente.getLogradouro() + ", " + cliente.getBairro()
                        + "\nCNPJ: " + cliente.getCnpj() + "\nTelefone: " + cliente.getTelefone());
            }
        } catch (Exception ex) {
            System.err.println("Erro ao listar clientes: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Cliente pesquisaId(int idCliente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("FROM Cliente WHERE id = :id");
            query.setParameter("id", idCliente);
            List<Cliente> pesquisa = query.getResultList();
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
