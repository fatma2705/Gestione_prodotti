package it.prova.gestioneprodotti.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodotti.service.MyServiceFactory;

@WebServlet("/PrepareDeleteProdottoServlet")
public class PrepareDeleteProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProdottoParam = request.getParameter("idProdotto");

		if (!NumberUtils.isCreatable(idProdottoParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un  errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_prodotto_attr",
					MyServiceFactory.getProdottoServiceInstance().findOne(Long.parseLong(idProdottoParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/prodotto/delete.jsp").forward(request, response);
	}

}
