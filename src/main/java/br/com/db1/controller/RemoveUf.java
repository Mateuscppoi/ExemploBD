package br.com.db1.controller;

import br.com.db1.model.Uf;
import java.util.List;
import javax.persistence.Query;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ManagedBean
public class RemoveUf {

    private Uf uf;
    private String nome;
    private Integer linha;

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public void retornaLinha() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery(nome);
        linha = query.getFirstResult();

        factory.close();
    }

    public String retornaUf() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
        EntityManager manager = factory.createEntityManager();

        retornaLinha();
        Uf uf = manager.find(Uf.class,linha );
        manager.getTransaction().begin();
        manager.remove(uf);
        manager.getTransaction().commit();

        factory.close();

        return "ola";
    }
}
