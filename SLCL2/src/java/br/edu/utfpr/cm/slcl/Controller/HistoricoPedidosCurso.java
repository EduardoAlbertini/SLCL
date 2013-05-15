/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCoordenador;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoCurso;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.entitys.Coordenador;
import br.edu.utfpr.cm.slcl.entitys.Curso;
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
        Coordenador nomeUser = (Coordenador) request.getSession().getAttribute("UsuarioLogado");
        List<Coordenador> coords = new DaoCoordenador().listar("FROM Coordenador WHERE nome ='" + nomeUser.getNome() + "'");
        Coordenador coord = coords.get(0);
        List<Curso> cursos = new DaoCurso().listar("FROM Curso WHERE coordenador_id=" + coord.getId());
        Curso curso = cursos.get(0);
        List<PedidoDeLivro> pedidosLivro = new DaoPedidoDeLivro().listar("FROM PedidoDeLivro WHERE curso_id=" + curso.getId() + " AND " + curso.getCoordenador().getId() + "=" + coord.getId());
        List<PedidoDeLivro> pedidos = new ArrayList<PedidoDeLivro>();

        for (PedidoDeLivro pedido : pedidosLivro) {
            if (pedido.getEvento().getEstado() == Estado.REQUERIDO) {
                pedidos.add(pedido);
            }
        }
        request.getSession().setAttribute("listaPedidosCurso", pedidos);
        response.sendRedirect("restrito/historicosPedidosCurso.jsp");
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
