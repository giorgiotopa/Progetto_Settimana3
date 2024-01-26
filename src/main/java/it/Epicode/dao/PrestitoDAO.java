package it.Epicode.dao;

import it.Epicode.entities.ElementoCatalogo;
import it.Epicode.entities.Prestito;
import jakarta.persistence.*;

import java.util.List;

public class PrestitoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PrestitoDAO(){
        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public Prestito save(Prestito e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();

        return e;
    }

    public Prestito getById(Long id){
        return em.find(Prestito.class,id);
    }

    public void delete (Long id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prestito e = getById(id);
        em.remove(e);

        et.commit();
    }
    public List<Prestito> cercaPrestitiScaduti() {
        Query q = em.createNamedQuery("Prestito.cercaPrestitiScaduti");
        return q.getResultList();
    }

}
