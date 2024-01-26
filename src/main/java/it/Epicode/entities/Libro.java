package it.Epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="libri")
@NamedQuery(name = "Libro.cercaPerAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends ElementoCatalogo{
    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(int isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

}
