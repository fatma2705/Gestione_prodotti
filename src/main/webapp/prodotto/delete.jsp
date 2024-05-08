<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestioneprodotti.model.Prodotto"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Prodotto</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Vuoi eliminare questo prodotto?</h5>
					    </div>
					     <% Prodotto prodottoInPagina = (Prodotto)request.getAttribute("visualizza_prodotto_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
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
					        
					        <form action="ExecuteDeleteProdottoServlet" method="post">
					       		 <a href="ListProdottiServlet" class='btn btn-outline-secondary' style='width:80px'>
					        	    <i class='fa fa-chevron-left'></i> Back
					       		 </a>
					       		 <input type="hidden" name="idProdottoToRemove" value="<%=prodottoInPagina.getId()%>">
					        	<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					        	
					        </form>
					        
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