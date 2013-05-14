/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCoordenador;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.entitys.Coordenador;
import br.edu.utfpr.cm.slcl.entitys.PedidoDeLivro;
import java.io.IOException;
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
@WebServlet(name = "HistoricoPedidosCurso", urlPatterns = {"/HistoricoPedidosCurso"})
public class HistoricoPedidosCurso extends HttpServlet {

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
       String nomeUser = (String) request.getSession().getAttribute("UsuarioLogado");
        System.out.println("usuário: "+nomeUser);
        List<Coordenador> coords = new DaoCoordenador().listar("FROM Coordenador WHERE nome ='" +nomeUser+"'");
        System.out.println(coords.toString());
        Coordenador coord = coords.get(0);
        List<PedidoDeLivro> pedidos = new DaoPedidoDeLivro().listar();
        //        "FROM PedidoDeLivro LEFT JOIN FETCH Curso LEFT JOIN FETCH Usuario ON curso_id = Curso.id AND Curso.coordenador_id=" + coord.getId();
        //FROM PedidoDeLivro p, Curso c, Usuario u  WHERE p.curso_id = c.id AND c.coordenador_id =" + coord.getId(); 
        request.getSession().setAttribute("listaPedidosCurso", pedidos);
        response.sendRedirect("historicosPedidosCurso.jsp");
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
