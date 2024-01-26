package it.Epicode;

import it.Epicode.dao.ElementoCatalogoDAO;
import it.Epicode.dao.LibroDAO;
import it.Epicode.dao.PrestitoDAO;
import it.Epicode.dao.UtenteDAO;
import it.Epicode.entities.ElementoCatalogo;
import it.Epicode.entities.Libro;
import it.Epicode.entities.Prestito;
import it.Epicode.entities.Utente;

import java.time.LocalDate;
import java.util.List;

public class UsaDAO {
    public static void main(String[] args) {

        ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO();
        LibroDAO libroDAO = new LibroDAO();
        UtenteDAO utenteDAO = new UtenteDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();

        Libro libro1 = new Libro();
        libro1.setAutore("Victor Hugo");
        libro1.setGenere("Classici");
        libro1.setTitolo("I Miserabili");
        libro1.setAnnoPubblicazione(1862);
        libro1.setNumeroPagine(1200);

        Libro libro2 = new Libro();
        libro2.setAutore("Alexandre Dumas");
        libro2.setGenere("Classici");
        libro2.setTitolo("Il Conte Di Montecristo");
        libro2.setAnnoPubblicazione(1846);
        libro2.setNumeroPagine(1200);

        Libro libro3 = new Libro();
        libro3.setAutore("Lev Tolstoj");
        libro3.setGenere("Classici");
        libro3.setTitolo("Guerra e Pace");
        libro3.setAnnoPubblicazione(1868);
        libro3.setNumeroPagine(1300);
//
//        elementoCatalogoDAO.save(libro3);
//        System.out.println(libro3);

        Utente utente1 = new Utente();
        utente1.setNome("Mario");
        utente1.setCognome("Rossi");
        utente1.setDataNascita(LocalDate.of(1990, 5, 15));
        utente1.setNumeroTessera("MR19900515");

//        utenteDAO.save(utente1);

        Prestito prestito1 = new Prestito();
        prestito1.setUtente(utenteDAO.getByNumeroTessera("MR19900515"));
        prestito1.setElementoPrestato(elementoCatalogoDAO.getByISBN(2));
        prestito1.setDataInizioPrestito(LocalDate.now());

        Prestito prestito2 = new Prestito();
        prestito2.setUtente(utenteDAO.getByNumeroTessera("MR19900515"));
        prestito2.setElementoPrestato(elementoCatalogoDAO.getByISBN(1));
        prestito2.setDataInizioPrestito(LocalDate.of(2023,9,10));

//        prestitoDAO.save(prestito2);

        List<ElementoCatalogo> elementiPerAnno = elementoCatalogoDAO.cercaPerAnnoPubblicazione(1862);
        System.out.println("Lista elementi cercati in base all'anno: " + elementiPerAnno);

        List<Libro> libroPerAutore = libroDAO.cercaPerAutore("Alexandre Dumas");
        System.out.println("Lista elementi cercati in base all'autore: " + libroPerAutore);

        List<ElementoCatalogo> elementoPerTitolo = elementoCatalogoDAO.cercaPerTitolo("Montecristo");
        System.out.println("Lista elementi cercati in base al titolo: " + elementoPerTitolo);

        List<ElementoCatalogo> elementoInPrestito = elementoCatalogoDAO.cercaElementiInPrestito("MR19900515");
        System.out.println("Lista elementi prestati: " + elementoInPrestito);

        List<Prestito> prestitiScaduti = prestitoDAO.cercaPrestitiScaduti();
        System.out.println("Lista prestiti scaduti: " + prestitiScaduti);

    }

}
