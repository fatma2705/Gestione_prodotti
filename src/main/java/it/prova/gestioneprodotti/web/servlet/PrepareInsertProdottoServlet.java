package it.prova.gestioneprodotti.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneprodotti.model.Prodotto;

@WebServlet("/PrepareInsertProdottoServlet")
public class PrepareInsertProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
				request.setAttribute("insert_prodotto_attr", new Prodotto());
				request.getRequestDispatcher("/prodotto/insert.jsp").forward(request, response);

	}

}
