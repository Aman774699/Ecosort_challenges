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
import Crud_operation.Edit_profile$uploadimage;
import com.entity.GetSet_Edit_Profile;
/**
 *
 * @author ASUS
 */
public class Get_Nearest_Recycling_center extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Get_Nearest_Recycling_center</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session=request.getSession();
            String email=session.getAttribute("Email").toString();
            System.out.println(email);
            out.println(email);
            Edit_profile$uploadimage epu=new Edit_profile$uploadimage();
            GetSet_Edit_Profile GEP=new GetSet_Edit_Profile();
            GEP=epu.fetchdata(email);
            out.println(GEP.getLocation());
            String queries="Recycling Center Near"+GEP.getLocation();
            if(GEP.getLocation()==null)
            {
                queries="Recycling Center Near my current location";
            }
            String url="https://www.google.com/maps/search/?api=1&query="+ queries;
            response.sendRedirect(url);
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
