/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCurso;
import br.edu.utfpr.cm.slcl.entitys.Curso;
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
@WebServlet(name = "ComboBoxCurso", urlPatterns = {"/ComboBoxCurso"})
public class ComboBoxCurso extends HttpServlet {

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
        
        List<Curso> cursos = new DaoCurso().listar();
        
        request.getSession().setAttribute("cursos", cursos);
        String page = request.getHeader("REFERER");
        if (page.contains("indexCoordenador.jsp")) {
            response.sendRedirect("restrito/pedidoLivroCoordenador.jsp");
        }
        else if (page.contains("indexProfessor.jsp")) {
            response.sendRedirect("restrito/pedidoLivroProfessor.jsp");
        }
        else{
            response.sendRedirect("restrito/crudDisciplina.jsp");            
        }
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
        doGet(request, response);
    }
}
