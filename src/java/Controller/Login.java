/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Vostro 5502
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+request.getAttribute("articleId")+"</h1>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("errPhone", request.getAttribute("errPhone"));
        request.getRequestDispatcher("Login/Login.jsp").forward(request, response);
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
        String phone=request.getParameter("phone");
        String pass=request.getParameter("password");
        ArrayList<Account> listAccount=dao.getAccount();
        Boolean check=false;
        HttpSession ses=request.getSession();
        
        
        for (Account account : listAccount) {
            if (account.getPhone().equals(phone)
                    && account.getPassword().equals(pass)
                    && account.isStatus()){
                check=true;
                ses.setAttribute("account", account);
                request.setAttribute("accId", account.getId());
                
                if (account.getRole().equals("user")){
                    if (ses.getAttribute("artId")!=null) {
                 response.sendRedirect("ArticlesPage?id="+ses.getAttribute("artId"));
                    }else{
                    response.sendRedirect("Home");
                }}
                else if (account.getRole().equals("admin")){
                    response.sendRedirect(request.getContextPath()+"/ManageAcc");
                }else if (account.getRole().equals("supplier")){
                    response.sendRedirect(request.getContextPath()+"/MyTicket");
                }break;
            }
        }
        if (check==false){
        request.setAttribute("errPhone", "Error username/ password! try again!");
        request.getRequestDispatcher("Login/Login.jsp").forward(request, response);
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
