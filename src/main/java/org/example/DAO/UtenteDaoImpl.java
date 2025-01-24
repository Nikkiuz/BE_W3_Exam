package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.Classi.EntityManagerUtil;
import org.example.Classi.Utente;

import java.util.List;


public class UtenteDaoImpl implements UtenteDao{

	@Override
	public void aggiungiUtente(Utente utente) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(utente);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminaUtente(String numeroTessera) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Utente utenteDaRimuovere = em.find(Utente.class, numeroTessera);
			if (utenteDaRimuovere != null)
				em.remove(utenteDaRimuovere);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Utente trovaUtentePerTessera(String numeroTessera) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			return em.find(Utente.class, numeroTessera);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
	@Override
	public List<Utente> trovaTuttiUtenti() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			return em.createQuery("SELECT * FROM Utente ", Utente.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}