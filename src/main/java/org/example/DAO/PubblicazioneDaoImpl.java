package org.example.DAO;
import jakarta.persistence.EntityManager;
import org.example.Classi.EntityManagerUtil;
import org.example.Classi.Pubblicazione;
import org.example.Classi.Utente;

import java.util.List;


public class PubblicazioneDaoImpl implements PubblicazioneDao {


	@Override
	public void aggiungiPubblicazione(Pubblicazione pubblicazione) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(pubblicazione);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			em.close();
		}
	}

	@Override
	public void eliminaPubblicazione(String codiceIsbn) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			Pubblicazione pubblicazioneDaRimuovere = em.find(Pubblicazione.class, codiceIsbn);
			if (pubblicazioneDaRimuovere != null)
				em.remove(pubblicazioneDaRimuovere);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			em.close();
		}
	}

	@Override
	public Pubblicazione trovaPerIsbn(String isbn) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			Pubblicazione pubblicazioneTrovata = em.find(Pubblicazione.class, isbn);
			em.getTransaction().commit();
			return pubblicazioneTrovata;
		}
		catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		finally{
			em.close();
		}
	}

	@Override
	public List<Pubblicazione> trovaTutte() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			return em.createQuery("SELECT * FROM Utente ", Pubblicazione.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}


}