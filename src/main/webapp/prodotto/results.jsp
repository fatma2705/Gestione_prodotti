<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestioneprodotti.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="it" class="h-100" >
<head>
    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />
    <title>Lista Elementi</title>
</head>
<body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <jsp:include page="../navbar.jsp"></jsp:include>
    <!-- Begin page content -->
    <main class="flex-shrink-0">
        <div class="container">
            <div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none':'' }" role="alert">
                ${successMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
            </div>
            <div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
                Esempio di operazione fallita!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
            </div>
            <div class="alert alert-info alert-dismissible fade show d-none" role="alert">
                Aggiungere d-none nelle class per non far apparire
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
            </div>
            <div class='card'>
                <div class='card-header'>
                    <h5>Lista dei risultati</h5>
                </div>
                <div class='card-body'>
                    <a class="btn btn-primary " href="PrepareInsertProdottoServlet">Add New</a>
                    <div class='table-responsive'>
                        <table class='table table-striped'>
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nome</th>
                                    <th>Descrizione</th>
                                    <th>Marca</th>
                                    <th>Prezzo</th>
                                    <th>Disponibile</th>
                                    <th>Data Creazione Prodotto</th>
                                    <th>Azioni</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                List<Prodotto> listaProdotti = (List<Prodotto>) request.getAttribute("listaProdottiAttribute");
                                if (listaProdotti != null) {
                                    for (Prodotto item : listaProdotti) {
                                %>
                                <tr>
                                    <td><%=item.getId() %></td>
                                    <td><%=item.getNome() %></td>
                                    <td><%=item.getDescrizione() %></td>
                                    <td><%=item.getMarca() %></td>
                                    <td><%=item.getPrezzo() %></td>
                                    <td><%=item.isDisponibile() %></td>
                                    <td><%=item.getDataCreazioneProdotto()!=null? item.getDataCreazioneProdotto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):"N.D."%></td>
                                    <td>
                                        <a class="btn btn-sm btn-outline-secondary" href="ExecuteVisualizzaProdottoServlet?idProdotto=<%=item.getId() %>">Visualizza</a>
                                        <a class="btn btn-sm btn-outline-primary ml-2 mr-2" href="PrepareEditProdottoServlet?idProdotto=<%=item.getId() %>">Edit</a>
                                        <a class="btn btn-outline-danger btn-sm" href="PrepareDeleteProdottoServlet?idProdotto=<%=item.getId() %>">Delete</a>
                                    </td>
                                </tr>
                                <% 
                                    }
                                } else {
                                %>
                                <tr>
                                    <td colspan="8">La lista dei prodotti è vuota o non è stata correttamente inizializzata.</td>
                                </tr>
                                <% 
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Footer -->
    <jsp:include page="../footer.jsp" />
    <!-- Modal conferma delete -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Conferma Operazione</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Continuare con l'operazione?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annulla</button>
                    <button type="button" class="btn btn-primary">Continua</button>
                </div>
            </div>
        </div>
    </div>
    <!-- End Modal conferma delete -->
</body>
</html>
