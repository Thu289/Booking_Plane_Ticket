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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vostro 5502
 */
public class Ticket extends HttpServlet {

    DAO dao;

    public void init() {
        dao = new DAO();
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
            out.println("<title>Servlet Ticket</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ticket at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Main/Main_Ticket.jsp").forward(request, response);
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
        request.setAttribute("DAO", dao);
        String dep = request.getParameter("dep");
        dep=(dep==null)?"":dep;
        String des = request.getParameter("des");
        des=(des==null)?"":des;
        //String timeF = request.getParameter("timeFrom");
        //String timeT = request.getParameter("timeTo");
        int type = Integer.parseInt(request.getParameter("type"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        boolean check=true;
//        try {
//            Date tf = df.parse(timeF);
//        } catch (ParseException ex) {
//            check=false;
//            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            Date tt = df.parse(timeT);
//        } catch (ParseException ex) {
//            check=false;
//            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
//        }
        ArrayList<Tickets> listTick=new ArrayList<>();
        for (Tickets tickets : dao.getListTicket()) {
            if (tickets.getDeparture().contains(dep) &&
                    tickets.getDestination().contains(des)){
                listTick.add(tickets);
            }
        }
        if (listTick.size()==0) {
            request.setAttribute("mess", "There no ticket");
        }else{
            request.setAttribute("listTick", listTick);
        }
        request.setAttribute("listTick", listTick);
        request.getRequestDispatcher("Main/Main_Ticket.jsp").forward(request, response);
        //response.sendRedirect("Ticket");

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
