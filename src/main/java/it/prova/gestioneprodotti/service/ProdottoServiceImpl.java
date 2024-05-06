package it.prova.gestioneprodotti.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneprodotti.dao.ProdottoDAO;
import it.prova.gestioneprodotti.model.Prodotto;
import it.prova.gestioneprodotti.web.listener.LocalEntityManagerFactoryListener;

public class ProdottoServiceImpl implements ProdottoService {

	private ProdottoDAO prodottoDao;

	@Override
	public void setProdottoDao(ProdottoDAO prodottoDao) {
		this.prodottoDao = prodottoDao;

	}

	@Override
	public List<Prodotto> list() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			prodottoDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return prodottoDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Prodotto findOne(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			prodottoDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return prodottoDao.findOne(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Prodotto prodotto) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			prodottoDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			prodottoDao.update(prodotto);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void insert(Prodotto prodotto) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			prodottoDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			prodottoDao.insert(prodotto);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void delete(Long idProdotto) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			prodottoDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			prodottoDao.delete(prodottoDao.findOne(idProdotto));
			;

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
