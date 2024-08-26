package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Produto;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public void inserir(Produto produto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
            System.out.println("Produto criado com sucesso!");
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao criar produto: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idProduto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Produto produto = entityManager.find(Produto.class, idProduto);
            if (produto != null) {
                entityManager.remove(produto);
                entityManager.getTransaction().commit();
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar o produto.");
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao excluir produto: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaQuery<Produto> criteria = entityManager.getCriteriaBuilder().createQuery(Produto.class);
            criteria.select(criteria.from(Produto.class));
            List<Produto> produtos = entityManager.createQuery(criteria).getResultList();
            for (Produto produto : produtos) {
                System.out.println("Id: " + produto.getId() + "\nNome: " + produto.getNome() + "\nLocalização: " + produto.getLocalizacao());
            }
        } catch (Exception ex) {
            System.err.println("Erro ao listar produtos: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Produto pesquisaId(int idProduto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("FROM Produto WHERE id = :id");
            query.setParameter("id", idProduto);
            List<Produto> pesquisa = query.getResultList();
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
    
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

        // Ler dados do usuário
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite a localização do produto:");
        String localizacao = scanner.nextLine();

        // Criar um novo produto
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setLocalizacao(localizacao);

        // Salvar o produto usando DAO
        
        ProdutoDAO dao = new ProdutoDAO();
            dao.inserir(produto);
            System.out.println("Produto salvo com sucesso!");
        }
}