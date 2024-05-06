package it.prova.gestioneprodotti.service;

import java.util.List;

import it.prova.gestioneprodotti.dao.ProdottoDAO;
import it.prova.gestioneprodotti.model.Prodotto;

public interface ProdottoService {

	public List<Prodotto> list() throws Exception;

	public Prodotto findOne(Long id) throws Exception;

	public void update(Prodotto input) throws Exception;

	public void insert(Prodotto input) throws Exception;

	public void delete(Long idProdotto) throws Exception;

	public void setProdottoDao(ProdottoDAO prodottoDao);
}
