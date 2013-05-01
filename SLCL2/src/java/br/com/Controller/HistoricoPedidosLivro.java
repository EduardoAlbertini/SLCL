/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.dao.entitys.DaoPedidoDeLivro;
import br.com.entitys.PedidoDeLivro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Miray
 */
@WebServlet(name = "HistoricoPedidosLivro", urlPatterns = {"/HistoricoPedidosLivro"})
public class HistoricoPedidosLivro extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoPedidoDeLivro dao = new DaoPedidoDeLivro();
        List<PedidoDeLivro> pedidos = dao.listar();
        
        request.getSession().setAttribute("pedidosLivro", pedidos);
        response.sendRedirect("indexProfessor.jsp");
    }
}
