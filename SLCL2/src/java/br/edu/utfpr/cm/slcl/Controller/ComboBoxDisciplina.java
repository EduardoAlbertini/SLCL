/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.dao.entitys.DaoCurso;
import br.com.entitys.Curso;
import br.com.entitys.Disciplina;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ComboBoxDisciplina", urlPatterns = {"/ComboBoxDisciplina"})
public class ComboBoxDisciplina extends HttpServlet {

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
        String curso = request.getParameter("curso");
        
        DaoCurso daoCurso = new DaoCurso();
        List<Curso> cursos = daoCurso.listar("FROM Curso WHERE nome = '" + curso + "'");
        List<Disciplina> disciplinas = cursos.get(0).getDisciplinas();
//        SELECT  d.codigo, d.nome, c.nome FROM disciplina d, curso c where c.nome like 'Tecnologia em Sistemas para Internet';
        
        System.out.println(disciplinas.toString());
        getServletContext().setAttribute("disciplinas", disciplinas);
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
