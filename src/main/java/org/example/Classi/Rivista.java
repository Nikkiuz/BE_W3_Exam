package org.example.Classi;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends Pubblicazione {

	public enum Periodicita {
		SETTIMANALE, MENSILE, SEMESTRALE
	}

	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	public Rivista(){}

	public Rivista(String titolo, int anno_pubblicazione, int numero_pagine, Periodicita periodicita) {
		super(titolo, anno_pubblicazione, numero_pagine);
		this.periodicita = periodicita;
	}
}
