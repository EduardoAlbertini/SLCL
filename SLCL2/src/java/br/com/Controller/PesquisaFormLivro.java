/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.XML.XMLReader;
import br.com.dao.DaoGenerics;
import br.com.dao.entitys.DaoLivro;
import br.com.entitys.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Miray
 */
@WebServlet(name = "PesquisaFormLivro", urlPatterns = {"/PesquisaFormLivro"})
public class PesquisaFormLivro extends HttpServlet {

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
        try {
            String isbn = request.getParameter("ISBN").trim();
            System.out.println("ISBN: " + isbn);
            if (!isbn.equals("")) {
                DaoGenerics dao = new DaoLivro();
                List<Livro> livros = dao.listar("FROM Livro WHERE isbn = '"+ isbn + "'");
                Livro livro = null;
                
                if (livros.size()>0) {
                    livro = livros.get(0);
                }else{

                    XMLReader leitor = new XMLReader();
                    livro = leitor.getLivro(isbn);
                }
                if(livro !=null)
                response.getWriter().write(livro.toString());
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(PesquisaFormLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
