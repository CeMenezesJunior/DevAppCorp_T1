/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.awt.Label;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
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
        
        String msg = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "it":
                msg = "Ciao, ";
                break;
            case "es":
                msg = "Hola, ";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
        String msg = "";
        int hora = TestaHora();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String horaStr = new String(LocalTime.now().format(dtf));
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                if(hora == 1){
                    msg = "Bom dia, ";
                }
                else{
                    if(hora == 2){
                        msg = "Boa tarde, ";
                    }
                    else{
                        msg = "Boa noite, ";
                    }
                }
                break;
            case "en":
                if(hora == 1){
                    msg = "Good morning, ";
                }
                else{
                    if(hora == 2){
                        msg = "Good afternoon, ";
                    }
                    else{
                        msg = "Good evening, ";
                    }
                }
                break;
            case "fr":
                if(hora == 1){
                    msg = "Bonjour, ";
                }
                else{
                    if(hora == 2){
                        msg = "Bon après-midi, ";
                    }
                    else{
                        msg = "Bonne nuit, ";
                    }
                }
                break;
            case "de":
                if(hora == 1){
                    msg = "Guten morgen, ";
                }
                else{
                    if(hora == 2){
                        msg = "Guten tag, ";
                    }
                    else{
                        msg = "Gute nacht, ";
                    }
                }
                break;
            case "it":
                 if(hora == 1){
                    msg = "Buongiorno, ";
                }
                else{
                    if(hora == 2){
                        msg = "Buon pomeriggio, ";
                    }
                    else{
                        msg = "Buona Notte, ";
                    }
                }
                break;
            case "es":
                 if(hora == 1){
                    msg = "Buenos dias, ";
                }
                else{
                    if(hora == 2){
                        msg = "Buenas tardes, ";
                    }
                    else{
                        msg = "Buenas noches, ";
                    }
                }
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + horaStr + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private int TestaHora(){
        LocalTime horaAgora = LocalTime.now();
        LocalTime horaTarde = LocalTime.parse("12:00:00");
        LocalTime horaNoite = LocalTime.parse("18:00:00");
        int isManha = horaAgora.compareTo(horaTarde);
        int isNoite = horaAgora.compareTo(horaNoite);
        if(isNoite >= 0){
            return 3;
        }
        else{
            if(isManha < 0){
                return 1;
            }
            else{
                return 2;
            }
            
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
