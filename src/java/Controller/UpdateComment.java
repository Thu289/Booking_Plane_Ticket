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
public class UpdateComment extends HttpServlet {

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
            out.println("<title>Servlet UpdateComment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateComment at " + request.getContextPath() + "</h1>");
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
        int type=Integer.parseInt(request.getParameter("type").toString());
        int comId=Integer.parseInt(request.getParameter("id").toString());
        HttpSession ses=request.getSession();
        int artId=Integer.parseInt(ses.getAttribute("artId").toString());
        Account newacc=(Account)ses.getAttribute("account");
        if (newacc!=null){
            request.setAttribute("accId", newacc.getId());
        }
        if (type==0){
            dao.deleteComment(comId);
            response.sendRedirect("ArticlesPage?id="+artId);
        }else if (type==1){
            request.setAttribute("articleId", artId);
            request.setAttribute("comUpd", comId);
            request.getRequestDispatcher("Main/UpdateComment.jsp").forward(request, response);
        }else {
            request.setAttribute("articleId", artId);
            request.setAttribute("comRep", comId);
            request.getRequestDispatcher("Main/ReplyCom.jsp").forward(request, response);
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
        String description=request.getParameter("comment");
        int star=Integer.parseInt(request.getParameter("star").toString());
        int comId=Integer.parseInt(request.getParameter("comId").toString());
        dao.updateComment(comId, description, star);
        HttpSession ses=request.getSession();
        int artId=Integer.parseInt(ses.getAttribute("artId").toString());
        response.sendRedirect("ArticlesPage?id="+artId);
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
