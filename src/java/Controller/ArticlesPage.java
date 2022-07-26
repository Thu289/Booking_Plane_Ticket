/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import Model.*;

/**
 *
 * @author Vostro 5502
 */
public class ArticlesPage extends HttpServlet {

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
            out.println("<title>Servlet Articles</title>");            
            out.println("</head>");
            out.println("<body>");
                        out.println("<h1>"+request.getAttribute("articleId")+"</h1>");

            out.println("<h1>Servlet Articles at " + request.getContextPath() + "</h1>");
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
        
        request.setAttribute("DAO", dao);
        request.setAttribute("role", "");
        int id=0;
        try {
            id=Integer.parseInt(request.getParameter("id"));
            } catch (Exception e) {
            response.sendRedirect("Home");
        }
        for (Articles art: dao.getArticles()) {
            if (art.getId()==id){
                dao.updateArtView(id, art.getViews()+1);
                break;
            }
        }
        HttpSession ses=request.getSession();
        ses.setAttribute("artId", id);
        request.setAttribute("articleId", id);
        Account newacc=(Account)ses.getAttribute("account");
        if (newacc!=null){
            request.setAttribute("accId", newacc.getId());
            request.setAttribute("role",newacc.getRole());
        }
        if (id!=0){
            request.getRequestDispatcher("Main/ArticleId.jsp").forward(request, response);
        }
        
        //processRequest(request, response);
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
        String key=request.getParameter("key");
        if (key==null) response.sendRedirect("Articles");
        else{
            ArrayList<Articles> listArticles=dao.getArticles();
            ArrayList<Articles> listShow=new ArrayList<>();
            for (Articles articles : listArticles) {
                if (articles.getTitle().contains(key) || 
                       (articles.getDiscription()!=null && 
                        articles.getDiscription().contains(key)) ||
                        articles.getKeyword().contains(key)){
                    listShow.add(articles);
                }
            }
            if (listShow.size()==0) request.setAttribute("mess", "There is no article has this char");
            request.setAttribute("list", listShow);
            request.getRequestDispatcher("Main/SearchArticleResult.jsp").forward(request, response);
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
