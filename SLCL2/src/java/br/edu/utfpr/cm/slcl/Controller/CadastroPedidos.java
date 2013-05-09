/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.slcl.Controller;

import br.edu.utfpr.cm.slcl.dao.entitys.DaoCurso;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoLivro;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoPedidoDeLivro;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoProfessor;
import br.edu.utfpr.cm.slcl.entitys.Curso;
import br.edu.utfpr.cm.slcl.entitys.Livro;
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
@WebServlet(name = "CadastroPedidos", urlPatterns = {"/CadastroPedidos"})
public class CadastroPedidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isbn = request.getParameter("ISBN");
        String titulo = request.getParameter("titulo");
        String tituloOriginal = request.getParameter("tituloOriginal");
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        String edicao = request.getParameter("edicao");
        String assunto = request.getParameter("assunto");
        int qtde = Integer.parseInt(request.getParameter("quantidade"));
        String curso = request.getParameter("curso");
        String disciplina = request.getParameter("disciplina");
        String referencia = request.getParameter("referencia");
        String professor = (String) request.getSession().getAttribute("UsuarioLogado");


        Livro livro = new Livro(tituloOriginal, titulo, autor, edicao, editora, isbn, assunto);
        List<Professor> professores = new DaoProfessor().listar("FROM Usuario WHERE nome = '"+professor+"'");
        Professor prof = professores.get(0);
        
        List<Curso> cursos =new DaoCurso().listar("FROM Curso Where nome = '" + curso+ "'");
        Curso curse = cursos.get(0);
        
        PedidoDeLivro pedidoDeLivro = new PedidoDeLivro(qtde, livro, prof, curse);
        if (referencia.equalsIgnoreCase("complementar")) {
            pedidoDeLivro.setBibliografia();
        }
        System.out.println(pedidoDeLivro.toString());

        DaoLivro daoLivro = new DaoLivro();
        daoLivro.persistir(livro);

        DaoPedidoDeLivro dao = new DaoPedidoDeLivro();
        dao.persistir(pedidoDeLivro);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
        response.sendRedirect("pedidoLivroProfessor.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
        response.sendRedirect("pedidoLivroCoordenador.jsp");
    }
}
