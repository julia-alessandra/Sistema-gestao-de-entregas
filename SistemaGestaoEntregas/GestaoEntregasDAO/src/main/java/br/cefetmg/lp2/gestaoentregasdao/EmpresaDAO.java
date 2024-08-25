package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

public class EmpresaDAO {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public void inserir(Empresa empresa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empresa);
            entityManager.getTransaction().commit();
            System.out.println("Empresa criada com sucesso!");
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao criar empresa: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(int idEmpresa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Empresa empresa = entityManager.find(Empresa.class, idEmpresa);
            if (empresa != null) {
                entityManager.remove(empresa);
                entityManager.getTransaction().commit();
                System.out.println("Empresa excluída com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar a empresa.");
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao excluir a empresa: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaQuery<Empresa> criteria = entityManager.getCriteriaBuilder().createQuery(Empresa.class);
            criteria.select(criteria.from(Empresa.class));
            List<Empresa> empresas = entityManager.createQuery(criteria).getResultList();
            for (Empresa empresa : empresas) {
                System.out.println("Id: " + empresa.getId() + "\nNome: " + empresa.getNome() + "\nLocalização: " + empresa.getCnpj());
            }
        } catch (Exception ex) {
            System.err.println("Erro ao listar empresas: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Empresa pesquisaNome(String nomeEmpresa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("FROM Empresa WHERE nome_empresa = :nome");
            query.setParameter("nome", nomeEmpresa);
            List<Empresa> pesquisa = query.getResultList();
            return pesquisa.isEmpty() ? null : pesquisa.get(0);
        } catch (Exception e) {
            System.err.println("Erro na pesquisa por nome: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<Empresa> retornarEmpresas() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT e FROM Empresa e", Empresa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao retornar empresas: " + e.getMessage());
            return List.of(); // Retorna uma lista vazia em caso de erro
        } finally {
            entityManager.close();
        }
    }

    public Empresa pesquisaId(int idEmpresa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT e FROM Empresa e WHERE e.id = :id");
            query.setParameter("id", idEmpresa);
            List<Empresa> pesquisa = query.getResultList();
            return pesquisa.isEmpty() ? null : pesquisa.get(0);
        } catch (Exception e) {
            System.err.println("Erro na pesquisa por ID: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }
    
    public void adicionarFuncionario(int empresaId, Funcionario funcionario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            EmpresaDAO dao = null;
            Empresa empresa = null;
            empresa = dao.pesquisaId(empresaId);
            if (empresa != null) {
                List<Funcionario> funcionarios = empresa.getFuncionarios();
                if (funcionarios == null) {
                    funcionarios = new ArrayList<>();
                    empresa.setFuncionarios(funcionarios);
                }
                funcionarios.add(funcionario);

                entityManager.persist(funcionario);
                entityManager.getTransaction().commit();
                System.out.println("Funcionário adicionado com sucesso!");
            } else {
                System.out.println("Empresa não encontrada!");
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao adicionar funcionário: " + ex.getMessage());
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
