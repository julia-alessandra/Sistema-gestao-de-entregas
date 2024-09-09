package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FuncionarioDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public FuncionarioDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(Funcionario funcionario) {
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    public Funcionario ler(int id) {
        return em.find(Funcionario.class, id);
    }

    public void atualizar(Funcionario funcionario) {
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.remove(funcionario);
        }
        em.getTransaction().commit();
    }

    public List<Funcionario> listarTodos() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }

    public Funcionario selecionar(int id) {
        return em.find(Funcionario.class, id);
    }

    public List<Funcionario> pesquisarNome(String nome) {
        var cb = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteria = cb.createQuery(Funcionario.class);
        var root = criteria.from(Funcionario.class);
        criteria.select(root).where(cb.like(root.get("nome"), "%" + nome + "%"));
        return em.createQuery(criteria).getResultList();
    }

    public Funcionario pesquisaCpf(String cpfFuncionario) {
        System.out.println("Dentro do dao");
        Query query = em.createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf");
        query.setParameter("cpf", cpfFuncionario);
        List<Funcionario> pesquisa = query.getResultList();
        System.out.println("Fim do dao" + pesquisa.get(0).getNome());
        return pesquisa.isEmpty() ? null : pesquisa.get(0);
    }
}
