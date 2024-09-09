package br.cefetmg.lp2.gestaoentregascontroller;

import br.cefetmg.lp2.gestaoentregasdao.FuncionarioDAO;
import br.cefetmg.lp2.gestaoentregasentidades.Funcionario;
import java.util.List;

public class FuncionarioController {

    private FuncionarioDAO dao;

    public FuncionarioController() {
        dao = new FuncionarioDAO();
    }

    public boolean cadastrar(Funcionario x) {
        dao.inserir(x);
        return true;
    }

    public boolean remover(int id) {
        dao.remover(id);
        return true;
    }

    public List<Funcionario> listar() {
        return dao.listarTodos();
    }

    public List<Funcionario> pesquisar(Funcionario p) {
        return dao.pesquisarNome(p.getNome());
    }

    public List<Funcionario> pesquisarNome(String nome) {
        return dao.pesquisarNome(nome);
    }

    public Funcionario selecionar(int id) {
        return dao.selecionar(id);
    }

    public Funcionario procurarPorCPF(String cpf) {
        System.out.println("controllerrrr " + cpf);
        Funcionario funcionario = dao.pesquisaCpf(cpf);
        System.out.println("controller ok " + funcionario.getCpf());
        return funcionario;
    }

    public boolean validarSenha(Funcionario f, String senha) {
        if (f.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
}