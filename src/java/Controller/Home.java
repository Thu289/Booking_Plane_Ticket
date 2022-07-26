/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Account;
import Model.PageInfor;
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
public class Home extends HttpServlet {
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
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
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
         request.setAttribute("DAO", dao);
         int size=dao.getArticles().size();
         int npp=Integer.parseInt(getInitParameter("npp"));
         int currentPage=0;
         PageInfor page=new PageInfor(currentPage, npp, size);
         page.calculator();
         request.setAttribute("page", page);
         HttpSession ses=request.getSession();
         Account acc=(Account)ses.getAttribute("account");
         if (acc!=null){
             request.getRequestDispatcher("Main/UserHome.jsp").forward(request, response);
         }else{
            request.getRequestDispatcher("Main/Main_Article.jsp").forward(request, response);
             
         }
    
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
        int numberPage=Integer.parseInt(request.getParameter("numberPage"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        int npp=Integer.parseInt(getInitParameter("npp"));
        
        if (request.getParameter("home")!=null) currentPage=0;
        if (request.getParameter("pre")!=null ) currentPage=currentPage-1;
        if(request.getParameter("next")!=null ) currentPage+=1;
        if (request.getParameter("end")!=null) currentPage=numberPage-1;
        for (int i=0; i<numberPage; i++){
            if (request.getParameter("btn"+i)!=null) currentPage=i;
        }
        
        PageInfor page=new PageInfor(currentPage, npp, dao.getArticles().size());
        page.calculator();
        request.setAttribute("DAO", dao);
        request.setAttribute("page", page);
        request.getRequestDispatcher("Main/Main_Article.jsp").forward(request, response);
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
