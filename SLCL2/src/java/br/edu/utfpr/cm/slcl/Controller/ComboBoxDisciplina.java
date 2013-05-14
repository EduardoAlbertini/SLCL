/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCurso;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoDisciplina;
import br.edu.utfpr.cm.slcl.entitys.Curso;
import br.edu.utfpr.cm.slcl.entitys.Disciplina;
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
@WebServlet(name = "ComboBoxDisciplina", urlPatterns = {"/ComboBoxDisciplina"})
public class ComboBoxDisciplina extends HttpServlet {

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
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        List<String> disciplinas_nome = new ArrayList<String>();
        Curso curse;
        String curso = request.getParameter("curso");
        System.out.println("Curso: "+ curso);
        DaoDisciplina daoDisciplina = new DaoDisciplina();
        if(!curso.equalsIgnoreCase("selecione...")){
        List<Curso> cursos = new DaoCurso().listar("FROM Curso Where nome = '" + curso+ "'");
        curse = cursos.get(0);
        disciplinas = daoDisciplina.listar("FROM Disciplina WHERE curso_id = "+curse.getId());
        }
        for (Disciplina disc : disciplinas) {
            disciplinas_nome.add(disc.getNome());
        }
        
        response.getWriter().write(disciplinas_nome.toString());
    }
}
