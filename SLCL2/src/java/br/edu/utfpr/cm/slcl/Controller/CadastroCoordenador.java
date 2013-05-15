/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoCoordenador;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoProfessor;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoUsuario;
import br.edu.utfpr.cm.slcl.entitys.Coordenador;
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
@WebServlet(name = "CadastroCoordenador", urlPatterns = {"/CadastroCoordenador"})
public class CadastroCoordenador extends HttpServlet {

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
        String botao = request.getParameter("botao");
        Professor prof = new Professor();
        Coordenador coord = new Coordenador();
        if (botao.equalsIgnoreCase("inserir")) {
            List<Professor> professores = new DaoProfessor().listar("FROM Professor WHERE login ='" + codigo + "'");
            prof = professores.get(0);
            coord.setId(prof.getId());
            coord.setNome(prof.getNome());
            coord.setEmail(prof.getEmail());
            coord.setLogin(prof.getLogin());
            coord.setSenha(prof.getSenha());
            coord.setPapel(new Papel(2));

            new DaoUsuario().persistir(coord);
        }
        if (botao.equalsIgnoreCase("excluir")) {
            List<Coordenador> coordenadores = new DaoCoordenador().listar("FROM Coordenador WHERE login ='" + codigo + "'");
            coord = coordenadores.get(0);
            prof.setId(coord.getId());
            prof.setNome(coord.getNome());
            prof.setEmail(coord.getEmail());
            prof.setLogin(coord.getLogin());
            prof.setSenha(coord.getSenha());
            prof.setPapel(new Papel(3));
            
            new DaoUsuario().persistir(prof);
        }

        response.sendRedirect("restrito/crudCoordenador.jsp");
    }
}
