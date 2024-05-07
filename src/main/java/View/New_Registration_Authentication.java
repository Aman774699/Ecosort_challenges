/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.mail.PasswordAuthentication;
import Crud_operation.Registration$login;
/**
 *
 * @author ASUS
 */

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class New_Registration_Authentication extends HttpServlet {

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
            out.println("<title>Servlet Forgot_password_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            HttpSession mysession = request.getSession();
            String fullname,Email,Gender;
            String password,conformpassword,Mobile_No;
            fullname=request.getParameter("FULLNAME");
            mysession.setAttribute("FULLNAME", fullname);
            Email=request.getParameter("EMAIL");
            if(!Email.endsWith("@gmail.com"))
            {
                 out.println("alert('Please entered the valid email');");
            }
           mysession.setAttribute("EMAIL", Email);
            Gender=request.getParameter("GENDER");
            mysession.setAttribute("GENDER", Gender);
            Mobile_No=request.getParameter("MOBILE_NO");
            mysession.setAttribute("MOBILE_NO", Mobile_No);
            password=request.getParameter("PASSWORD");
             mysession.setAttribute("PASSWORD", password);
            conformpassword=request.getParameter("CONFIRM_PASSWORD");
            mysession.setAttribute("CONFIRM_PASSWORD", conformpassword);
            RequestDispatcher dispacher = null;
            Integer otp = 0;
            
            Registration$login Rl = new Registration$login();
            if ((Email != null || !Email.equals(" "))) {
                Random random = new Random();
                otp = random.nextInt(1234567);
                String to = Email;
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("vishwakarmaaman922@gmail.com", "zfbovlohpndugchr");
                    }
                });
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(Email));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("ECOSORT_CHALLENGES");
                    message.setText("Welcome to Ecosort Challenges Save the Environment by Joining our Recycling Team ");
                    message.setText("Your One Time Password for Creating an Account on Ecosort challenges is "+  otp.toString());
                    Transport.send(message);
                } catch (Exception e) {
                    System.out.println(e);
                }
                dispacher = request.getRequestDispatcher("Registration_Authentication_OTP.jsp");
                request.setAttribute("Message", "OTP send successfull to Your Given Email Address");
                mysession.setAttribute("OTP", otp); 
               
                dispacher.forward(request, response);
            } else {
                out.println("<script>");
                out.println("setTimeout(function() {");
                out.println("    alert('Email is not registered at our server');");
                out.println("    window.location.href = 'ForgotPassword.html';");
                out.println("}, 100);");  
                out.println("</script>");
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
