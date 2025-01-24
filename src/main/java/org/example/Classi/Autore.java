package org.example.Classi;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID uniqueId;
	private String nome;
	private String cognome;

	@OneToMany(mappedBy = "autore")
	private List<Libro> libri;

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

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	public Autore(){}

	public Autore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
}
