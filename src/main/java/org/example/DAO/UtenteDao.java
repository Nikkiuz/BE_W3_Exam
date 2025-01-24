package org.example.DAO;

import org.example.Classi.Utente;

import java.util.List;

public interface UtenteDao {
	void aggiungiUtente(Utente utente);
	Utente trovaUtentePerTessera(String numeroTessera);
	List<Utente> trovaTuttiUtenti();
	void eliminaUtente(String numeroTessera);
}
