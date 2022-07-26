/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Supplier;

import DAO.DAO;
import Model.*;
import jakarta.servlet.ServletException;
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
public class AddTicket extends HttpServlet {
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
            out.println("<title>Servlet AddTicket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTicket at " + request.getContextPath() + "</h1>");
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
        HttpSession ses=request.getSession();
        Account acc=(Account)ses.getAttribute("account");
        ArrayList<LicensePlate> listLP=new ArrayList<>();
        for (LicensePlate lp: dao.getListLicense()) {
            if (acc.getId()==lp.getFirm()){
                listLP.add(lp);
            }
        }
        request.setAttribute("listLP", listLP);
        request.getRequestDispatcher("Supplier/AddTicket.jsp").forward(request, response);
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
        HttpSession ses=request.getSession();
        Account acc=(Account)ses.getAttribute("account");
        String time=request.getParameter("time");
        String dep=request.getParameter("dep");
        String des=request.getParameter("des");
        int price=Integer.parseInt(request.getParameter("price"));
        int license=Integer.parseInt(request.getParameter("license"));
        int site=0;
        String time1=time.substring(11);
        time=time.substring(0, 10);
        time=time+" "+ time1;
        for (LicensePlate lp: dao.getListLicense()) {
            if (license==lp.getId()){
                site=lp.getMaxSite();
                break;
            }
        }
        for (Firm f: dao.getListFirm()) {
            if (acc.getId()==f.getId()){
                Tickets t=new Tickets(
                        (f.getType().equals("plane"))?0:1, time, dep,
                        des, price, site, true);
                dao.addTicket(t);
                break;
            }
        }
        //request.getRequestDispatcher("Supplier")
        response.sendRedirect("MyTicket");
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
