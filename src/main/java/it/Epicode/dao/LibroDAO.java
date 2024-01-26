package it.Epicode.dao;

import it.Epicode.entities.ElementoCatalogo;
import it.Epicode.entities.Libro;
import jakarta.persistence.*;

import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public LibroDAO(){
        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public Libro save(Libro e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();

        return e;
    }

    public Libro getByISBN(int isbn){
        return em.find(Libro.class,isbn);
    }

    public void delete (int isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Libro e = getByISBN(isbn);
        em.remove(e);

        et.commit();
    }

    public List<Libro> cercaPerAutore(String autore) {
        Query q= em.createNamedQuery("Libro.cercaPerAutore");
        q.setParameter("autore", autore);
        return q.getResultList();
    }
}
