/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCoordenador;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoCurso;
import br.edu.utfpr.cm.slcl.entitys.Coordenador;
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
@WebServlet(name = "CadastroCurso", urlPatterns = {"/CadastroCurso"})
public class CadastroCurso extends HttpServlet {

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
        String nomeCurso = request.getParameter("nome");
        String coordenador = request.getParameter("coordenador");
        List<Coordenador> coords = new DaoCoordenador().listar("FROM Coordenador WHERE nome = '"+ coordenador + "'");
        Coordenador coord = coords.get(0);

        Curso curso = new Curso(codigo, nomeCurso, coord, null);
        DaoCurso dao = new DaoCurso();
        dao.persistir(curso);
        
        request.setAttribute("cursoCadastrado", "O curso foi cadastrado com Sucesso!");
        request.getRequestDispatcher("crudCurso.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        if (!codigo.equals("")) {
            Curso curso = new Curso();
            List<Curso> cursos = new DaoCurso().listar("FROM Curso WHERE codigo = '" + codigo + "'");
            
            if (cursos.size()>0) {
                curso = cursos.get(0);
            }
            if (curso != null) {
                response.getWriter().write(curso.toString());
            }
        }
    }
}
