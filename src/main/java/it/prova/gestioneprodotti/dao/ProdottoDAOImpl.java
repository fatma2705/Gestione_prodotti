package it.prova.gestioneprodotti.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneprodotti.model.Prodotto;

public class ProdottoDAOImpl implements ProdottoDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Prodotto> list() throws Exception {
		return entityManager.createQuery("from Prodotto", Prodotto.class).getResultList();
	}

	@Override
	public Prodotto findOne(Long id) throws Exception {
		return entityManager.find(Prodotto.class, id);
	}

	@Override
	public void update(Prodotto prodotto) throws Exception {
		entityManager.merge(prodotto);

	}

	@Override
	public void insert(Prodotto prodotto) throws Exception {
		entityManager.persist(prodotto);

	}

	@Override
	public void delete(Prodotto prodotto) throws Exception {
		entityManager.remove(entityManager.merge(prodotto));

	}

}
