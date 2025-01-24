package org.example.Classi;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro extends Pubblicazione {

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="autore_id", nullable = false)
	private Autore autore;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "genere_id", nullable = false)
	private Genere genere;

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Libro() {

	}

	public Libro(String titolo, int annoPubblicazione, int numeroPagine, Autore autore, Genere genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}
}
