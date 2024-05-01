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
import com.entity.Getset_Reg;
import View.New_Registration;
import Crud_operation.Registration$login;
import Crud_operation.Edit_profile$uploadimage;
import com.entity.GetSet_Edit_Profile;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ASUS
 */
public class New_Registration extends HttpServlet {

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
            out.println("<title>Servlet For_Reistration</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session=request.getSession();
            String fullname,Email,Gender;
            String password,conformpassword,Mobile_No;
            fullname=session.getAttribute("FULLNAME").toString();
            Email=session.getAttribute("EMAIL").toString();
            out.println(Email);
             Gender=session.getAttribute("GENDER").toString();
            Mobile_No=session.getAttribute("MOBILE_NO").toString();
            password=session.getAttribute("PASSWORD").toString();
            conformpassword=session.getAttribute("CONFIRM_PASSWORD").toString();
            Getset_Reg reg=new Getset_Reg();
            reg.setFullname(fullname);
            reg.setEmail(Email);
            reg.setGender(Gender);
            reg.setMobile_No(Mobile_No);
            reg.setPassword(password);
            reg.setConform_password(conformpassword);
            Registration$login Done=new Registration$login();
            Edit_profile$uploadimage EPU=new Edit_profile$uploadimage();
            GetSet_Edit_Profile GSEP=new GetSet_Edit_Profile();
            GSEP.setUsername(fullname);
            GSEP.setEmail(Email);
            GSEP.setMobileNO(Mobile_No);
            GSEP.setFilePath("C:\\Users\\ASUS\\OneDrive\\Desktop\\Default_profile.png");
            if(Done.newRegistration(reg) )
            {
                Done.newLogin(reg);
                EPU.insertdata(GSEP);
                response.sendRedirect("Registration_Successfull.html");
            }
            else
               response.sendRedirect("Invalid_Registration_Process.html");
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
