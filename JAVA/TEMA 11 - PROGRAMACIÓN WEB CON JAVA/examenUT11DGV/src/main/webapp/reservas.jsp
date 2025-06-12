<%-- 
    Document   : reservas
    Created on : 2 jun 2025, 19:02:38
    Author     : examenprog
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.examenut11dgv.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Hotel Vintage - Reservas Realizadas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Special+Elite&display=swap');
        body {
            background: linear-gradient(135deg, #fdf6e3 0%, #e0c3fc 100%);
            font-family: 'Special Elite', 'Courier New', Courier, monospace;
            color: #4B3F2B;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 900px;
            margin: 48px auto;
            background: #fffbe6;
            border: 3px solid #bfa05a;
            border-radius: 16px;
            box-shadow: 0 8px 32px #bfa05a55, 0 0 0 8px #fffbe6;
            padding: 32px 28px 24px 28px;
            position: relative;
        }
        .container:before {
            content: "";
            position: absolute;
            top: -12px; left: 32px; right: 32px;
            height: 8px;
            background: repeating-linear-gradient(
                90deg, #bfa05a, #bfa05a 8px, #fffbe6 8px, #fffbe6 16px
            );
            border-radius: 4px 4px 0 0;
        }
        .container:after {
            content: "";
            position: absolute;
            bottom: -12px; left: 32px; right: 32px;
            height: 8px;
            background: repeating-linear-gradient(
                90deg, #bfa05a, #bfa05a 8px, #fffbe6 8px, #fffbe6 16px
            );
            border-radius: 0 0 4px 4px;
        }
        h1 {
            font-family: 'Special Elite', 'Courier New', Courier, monospace;
            font-size: 2.3rem;
            text-align: center;
            color: #bfa05a;
            margin-bottom: 18px;
            letter-spacing: 2px;
            text-shadow: 1px 1px 0 #fffbe6, 2px 2px 0 #bfa05a44;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 18px;
            font-size: 1rem;
            box-shadow: 0 2px 8px #bfa05a44;
        }
        th, td {
            border: 2px solid #bfa05a;
            padding: 10px 8px;
            text-align: center;
        }
        th {
            background: #ffefc2;
            color: #bfa05a;
            font-size: 1.05rem;
            letter-spacing: 1px;
        }
        tr:nth-child(even) {
            background: #fffbe6;
        }
        tr:hover {
            background: #ffe1a8;
        }
        .volver {
            display: block;
            width: 180px;
            margin: 28px auto 0 auto;
            background: linear-gradient(90deg, #ff8c42 0%, #bfa05a 100%);
            color: #fffbe6;
            font-family: 'Special Elite', 'Courier New', Courier, monospace;
            font-size: 1.1rem;
            font-weight: bold;
            border: 2px solid #bfa05a;
            border-radius: 8px;
            padding: 10px 0;
            cursor: pointer;
            box-shadow: 0 2px 0 #bfa05a66;
            letter-spacing: 2px;
            text-align: center;
            text-decoration: none;
            transition: background 0.2s, color 0.2s;
        }
        .volver:hover {
            background: linear-gradient(90deg, #bfa05a 0%, #ff8c42 100%);
            color: #4B3F2B;
        }
        @media (max-width: 700px) {
            .container {
                padding: 12px 2px 10px 2px;
                max-width: 99vw;
            }
            .container:before,
            .container:after {
                left: 8px; right: 8px;
            }
            th, td {
                font-size: 0.95rem;
                padding: 7px 3px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Reservas Realizadas</h1>
        <table>
            <thead>
                <%
                HttpSession session1 = request.getSession();
                ArrayList<Reserva> reservas1 = (ArrayList<Reserva>) session.getAttribute("reservas");
                for (int i = 0; i < reservas1.size(); i++) {
                %>
                <tr>
                    <th>Cliente</th>
                    <th>Tipo Habitación</th>
                    <th>Noches</th>
                    <th>Huéspedes</th>
                    <th>Precio/Noche (€)</th>
                    <th>Fecha Entrada</th>
                    <th>Total (€)</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= reservas1.get(i).nombre %></td>
                    <td><%= reservas1.get(i).tipo %></td>
                    <td><%= reservas1.get(i).noches %></td>
                    <td><%= reservas1.get(i).huespedes %></td>
                    <td><%= reservas1.get(i).precioNoche %></td>
                    <td><%= reservas1.get(i).fecha %></td>
                    <td><%= reservas1.get(i).getPrecioTotal() %></td>
                </tr>
                    <% } %>
            </tbody>
        </table>
        <a href="index.html" class="volver">Nueva Reserva</a>
    </div>
</body>
</html>
