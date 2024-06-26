/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package View;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Crud_operation.Registration$login;

/**
 *
 * @author ASUS
 */
public class Login_servlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<body onload=\"getLocation()\">");
            out.println("<script>");
            out.println("function getLocation() {");
            out.println("  if (navigator.geolocation) {");
            out.println("    navigator.geolocation.getCurrentPosition(showPosition);");
            out.println("  } else {");
            out.println("    document.getElementById('demo').innerHTML = 'Geolocation is not supported by this browser.';");
            out.println("  }");
            out.println("}");

            out.println("function showPosition(position) {");
            out.println("  var latitude = position.coords.latitude;");
            out.println("  var longitude = position.coords.longitude;");
            out.println("  document.getElementById('demo').innerHTML = 'Latitude: ' + latitude + '<br>Longitude: ' + longitude;");
  
            out.println("}");
            out.println("</script>");
               response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            String Email, password;
            int n = 0;
            Email = request.getParameter("Email");
            password = request.getParameter("Password");
            Registration$login reg = new Registration$login();
            if (reg.checkLogin(Email, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("Email", Email);
                response.sendRedirect("Home_page");
            } else {
                response.sendRedirect("Invalid_Login.html");
            }
            out.println("</body>");
            out.println("</html>");
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
