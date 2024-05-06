package it.prova.gestioneprodotti.service;

import it.prova.gestioneprodotti.dao.ProdottoDAO;
import it.prova.gestioneprodotti.dao.ProdottoDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static ProdottoService PRODOTTO_SERVICE_INSTANCE = null;
	private static ProdottoDAO PRODOTTODAO_INSTANCE = null;

	public static ProdottoService getProdottoServiceInstance() {
		if (PRODOTTO_SERVICE_INSTANCE == null)
			PRODOTTO_SERVICE_INSTANCE = new ProdottoServiceImpl();

		if (PRODOTTODAO_INSTANCE == null)
			PRODOTTODAO_INSTANCE = new ProdottoDAOImpl();

		PRODOTTO_SERVICE_INSTANCE.setProdottoDao(PRODOTTODAO_INSTANCE);

		return PRODOTTO_SERVICE_INSTANCE;
	}

}
