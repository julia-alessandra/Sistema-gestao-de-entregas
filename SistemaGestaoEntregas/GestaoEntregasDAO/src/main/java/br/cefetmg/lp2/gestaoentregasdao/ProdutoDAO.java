package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class ProdutoDAO {

    public void inserir(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
            System.out.println("produto criado com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar produto");
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idProduto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Produto produto = entityManager.find(Produto.class, idProduto);
            if (produto != null) {
                entityManager.remove(produto);
                System.out.println("produto excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o produto");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a produto");
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery<Produto> criteria = entityManager.getCriteriaBuilder().createQuery(Produto.class);
        criteria.select(criteria.from(Produto.class));
        List<Produto> produtos = entityManager.createQuery(criteria).getResultList();
        for (Produto produto : produtos) {
            System.out.println("Id: " + produto.getId() + "\nNome: " + produto.getNome() + "\nLocalização: " + produto.getLocalizacao());
            entityManager.close();
        }
    }

    public Produto pesquisaId(int idProduto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Produto AS u WHERE u.id_produto =:id ");
            query.setParameter("id", entityManager);
            List<Produto> pesquisa = query.getResultList();
            if (!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("Produto não encontrado");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
