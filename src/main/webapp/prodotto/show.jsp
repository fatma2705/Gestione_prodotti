<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestioneprodotti.model.Prodotto"%>
<html lang="it" class="h-100">
	<head>
	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
	
		
		<jsp:include page="../header.jsp" />
		
		<title>Visualizza Prodotto</title>
	</head>
	<body class="d-flex flex-column h-100">
	
		<jsp:include page="../navbar.jsp"></jsp:include>
		
		<main class="flex-shrink-0">
			  <div class="container">
			  	<h5>Visualizza dettaglio</h5>
			  	</div>
			  	<% Prodotto prodottoInPagina = (Prodotto)request.getAttribute("visualizza_prodotto_attr"); %>
			  <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome:</dt>
							  <dd class="col-sm-9"><%=prodottoInPagina.getNome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Descrizione:</dt>
							  <dd class="col-sm-9"><%=prodottoInPagina.getDescrizione() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Marca:</dt>
							  <dd class="col-sm-9"><%=prodottoInPagina.getMarca() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9"><%=prodottoInPagina.getPrezzo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Disponibile:</dt>
							  <dd class="col-sm-9"><%=prodottoInPagina.isDisponibile() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data Creazione Prodotto:</dt>
							  <dd class="col-sm-9"><%=prodottoInPagina.getDataCreazioneProdotto()!=null? prodottoInPagina.getDataCreazioneProdotto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ListProdottiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>