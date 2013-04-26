package br.com.login;

import br.com.ldap.LDAP;
import br.com.ldap.TransactionManager;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authc.IncorrectCredentialsException;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uLogin = request.getParameter("login");
        String uSenha = request.getParameter("senha");


//        try {
//
//            //Usar em casa//
//            Usuario usuarioLocal = ehOAdmin(uLogin, uSenha);
//            if (usuarioLocal != null) {
//                request.getSession().setAttribute("UsuarioLogado", usuarioLocal);
//                response.sendRedirect("Sistema/index.jsp");
//            } else {
//                //Usar em casa//                
//                if (!uLogin.equals("admin")) {
//                    usuarioLocal = verificarNaBaseLocal(uLogin, uSenha);
//
//                    //Usar em UTFPR//
//                    //usuarioLocal = autenticarUsuario(uLogin, uSenha);
//                    //System.out.println(autenticarUsuario(uLogin, uSenha));
//                    //if (user != null) {
//
//                    if (usuarioLocal != null) {
//                        Usuario userInterno = garantirQueUsuarioEstaNaBaseDoGerenciador(usuarioLocal, out, request);
//                        request.getSession().setAttribute("UsuarioLogado", userInterno);
//                        response.sendRedirect("Sistema/index.jsp");
//                    } else {
//                        request.getSession().setAttribute("erroLogin", "erro");
//                        response.sendRedirect("index.jsp");
//                    }
//                } else {
//                    request.getSession().setAttribute("erroLogin", "erro");
//                    response.sendRedirect("index.jsp");
//                }
//            }


//        } finally {
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Usuario autenticarUsuario(String uLogin, String uSenha) {


        Usuario user = LDAP.buscarUsuario(uLogin);



        if (user != null) {
            try {
                if (LDAP.autenticacao(uLogin, uSenha)) {
                    return user;
                } else {
                    return null;
                }
            } catch (IncorrectCredentialsException e) {
                return null;
            }
        } else {
            return null;
        }

    }

//    private Usuario garantirQueUsuarioEstaNaBaseDoGerenciador(Usuario user, PrintWriter out, HttpServletRequest request) {
//
//        request.getSession().removeAttribute("UsuarioLogado");
//
//        if (user.getLogin().charAt(0) == 'a' && verificarSegundoDigito(user.getLogin().charAt(1))) {
//
//            DaoEstagiario daoE = new DaoEstagiario();
//
//
//            Estagiario aluno = daoE.obterPorRA(user.getLogin());
//
//            if (aluno != null) {
//                if (aluno.getPapel() == null) {
//                    aluno.setPapel(new DaoPapel().obterPorId(3));
//                    daoE.persistir(aluno);
//                    request.getSession().setAttribute("UsuarioLogado", aluno);
//                    return aluno;
//                } else {
//                    request.getSession().setAttribute("UsuarioLogado", aluno);
//                    return aluno;
//                }
//
//            } else {
//                TransactionManager.beginTransaction();
//                aluno = new Estagiario();
//                aluno.setLogin(user.getLogin());
//                aluno.setNome(user.getNome());
//                aluno.setEmail(user.getEmail());
//                aluno.setPapel(new DaoPapel().obterPorId(3));
//                daoE.persistir(aluno);
//                TransactionManager.commit();
//                request.getSession().setAttribute("UsuarioLogado", aluno);
//                return aluno;
//            }
//
//        } else {
//
//
//            DaoOrientador daoO = new DaoOrientador();
//            Orientador orientador = daoO.obterPorSiape(user.getLogin());
//
//            if (orientador != null) {
//                if (orientador.getPapel() == null) {
//                    orientador.setPapel(new DaoPapel().obterPorId(2));
//                    daoO.persistir(orientador);
//                    request.getSession().setAttribute("UsuarioLogado", orientador);
//                    return orientador;
//                } else {
//                    request.getSession().setAttribute("UsuarioLogado", orientador);
//                    return orientador;
//                }
//            } else {
//                TransactionManager.beginTransaction();
//                orientador = new Orientador();
//                orientador.setNome(user.getNome());
//                orientador.setLogin(user.getLogin());
//                orientador.setEmail(user.getEmail());
//                orientador.setPapel(new DaoPapel().obterPorId(2));
//                daoO.persistir(orientador);
//                TransactionManager.commit();
//                request.getSession().setAttribute("UsuarioLogado", orientador);
//                return orientador;
//            }
//
//
//        }
//
//    }

    private boolean verificarSegundoDigito(char digito2) {
        switch (digito2) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

//    private Usuario verificarNaBaseLocal(String uLogin, String uSenha) {
//        if (uLogin.isEmpty() || uLogin.equals("")) {
//            return null;
//        } else {
//            //TransactionManager.beginTransaction();
//            DaoUsuario dao = new DaoUsuario();
//            Usuario usuario = dao.obterPorLogin(uLogin);
//            System.out.println(usuario);
//            return usuario;
//        }
//    }
////    private boolean verificarSePapelDoEstagiarioEstaOk(Estagiario aluno) {
////    }

//    private Usuario ehOAdmin(String uLogin, String uSenha) {
//        if (uLogin.equals("admin")) {
//            DaoUsuario dao = new DaoUsuario();
//            Usuario usuario = dao.obterPorLogin(uLogin);
//            if (uSenha.equals("admin147")) {
//                System.out.println(usuario);
//                return usuario;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
}
