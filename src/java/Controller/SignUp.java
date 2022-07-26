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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Vostro 5502
 */
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

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
            out.println("<title>Servlet Sign up</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Sign up at " + request.getContextPath() + "</h1>");
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
        Cookie []cookies=request.getCookies();
        ArrayList<Account> listAcc=dao.getAccount();
        boolean checkCookie=false;
        for (Cookie c: cookies) {
            if (c.getName().equals("newAccount")){
                request.setAttribute("cooke", c.getValue());
                int idAcc=Integer.parseInt(c.getValue());
                for (Account account : listAcc) {
                    if (account.getId()==idAcc){
                        request.setAttribute("here", c.getName());
                        request.setAttribute("acc", account);
                        checkCookie=true;
                        break;
                    }
                }
            }
        }
        if (checkCookie==false) request.setAttribute("acc", new Account());
        request.getRequestDispatcher("Signup/Signup.jsp").forward(request, response);

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
        String username=request.getParameter("username").trim();
        String password=request.getParameter("password").trim();
        String phone = request.getParameter("phone").trim();
        String email=request.getParameter("email").trim();
        String address=request.getParameter("address").trim();
        String role=request.getParameter("role");
        boolean status=true;
        boolean gender=request.getParameter("gender").equals("male");
        String dob=request.getParameter("dob").toString();
        boolean check=true;
        String url="Confirm_Phone";
        if (username.equals("") || password.equals("") || phone.equals("")){
            url="SignUp";
        }else{
            for (Account acc: dao.getAccount()) {
                if (acc.getPhone().equals(phone)){
                    url="SignUp";
                    check=false;
                    break;
                }
            }
            
            if (check){
                
                  Account newAccount=new Account(username, password, phone, email, address, role, status, "", gender, dob);
            dao.addAccount(newAccount);
            dao.updateStatus(newAccount.getId(), 0);
        
            HttpSession sess=request.getSession();
            sess.setAttribute("account", newAccount); 
            Cookie acc=new Cookie("newAccount", newAccount.getId()+"");

            }
            
        }
        
        response.sendRedirect("Home");
        
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
