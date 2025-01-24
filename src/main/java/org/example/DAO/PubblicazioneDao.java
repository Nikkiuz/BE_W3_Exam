package org.example.DAO;

import org.example.Classi.Pubblicazione;

import java.util.List;

public interface PubblicazioneDao {
	void aggiungiPubblicazione(Pubblicazione pubblicazione);
	Pubblicazione trovaPerIsbn(String codiceIsbn);
	List<Pubblicazione> trovaTutte();
	void eliminaPubblicazione(String codiceIsbn);
}