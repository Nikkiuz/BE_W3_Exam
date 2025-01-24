package org.example;
import org.example.Classi.*;
import org.example.DAO.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		Autore autore1 = new Autore("JRR","Tolkien");
		Autore autore2 = new Autore("Isaac","Asimov");
		Autore autore3 = new Autore("Dante","Alighieri");

		Genere genere1 = new Genere("Fantasy");
		Genere genere2 = new Genere("Fantascienza");
		Genere genere3 = new Genere("Narrativa Classica");

		Libro libro1 = new Libro("Il signore degli anelli", 1960,3500,autore1,genere1);
		Libro libro2 = new Libro("Fondazione",1970,2870,autore2,genere2);
		Libro libro3 = new Libro("La Divina Commedia", 1304, 2800, autore3,genere3);

		List<Libro> listaAutore1 = new ArrayList<>();
		listaAutore1.add(libro1);

		List<Libro> listaAutore2 = new ArrayList<>();
		listaAutore2.add(libro2);

		List<Libro> listaAutore3 = new ArrayList<>();
		listaAutore1.add(libro3);

		autore1.setLibri(listaAutore1);
		autore2.setLibri(listaAutore2);
		autore3.setLibri(listaAutore3);

		Rivista rivista1 = new Rivista("Vogue",1965,80, Rivista.Periodicita.SETTIMANALE);
		Rivista rivista2 = new Rivista("L'espresso",1970,50, Rivista.Periodicita.MENSILE);
		Rivista rivista3 = new Rivista("Cavalli e Segugi",1990,45, Rivista.Periodicita.SEMESTRALE);

		Utente utente1 = new Utente("Umberto", "Tramontano",LocalDate.of(1992,04,06));
		Utente utente2 = new Utente("Valentina", "Gargiulo", LocalDate.of(2000,03,10));
		Utente utente3 = new Utente("Niccolò", "Albanese", LocalDate.of(1990,07,24));

		Prestito prestito1 = new Prestito(utente1,libro1,LocalDate.of(2025,01,24),
			LocalDate.of(2025,01,24),null);
		Prestito prestito2= new Prestito(utente1,rivista1,LocalDate.of(2025,01,24),
			LocalDate.of(2025,01,24),null);
		Prestito prestito3 = new Prestito(utente2,libro2,LocalDate.of(2024,12,31),
			LocalDate.of(2024,12,31),LocalDate.of(2025,01,23));

		PubblicazioneDao pubblicazioneDao = new PubblicazioneDaoImpl();
		pubblicazioneDao.aggiungiPubblicazione(libro1);
		pubblicazioneDao.aggiungiPubblicazione(libro2);
		pubblicazioneDao.aggiungiPubblicazione(libro3);
		pubblicazioneDao.aggiungiPubblicazione(rivista1);
		pubblicazioneDao.aggiungiPubblicazione(rivista2);
		pubblicazioneDao.aggiungiPubblicazione(rivista3);

		UtenteDao utenteDao = new UtenteDaoImpl();
		utenteDao.aggiungiUtente(utente1);
		utenteDao.aggiungiUtente(utente2);
		utenteDao.aggiungiUtente(utente3);

		PrestitoDao prestitoDao = new PrestitoDaoImpl();
		prestitoDao.aggiungiPrestito(prestito1);
		prestitoDao.aggiungiPrestito(prestito2);
		prestitoDao.aggiungiPrestito(prestito3);

	}
}