package it.Epicode.dao;

import it.Epicode.entities.ElementoCatalogo;
import it.Epicode.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UtenteDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UtenteDAO(){
        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public Utente save(Utente e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();

        return e;
    }

    public Utente getByNumeroTessera(String numeroTessera){
        return em.find(Utente.class,numeroTessera);
    }

    public void delete (String numeroTessera) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Utente e = getByNumeroTessera(numeroTessera);
        em.remove(e);

        et.commit();
    }

}
