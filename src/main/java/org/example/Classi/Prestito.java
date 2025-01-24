package org.example.Classi;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestito")
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID uniqueId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pubblicazione_id", nullable = false)
	private Pubblicazione pubblicazione;

	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista;
	private LocalDate dataRestituzioneEffettiva;

	@PrePersist
	protected void onCreate(){
		dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Pubblicazione getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	public Prestito(){}

	public Prestito(Utente utente, Pubblicazione pubblicazione, LocalDate dataInizioPrestito,
	                LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
		this.utente = utente;
		this.pubblicazione = pubblicazione;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
}
