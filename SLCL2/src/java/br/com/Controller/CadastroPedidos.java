/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.dao.DaoGenerics;
import br.com.dao.entitys.DaoLivro;
import br.com.dao.entitys.DaoPedidoDeLivro;
import br.com.entitys.Bibliografia;
import br.com.entitys.Evento;
import br.com.entitys.Livro;
import br.com.entitys.PedidoDeLivro;
import java.io.IOException;
import java.io.PrintWriter;
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

        Livro livro = new Livro(tituloOriginal, titulo, autor, edicao, editora, isbn, assunto);
        PedidoDeLivro pedidoDeLivro = new PedidoDeLivro(qtde, Bibliografia.COMPLEMENTAR, livro, null, null);
        System.out.println(pedidoDeLivro.toString());

        DaoLivro daoLivro = new DaoLivro();
        daoLivro.persistir(livro);

        DaoPedidoDeLivro dao = new DaoPedidoDeLivro();
        dao.persistir(pedidoDeLivro);

        response.sendRedirect("indexProfessor.jsp");
    }
}
