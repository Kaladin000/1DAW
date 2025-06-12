<%-- 
    Document   : llistaVaixells
    Created on : 7 may 2025, 14:46:10
    Author     : David García Valero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.proyectomaven1.Barco" %>
<%@ page import="com.mycompany.proyectomaven1.Velero" %>
<%@ page import="com.mycompany.proyectomaven1.EmbarcacionDeportiva" %>
<%@ page import="com.mycompany.proyectomaven1.YateDeLujo" %>
<!DOCTYPE html>
<html lang="ca">
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

        <h1 class="text-center">Llista de vaixells</h1>
        <table style="border: 1px solid #000; width: 100%; text-align: center;">
            <tr>
                <th>Tipus</th>
                <th>Matricula</th>
                <th>Eslora</th>
                <th>Any Fabricacio</th>
                <th>Potencia</th>
                <th>Cabines</th>
                <th>Mastelers</th>
                <th>Opcions</th>
            </tr>
            <%
                ArrayList<Barco> llista = (ArrayList<Barco>) session.getAttribute("llista");

                if (llista != null) {

                    for (int i = 0; i < llista.size(); i++) {
                        Barco vaixell = llista.get(i);
                        String tipus = "";
                        String potencia = "";
                        String cabines = "";
                        String mastelers = "";

                        if (vaixell instanceof Velero) {
                            tipus = "Veler";
                            Velero veler = (Velero) vaixell;
                            mastelers = veler.getNumeroMasteleros();
                        } else if (vaixell instanceof YateDeLujo) {
                            tipus = "Iot";
                            YateDeLujo iot = (YateDeLujo) vaixell;
                            cabines = iot.getNumCabinas();
                            potencia = iot.getPotencia();
                        } else if (vaixell instanceof EmbarcacionDeportiva) {
                            tipus = "Esportiva";
                            EmbarcacionDeportiva esportiva = (EmbarcacionDeportiva) vaixell;
                            potencia = esportiva.getPotencia();
                        }
            %>
            <tr>
                <td><%= tipus%></td>
                <td><%= vaixell.getMatricula()%></td>
                <td><%= vaixell.getEslora()%></td>
                <td><%= vaixell.getAñoFabricacion()%></td>
                <td><%= potencia%></td>
                <td><%= cabines%></td>
                <td><%= mastelers%></td>
                <td>
                    <form action="simulador.jsp" method="post">
                        <input type="hidden" name="matricula" value="<%= vaixell.getMatricula()%>">
                        <button type="submit">Simular</button>
                    </form>
                </td>
                <%
                        }
                    }
                %>

            </tr>
    </body>
</html>
