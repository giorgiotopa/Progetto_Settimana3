package it.Epicode.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "catalogo_bibliotecario")
@NamedQueries({
        @NamedQuery(name = "ElementoCatalogo.cercaPerAnnoPubblicazione", query = "SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno"),
        @NamedQuery(name = "ElementoCatalogo.cercaPerTitolo", query = "SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo"),
        @NamedQuery(name = "ElementoCatalogo.cercaElementiInPrestito", query = "SELECT e FROM ElementoCatalogo e JOIN e.prestiti p WHERE p.utente.numeroTessera = :numeroTessera")
})
public class ElementoCatalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;
    @OneToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti;

    public ElementoCatalogo() {
    }

    public ElementoCatalogo(int isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

}
