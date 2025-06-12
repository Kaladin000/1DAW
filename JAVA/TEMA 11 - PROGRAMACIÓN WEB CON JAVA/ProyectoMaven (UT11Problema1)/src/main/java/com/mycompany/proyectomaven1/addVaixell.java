/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectomaven1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.Integer;
import java.lang.Double;

/**
 *
 * @author David García Valero
 */
public class addVaixell extends HttpServlet {

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
            ArrayList<Barco> l = new ArrayList<>();

            if (session.getAttribute("llista") == null) {
                l = new ArrayList<>();
                session.setAttribute("llista", l);
            } else {
                l = (ArrayList<Barco>) session.getAttribute("llista");
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addVaixell</title>");
            out.println("</head>");
            out.println("<body>");

            String tipus = request.getParameter("tipus");

            String matricula = "";
            String eslora = "";
            String anyFabricacio = "";
            boolean matriculaRepe = false;

            String potencia = "";

            String missatge = "";

            // VELER
            if (tipus.equals("veler")) {
                String mastelers = request.getParameter("mastelers");
                matricula = request.getParameter("matricula");
                eslora = request.getParameter("eslora");
                anyFabricacio = request.getParameter("anyFabricacio");

                if (l.isEmpty() == false) {

                    for (int i = 0; i < l.size(); i++) {
                        if (l.get(i).getMatricula().equals(matricula)) {
                            missatge = "ERROR. Has introducido una matrícula equivalente a otra ya existente";
                            matriculaRepe = true;
                            break;
                        }
                    }

                    if (matriculaRepe == false) {

                        if (matricula.length() > 9 || Integer.parseInt(matricula) <= 0) {
                            missatge = "ERROR. Has introducido una matricula errónea";
                        } else if (mastelers.length() > 1 || Integer.parseInt(mastelers) <= 0) {
                            missatge = "ERROR. Has introducido un num de mástiles erróneo";
                        } else if (eslora.length() > 3 || Integer.parseInt(eslora) <= 0) {
                            missatge = "ERROR. Has introducido una eslora errónea";
                        } else if (anyFabricacio.length() > 4 || Integer.parseInt(anyFabricacio) <= 0) {
                            missatge = "ERROR. Has introducido un año de fabricación erróneo";
                        } else {
                            Velero veler = new Velero(matricula, Double.parseDouble(eslora), Integer.parseInt(anyFabricacio), Double.parseDouble(mastelers));
                            l.add(veler);
                            session.setAttribute("llista", l);
                            missatge = "Vaixell inserit amb èxit";
                        }

                    }

                } else if (l.isEmpty() == true) {
                    if (matricula.length() > 9 || Integer.parseInt(matricula) <= 0) {
                        missatge = "ERROR. Has introducido una matricula errónea";
                    } else if (mastelers.length() > 1 || Integer.parseInt(mastelers) <= 0) {
                        missatge = "ERROR. Has introducido un num de mástiles erróneo";
                    } else if (eslora.length() > 3 || Integer.parseInt(eslora) <= 0) {
                        missatge = "ERROR. Has introducido una eslora errónea";
                    } else if (anyFabricacio.length() > 4 || Integer.parseInt(anyFabricacio) <= 0) {
                        missatge = "ERROR. Has introducido un año de fabricación erróneo";
                    } else {
                        Velero veler = new Velero(matricula, Double.parseDouble(eslora), Integer.parseInt(anyFabricacio), Double.parseDouble(mastelers));
                        l.add(veler);
                        session.setAttribute("llista", l);
                        missatge = "Vaixell inserit amb èxit";
                    }
                }

                // IOT
            } else if (tipus.equals("iot")) {
                String cabines = request.getParameter("cabines");
                potencia = request.getParameter("potencia");
                matricula = request.getParameter("matricula");
                eslora = request.getParameter("eslora");
                anyFabricacio = request.getParameter("anyFabricacio");

                if (l.isEmpty() == false) {

                    for (int i = 0; i < l.size(); i++) {
                        if (l.get(i).getMatricula().equals(matricula)) {
                            missatge = "ERROR. Has introducido una matrícula equivalente a otra ya existente";
                            matriculaRepe = true;
                            break;
                        }
                    }

                    if (matriculaRepe == false) {
                        if (cabines.length() > 1 || Integer.parseInt(cabines) < 0) {
                            missatge = "ERROR. Has introducido un num de cabinas erróneo";
                        } else if (potencia.length() > 3 || Integer.parseInt(potencia) <= 0) {
                            missatge = "ERROR. Has introducido una potencia errónea";
                        } else if (matricula.length() > 9 || Integer.parseInt(matricula) <= 0) {
                            missatge = "ERROR. Has introducido una matricula errónea";
                        } else if (eslora.length() > 3 || Integer.parseInt(eslora) <= 0) {
                            missatge = "ERROR. Has introducido una eslora errónea";
                        } else if (anyFabricacio.length() > 4 || Integer.parseInt(anyFabricacio) <= 0) {
                            missatge = "ERROR. Has introducido un año de fabricación erróneo";
                        } else {
                            YateDeLujo yate = new YateDeLujo(matricula, Double.parseDouble(eslora), Integer.parseInt(anyFabricacio), Integer.parseInt(potencia), Integer.parseInt(cabines));
                            l.add(yate);
                            session.setAttribute("llista", l);
                            missatge = "Vaixell inserit amb èxit";
                        }
                    }

                } else if (l.isEmpty() == true) {
                    if (cabines.length() > 1 || Integer.parseInt(cabines) < 0) {
                        missatge = "ERROR. Has introducido un num de cabinas erróneo";
                    } else if (potencia.length() > 3 || Integer.parseInt(potencia) <= 0) {
                        missatge = "ERROR. Has introducido una potencia errónea";
                    } else if (matricula.length() > 9 || Integer.parseInt(matricula) <= 0) {
                        missatge = "ERROR. Has introducido una matricula errónea";
                    } else if (eslora.length() > 3 || Integer.parseInt(eslora) <= 0) {
                        missatge = "ERROR. Has introducido una eslora errónea";
                    } else if (anyFabricacio.length() > 4 || Integer.parseInt(anyFabricacio) <= 0) {
                        missatge = "ERROR. Has introducido un año de fabricación erróneo";
                    } else {
                        YateDeLujo yate = new YateDeLujo(matricula, Double.parseDouble(eslora), Integer.parseInt(anyFabricacio), Integer.parseInt(potencia), Integer.parseInt(cabines));
                        l.add(yate);
                        session.setAttribute("llista", l);
                        missatge = "Vaixell inserit amb èxit";
                    }
                }

                // ESPORTIVA
            } else if (tipus.equals("esportiva")) {
                potencia = request.getParameter("potencia");
                matricula = request.getParameter("matricula");
                eslora = request.getParameter("eslora");
                anyFabricacio = request.getParameter("anyFabricacio");

                if (l.isEmpty() == false) {

                    for (int i = 0; i < l.size(); i++) {
                        if (l.get(i).getMatricula().equals(matricula)) {
                            missatge = "ERROR. Has introducido una matrícula equivalente a otra ya existente";
                            matriculaRepe = true;
                            break;
                        }
                    }

                    if (matriculaRepe == false) {
                        if (potencia.length() > 3 || Integer.parseInt(potencia) <= 0) {
                            missatge = "ERROR. Has introducido una potencia errónea";
                        } else if (matricula.length() > 9 || Integer.parseInt(matricula) <= 0) {
                            missatge = "ERROR. Has introducido una matricula errónea";
                        } else if (eslora.length() > 3 || Integer.parseInt(eslora) <= 0) {
                            missatge = "ERROR. Has introducido una eslora errónea";
                        } else if (anyFabricacio.length() > 4 || Integer.parseInt(anyFabricacio) <= 0) {
                            missatge = "ERROR. Has introducido un año de fabricación erróneo";
                        } else {
                            EmbarcacionDeportiva deportivo = new EmbarcacionDeportiva(matricula, Double.parseDouble(eslora), Integer.parseInt(anyFabricacio), Integer.parseInt(potencia));
                            l.add(deportivo);
                            session.setAttribute("llista", l);
                            missatge = "Vaixell inserit amb èxit";
                        }
                    }

                } else if (l.isEmpty() == true) {
                    if (potencia.length() > 3 || Integer.parseInt(potencia) <= 0) {
                        missatge = "ERROR. Has introducido una potencia errónea";
                    } else if (matricula.length() > 9 || Integer.parseInt(matricula) <= 0) {
                        missatge = "ERROR. Has introducido una matricula errónea";
                    } else if (eslora.length() > 3 || Integer.parseInt(eslora) <= 0) {
                        missatge = "ERROR. Has introducido una eslora errónea";
                    } else if (anyFabricacio.length() > 4 || Integer.parseInt(anyFabricacio) <= 0) {
                        missatge = "ERROR. Has introducido un año de fabricación erróneo";
                    } else {
                        EmbarcacionDeportiva deportivo = new EmbarcacionDeportiva(matricula, Double.parseDouble(eslora), Integer.parseInt(anyFabricacio), Integer.parseInt(potencia));
                        l.add(deportivo);
                        session.setAttribute("llista", l);
                        missatge = "Vaixell inserit amb èxit";
                    }
                }

            } else {
                missatge = "ERROR. Has introducido una embarcación errónea";
            }

            out.println("<h1>" + missatge + "</h1>");
            out.println("</body>");
            out.println("</html>");
            session.setAttribute("missatge", missatge);
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
