/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.dao.entitys.DaoCurso;
import br.com.dao.entitys.DaoDisciplina;
import br.com.entitys.Curso;
import br.com.entitys.Disciplina;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CadastroDisciplina", urlPatterns = {"/CadastroDisciplina"})
public class CadastroDisciplina extends HttpServlet {

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
        String codigo = request.getParameter("codigo");
        if (!codigo.equals("")) {
            DaoDisciplina dao = new DaoDisciplina();
            Disciplina disciplina = new Disciplina();
            List<Disciplina> disciplinas = new ArrayList<Disciplina>();
            disciplinas = dao.listar("FROM Disciplina WHERE codigo = '"+codigo+"'");
            
            if (disciplinas.size()>0) {
                disciplina = disciplinas.get(0);
            }
            if (disciplina != null) {
                response.getWriter().write(disciplina.toString());
            }
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
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String curso = request.getParameter("curso");
        
        DaoCurso daoCurso = new DaoCurso();
        List<Curso> cursos = daoCurso.listar("FROM Curso WHERE nome = '" + curso + "'");

        Disciplina disciplina = new Disciplina(codigo, nome, cursos.get(0));

        DaoDisciplina daoDisciplina = new DaoDisciplina();
        daoDisciplina.persistir(disciplina);

        response.sendRedirect("indexBibliotecario.jsp");
    }
}
