package org.example.Classi;

import jakarta.persistence.*;

@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pubblicazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codice_isbn;
	private String titolo;
	private int anno_pubblicazione;
	private int numero_pagine;

	public String getCodiceIsbn() {
		return codice_isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return anno_pubblicazione;
	}

	public void setAnnoPubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}

	public int getNumeroPagine() {
		return numero_pagine;
	}

	public void setNumeroPagine(int numero_pagine) {
		this.numero_pagine = numero_pagine;
	}

	public Pubblicazione(){}

	public Pubblicazione(String titolo, int anno_pubblicazione, int numero_pagine) {
		this.titolo = titolo;
		this.anno_pubblicazione = anno_pubblicazione;
		this.numero_pagine = numero_pagine;
	}
}


