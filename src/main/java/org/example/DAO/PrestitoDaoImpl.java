package org.example.DAO;
import jakarta.persistence.EntityManager;
import org.example.Classi.EntityManagerUtil;
import org.example.Classi.Prestito;

import java.util.List;

public class PrestitoDaoImpl implements PrestitoDao {

	@Override
	public void aggiungiPrestito(Prestito prestito) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(prestito);
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
	public Prestito trovaPrestitoPerID(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Prestito prestitoTrovato = em.find(Prestito.class, id);
			em.getTransaction().commit();
			return prestitoTrovato;
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminaPrestito(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Prestito prestitoDaRimuovere = em.find(Prestito.class, id);
			if (prestitoDaRimuovere != null)
				em.remove(prestitoDaRimuovere);
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
	public List<Prestito> trovaPrestitiPerUtente(String numeroTessera) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			return em.createQuery("SELECT p FROM Prestito p", Prestito.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
}