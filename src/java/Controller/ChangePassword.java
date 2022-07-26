/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Vostro 5502
 */
public class ChangePassword extends HttpServlet {
    DAO dao;
    public void init(){
        dao=new DAO();
    }

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassword at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        HttpSession ses=request.getSession();
        Account acc=(Account)ses.getAttribute("account");
        request.setAttribute("DAO", dao);
        request.setAttribute("accUpd", acc);
        if (acc.getRole().equals("admin")) request.setAttribute("role", 0);
        else if (acc.getRole().equals("user")) request.setAttribute("role", 1);
        else request.setAttribute("role", 2);
        request.getRequestDispatcher("Main/ChangePassword.jsp").forward(request, response);
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
        String newPass=request.getParameter("nPass");
        String reNewPass=request.getParameter("rPass");
        String oPass=request.getParameter("oPass");
        HttpSession ses=request.getSession();
        Account acc=(Account)ses.getAttribute("account");
        request.setAttribute("DAO", dao);
        request.setAttribute("accUpd", acc);
        if (acc.getRole().equals("admin")) request.setAttribute("role", 0);
        else if (acc.getRole().equals("user")) request.setAttribute("role", 1);
        else request.setAttribute("role", 2);
        String err="";
        if (!acc.getPassword().equals(oPass)){
            err="Old password is incorrect";
        }
        if (!newPass.equals(reNewPass)){
            err="New password and re-enter new password must be the same!";
        }
        if (newPass.equals(reNewPass) && oPass.equals(acc.getPassword())){
            dao.updatePassword(acc.getId(), newPass);
            err="Update successfully!";
        }request.setAttribute("err", err);
        request.getRequestDispatcher("Main/UpdateAcc.jsp").forward(request, response);
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
