/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Vostro 5502
 */
public class Confirm_Phone extends HttpServlet {

      DAO dao;
        public void init(){
            dao=new DAO();
        }

    String confirm= String.format("%06d", new Random().nextInt(999999));
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.setAttribute("confirm", confirm);
        request.setAttribute("forgot", request.getAttribute("forgot"));
        request.getRequestDispatcher("Signup/Confirm.jsp").forward(request, response);
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
        //processRequest(request, response);
        String code=request.getParameter("code");
        if (confirm.equals(code)){
            HttpSession ses=request.getSession();
            Account acc=(Account) ses.getAttribute("account");
            dao.updateStatus(acc.getId(), 1);
            if (ses.getAttribute("forgot")!=null){
                String newpass=UUID.randomUUID().toString().substring(0,8);
                dao.updatePassword(acc.getId(), newpass);
                request.setAttribute("newPass", newpass);
                request.getRequestDispatcher("Main/ChangePassword.jsp").forward(request, response);
            }
            if (acc.getRole().equals("user")){
                response.sendRedirect("Home");
            }else if (acc.getRole().equals("admin")){
                response.sendRedirect("ManageAcc");
            }else response.sendRedirect("MyTicket");
            
        }else{
            response.sendRedirect("Confirm_Phone");
        }
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
