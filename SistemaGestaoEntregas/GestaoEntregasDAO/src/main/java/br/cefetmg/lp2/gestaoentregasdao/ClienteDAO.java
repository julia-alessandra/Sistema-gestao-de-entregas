package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Cliente;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;


public class ClienteDAO {
        public void inserir(Cliente cliente) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            System.out.println("cliente criado com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar cliente");
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idCliente) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, idCliente);
            if (cliente != null) {
                entityManager.remove(cliente);
                System.out.println("cliente excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o cliente");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a cliente");
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery<Cliente> criteria = entityManager.getCriteriaBuilder().createQuery(Cliente.class);
        criteria.select(criteria.from(Cliente.class));
        List<Cliente> clientes = entityManager.createQuery(criteria).getResultList();
        for (Cliente cliente : clientes) {
            System.out.println("Id: " + cliente.getId() + "\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nEndereço: " 
                    + cliente.getLogradouro() + cliente.getBairro() + "\nCNPJ: " + cliente.getCnpj() + "/nTelefone: " + cliente.getTelefone());
            entityManager.close();
        }
    }

    public Cliente pesquisaId(int idcliente) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Cliente AS u WHERE u.id_cliente =:id ");
            query.setParameter("id", entityManager);
            List<Cliente> pesquisa = query.getResultList();
            if (!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("cliente não encontrado");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
