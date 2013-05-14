/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoEvento;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.entitys.Estado;
import br.edu.utfpr.cm.slcl.entitys.Evento;
import br.edu.utfpr.cm.slcl.entitys.PedidoDeLivro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "AutorizarPedidosCurso", urlPatterns = {"/AutorizarPedidosCurso"})
public class AutorizarPedidosCurso extends HttpServlet {

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
        String botao = request.getParameter("botao");
        String idPedido = request.getParameter("pedido");
//        String motivo = request.getParameter("motivo");
        List<PedidoDeLivro> pedidos = new DaoPedidoDeLivro().listar("FROM PedidoDeLivro WHERE id = " + idPedido);
        PedidoDeLivro pedidoLivro = pedidos.get(0);
        DaoEvento daoEvento = new DaoEvento();
        DaoPedidoDeLivro daoPedidoDeLivro = new DaoPedidoDeLivro();
        Evento evento = pedidoLivro.getEvento();
        
        if (botao.equalsIgnoreCase("autorizar")) {
            evento.setEstado(Estado.AUTORIZADO);
            evento.setDataMod(new Date());
            pedidoLivro.setEvento(evento);
            daoEvento.persistir(evento);
            daoPedidoDeLivro.persistir(pedidoLivro);
        }
        if (botao.equalsIgnoreCase("cancelar")) {
            evento.setEstado(Estado.RECUSADO);
            evento.setDataMod(new Date());
            pedidoLivro.setEvento(evento);
            daoEvento.persistir(evento);
            daoPedidoDeLivro.persistir(pedidoLivro);
            
        }
        response.sendRedirect("HistoricoPedidosCurso");
    }

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
