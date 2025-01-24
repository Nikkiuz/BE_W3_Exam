package org.example.Classi;

import jakarta.persistence.*;

@Entity
@Table(name = "libri")
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

	public Libro(String titolo, int anno_pubblicazione, int numero_pagine, Autore autore, Genere genere) {
		super(titolo, anno_pubblicazione, numero_pagine);
		this.autore = autore;
		this.genere = genere;
	}
}
