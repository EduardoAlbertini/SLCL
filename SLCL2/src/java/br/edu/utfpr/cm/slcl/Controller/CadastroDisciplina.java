/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCurso;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoDisciplina;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.entitys.Curso;
import br.edu.utfpr.cm.slcl.entitys.Disciplina;
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
            List<Disciplina> disciplinas = dao.listar("FROM Disciplina WHERE codigo = '" + codigo + "'");

            if (disciplinas.size() > 0) {
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
        String curse = request.getParameter("curso");
        String botao = request.getParameter("botao");

        DaoCurso daoCurso = new DaoCurso();
        DaoDisciplina daoDisciplina = new DaoDisciplina();
        DaoPedidoDeLivro daoPedidoDeLivro = new DaoPedidoDeLivro();
        List<Curso> cursos = daoCurso.listar("FROM Curso curso WHERE nome = '" + curse + "'");
        Curso curso = cursos.get(0);
        Disciplina disciplina;

        if (botao.equalsIgnoreCase("inserir")) {
            disciplina = new Disciplina(codigo, nome, curso);
            curso.addDisciplina(disciplina);
            daoDisciplina.persistir(disciplina);
            daoCurso.persistir(curso);
        }
//        if (botao.equalsIgnoreCase("excluir")) {
//            List<Disciplina> disciplinas = daoDisciplina.listar("FROM Disciplina WHERE codigo = '" + codigo + "'");
//            disciplina = disciplinas.get(0);
//            List<PedidoDeLivro> pedidos = daoPedidoDeLivro.listar("FROM PedidoDeLivro WHERE disciplina_id = "+disciplina.getId());
//            for(PedidoDeLivro pedido : pedidos){
//                daoPedidoDeLivro.remover(pedido);
//            }
//            daoDisciplina.remover(disciplina);
//        }

        request.setAttribute("disciplinaCadastrada", "A disciplina foi cadastrada com Sucesso!");
        request.getRequestDispatcher("crudDisciplina.jsp").forward(request, response);
    }
}
