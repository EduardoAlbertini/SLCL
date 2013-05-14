/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.entitys.Estado;
import br.edu.utfpr.cm.slcl.entitys.PedidoDeLivro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miray
 */
@WebServlet(name = "HistoricoPedidosAprovados", urlPatterns = {"/HistoricoPedidosAprovados"})
public class HistoricoPedidosAprovados extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PedidoDeLivro> pedidos = new DaoPedidoDeLivro().listar();
        List<PedidoDeLivro> pedidosAutorizados = new ArrayList<PedidoDeLivro>();
        Estado status;

        for (PedidoDeLivro pedido : pedidos) {
            status = pedido.getEvento().getEstado();
            if (status == Estado.AUTORIZADO || status == Estado.LICITADO || status == Estado.ADQUIRIDO) {
                pedidosAutorizados.add(pedido);
            }
        }

        request.getSession().setAttribute("pedidosAutorizados", pedidosAutorizados);
        response.sendRedirect("historicoPedidosAutorizados.jsp");
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }
}
