/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.examenut11dgv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author examenprog
 */
@WebServlet(name = "AddReserva", urlPatterns = {"/AddReserva"})
public class AddReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String nombre = request.getParameter("nombreCliente");
            String tipo = request.getParameter("tipoHabitacion");
            String noches = request.getParameter("numNoches");
            String huespedes = request.getParameter("numHuespedes");
            String precioNoche = request.getParameter("precioPorNoche");
            String fecha = request.getParameter("fechaEntrada");
            
            if (Integer.parseInt(noches) > 0 && Integer.parseInt(huespedes) > 0 && Double.parseDouble(precioNoche) > 0) {
                Reserva reserva = new Reserva(nombre,tipo,Integer.parseInt(noches),Integer.parseInt(huespedes),Double.parseDouble(precioNoche),fecha);
                if (session.getAttribute("reservas") == null) {
                    ArrayList<Reserva> reservas = new ArrayList<>();
                    reservas.add(reserva);
                    session.setAttribute("reservas", reservas);
                    request.getRequestDispatcher("reservas.jsp").forward(request, response);
                } else {
                    ArrayList<Reserva> reservas = (ArrayList<Reserva>) session.getAttribute("reservas");
                    reservas.add(reserva);
                    session.setAttribute("reservas", reservas);
                    request.getRequestDispatcher("reservas.jsp").forward(request, response);
                }
            } else {
                String mensaje = "Has introducido un número erróneo en las noches, huespedes o precio el por noche";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("error.html").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
