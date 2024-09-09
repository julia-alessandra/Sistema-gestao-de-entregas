package br.cefetmg.lp2.gestaoentregasdao;

import br.cefetmg.lp2.gestaoentregasentidades.Empresa;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

public class EmpresaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmpresaDAO() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void inserir(Empresa empresa) {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
    }

    public Empresa ler(int id) {
        return em.find(Empresa.class, id);
    }

    public void atualizar(Empresa empresa) {
        em.getTransaction().begin();
        em.merge(empresa);
        em.getTransaction().commit();
    }

    public void remover(int id) {
        em.getTransaction().begin();
        Empresa empresa = em.find(Empresa.class, id);
        if (empresa != null) {
            em.remove(empresa);
        }
        em.getTransaction().commit();
    }

    public List<Empresa> listarTodos() {
        return em.createQuery("SELECT e FROM Empresa e", Empresa.class).getResultList();
    }

    public Empresa selecionar(int id) {
        em.getTransaction().begin();
        Empresa x = em.find(Empresa.class, id);
        return x;
    }

    public List<Empresa> pesquisarNome(String nome) {
        var cb = em.getCriteriaBuilder();
        CriteriaQuery<Empresa> criteria = cb.createQuery(Empresa.class);
        var root = criteria.from(Empresa.class);
        criteria.select(root).where(cb.like(root.get("nome"), "%" + nome + "%"));
        List<Empresa> lista = em.createQuery(criteria).getResultList();
        return lista;
    }

    public Empresa pesquisaId(int idEmpresa) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Empresa e WHERE e.id = :id");
        query.setParameter("id", idEmpresa);
        List<Empresa> pesquisa = query.getResultList();
        return pesquisa.isEmpty() ? null : pesquisa.get(0);
    }
}