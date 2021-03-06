/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoUsuario;
import br.edu.utfpr.cm.slcl.entitys.PedidoDeLivro;
import br.edu.utfpr.cm.slcl.entitys.Professor;
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
@WebServlet(name = "HistoricoPedidosLivro", urlPatterns = {"/HistoricoPedidosLivro"})
public class HistoricoPedidosLivro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Professor professor = (Professor) request.getSession().getAttribute("UsuarioLogado");
        DaoPedidoDeLivro dao = new DaoPedidoDeLivro();
        List<Usuario> users = new DaoUsuario().listar("FROM Usuario WHERE nome = '"+professor.getNome()+"'");
        Usuario user = users.get(0);
        List<PedidoDeLivro> pedidos = dao.listar("FROM PedidoDeLivro WHERE professor_id ="+user.getId());
        request.getSession().setAttribute("pedidosLivro", pedidos);
        System.out.println("URI: " + request.getHeader("REFERER"));
        String page = request.getHeader("REFERER");
        if (page.contains("Coordenador.jsp")) {
            response.sendRedirect("restrito/historicoPedidosCoordenador.jsp");
        }
        if (page.contains("Professor.jsp")) {
            response.sendRedirect("restrito/historicoPedidosProfessor.jsp");
        }
    }

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
