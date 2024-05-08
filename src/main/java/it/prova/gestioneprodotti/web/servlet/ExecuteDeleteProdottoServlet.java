package it.prova.gestioneprodotti.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodotti.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteProdottoServlet")
public class ExecuteDeleteProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdProdottoToRemove = request.getParameter("idProdottoToRemove");
		Long idProdottoToRemove = Long.parseLong(parametroIdProdottoToRemove);
		if (!NumberUtils.isCreatable(parametroIdProdottoToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getProdottoServiceInstance().delete(idProdottoToRemove);
			request.setAttribute("listProdottiAttribute", MyServiceFactory.getProdottoServiceInstance().list());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore");
			request.getRequestDispatcher("/prodotto/errorPage.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/prodotto/results.jsp").forward(request, response);
	}

}
