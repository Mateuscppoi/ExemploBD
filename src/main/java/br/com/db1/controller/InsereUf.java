package br.com.db1.controller;


import br.com.db1.model.Uf;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ManagedBean
public class InsereUf {

    private Uf uf;
    private String nome;

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

    public String retornaUf() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
        EntityManager manager = factory.createEntityManager();

        Uf uf = new Uf();
        uf.setNome(nome);
        manager.getTransaction().begin();
        manager.persist(uf);
        manager.getTransaction().commit();

        factory.close();

        return "completado";
    }



}
