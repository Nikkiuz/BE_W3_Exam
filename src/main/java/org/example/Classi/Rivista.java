package org.example.Classi;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
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

	public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}
}
