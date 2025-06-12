<%-- 
    Document   : simulador
    Created on : 7 may 2025, 14:46:35
    Author     : David García Valero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulari nou vaixell</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <style>
            input,select{
                margin-bottom: 1em;
            }
        </style>
    </head>
    <body onload="canviarInputs()">
        <nav class="navbar navbar-light bg-light justify-content-end">
            <ul class="nav justify-content-end ">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.html">Alta de vaixells</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="llistaVaixells.jsp">Llista de vaixells</a>
                </li>
            </ul>
        </nav>
        <% String matricula = request.getParameter("matricula"); 
           session.setAttribute("matricula", matricula);
        %>
        <h1 class="text-center">Simulador vaixell <%= matricula %></h1>
        <form style="width:50%; min-width: 450px; margin: 0 auto;" method="post" action="calcularLloguer">
            <label for="nom" class="form-label">Nom: </label>
            <input class="form-control" type="text" name="nom" id="nom" required="required" placeholder="David García"/>
            <label for="dni" class="form-label">DNI: </label>
            <input class="form-control" type="text" name="dni" id="dni" required="required" placeholder="42612344E"/>
            <label for="dies" class="form-label">Dies d'ocupació: </label>
            <input class="form-control" type="text" name="dies" id="dies" required="required" placeholder="5"/>
            <label for="tipus" class="form-label">Posició d'amarratge: </label>
            <input class="form-control" type="text" name="posicio" id="posicio" required="required" placeholder="32"/>
            <input class="btn btn-primary" type="submit" value="Simular" />
        </form>
    </body>
</html>
