package org.example.Classi;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Genere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID uniqueID;
	private String tipo;

	@OneToMany(mappedBy = "genere")
	private List<Libro> libri;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	public Genere(){}

	public Genere(String tipo) {
		this.tipo = tipo;
	}
}
