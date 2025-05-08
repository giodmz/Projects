package com.jpa1st.application;


import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    public static void main(String[] args) throws Exception {

        // id null para o próprio banco de dados atribuir um ID automaticamente
        // Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
        // Pessoa p2 = new Pessoa(null, "Maria", "maria@gmail.com");
        // Pessoa p3 = new Pessoa(null, "Astarion", "astarion@gmail.com");



        // instanciando o EntityManager e EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); // persistence unit -> persistence.xml
        EntityManager em = emf.createEntityManager();

        // getTransaction().begin() e getTransaction().commit() para iniciar e confirmar respectivamente uma transação com o banco de dados 
        em.getTransaction().begin();
        
        
        // pegar o objeto e salvar no banco de dados
        // em.persist(p1);
        // em.persist(p2);
        // em.persist(p3);

        // buscar no banco de dados
        Pessoa p = em.find(Pessoa.class, 2);

        // impossível remover p2, já que ele não está monitorado
        // Pessoa p2 = new Pessoa(2, null, null);
        em.remove(p);
        
        em.getTransaction().commit();

        System.out.println(p);
        System.out.println("Feito!");

        em.close();
        emf.close();

    }
}
