package it.prova.gestioneprodotti.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneprodotti.model.Prodotto;
import it.prova.gestioneprodotti.service.MyServiceFactory;
import it.prova.gestioneprodotti.utility.UtilityProdottoForm;

@WebServlet("/ExecuteInsertProdottoServlet")
public class ExecuteInsertProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ExecuteInsertProdottoServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estrazione input
		String nomeInputParam = request.getParameter("nome");
		String descrizioneInputParam = request.getParameter("descrizione");
		String marcaInputParam = request.getParameter("marca");
		String prezzoInputParam = request.getParameter("prezzo");
		String disponibileInputParam = request.getParameter("disponibile");
		String dataCreazioneProdottoInputParam = request.getParameter("dataCreazioneProdotto");

		Prodotto prodottoInstance = UtilityProdottoForm.createProdottoFromParams(nomeInputParam, descrizioneInputParam,
				marcaInputParam, prezzoInputParam, disponibileInputParam, dataCreazioneProdottoInputParam);

		if (!UtilityProdottoForm.validateProdottoBean(prodottoInstance)) {
			request.setAttribute("insert_prodotto_attr", prodottoInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/prodotto/insert.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getProdottoServiceInstance().insert(prodottoInstance);
			request.setAttribute("listaProdottiAttribute", MyServiceFactory.getProdottoServiceInstance().list());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un' errore. ");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("prodotto/results.jsp").forward(request, response);
	}

}
