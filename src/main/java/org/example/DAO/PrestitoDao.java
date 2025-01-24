package org.example.DAO;

import org.example.Classi.Prestito;

import java.util.List;

public interface PrestitoDao {
	void aggiungiPrestito(Prestito prestito);
	Prestito trovaPrestitoPerID(Long id);
	List<Prestito> trovaPrestitiPerUtente(String numeroTessera);
	void eliminaPrestito(Long id);

}
