package org.example.Classi;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroTessera;

	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;

	@OneToMany(mappedBy = "utente")
	private List<Prestito> prestiti;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	public Utente(){}

	public Utente(String nome, String cognome, LocalDate dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}
}
