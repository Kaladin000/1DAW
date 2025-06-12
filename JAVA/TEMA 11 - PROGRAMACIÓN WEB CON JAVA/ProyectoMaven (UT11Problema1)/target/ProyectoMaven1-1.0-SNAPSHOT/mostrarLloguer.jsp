<%-- 
    Document   : mostrarLloguer
    Created on : 7 may 2025, 14:47:07
    Author     : David García Valero
--%>

<%@page import="com.mycompany.proyectomaven1.Alquiler"%>
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
        <% Alquiler lloguer = (Alquiler) session.getAttribute("lloguer");
           String missatge = (String) session.getAttribute("missatge"); 
        %>
        <h1 class="text-center">Resultat del simulador</h1>
        <p align="center">Nom del client: <%= lloguer.getNombre() %></p>
        <p align="center">DNI del client: <%= lloguer.getDni() %></p>
        <p align="center">Dies d'ocupació: <%= lloguer.getDias() %></p>
        <p align="center">Posició d'amarratge: <%= lloguer.getPosicion() %></p>
        <p align="center">Dades del vaixell: <%= lloguer.tipoBarco.toString() %></p>
        <p align="center">Factor vaixell: <%= lloguer.tipoBarco.calcularFactorBarco() %></p>
        <br>
        <p align="center">TOTAL A PAGAR: <%= lloguer.getPreu() %></p>
    </body>
</html>
