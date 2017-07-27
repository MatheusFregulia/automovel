
package controller;

import dao.CompradorDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comprador;
import model.Pessoa;


public class ManterCompradorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("pessoas", PessoaDAO.obterInstancia().obterPessoas());
            RequestDispatcher view = request.getRequestDispatcher("/manterComprador.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int idComprador = Integer.parseInt(request.getParameter("txtIdComprador"));
            String tipo = request.getParameter("txtTipo");
            Pessoa pessoa = PessoaDAO.obterInstancia().obterPessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));
            
            Comprador comprador = new Comprador(idComprador, tipo);
            comprador.setPessoaidPessoa(pessoa);
            
            CompradorDAO.obterInstancia().gravar(comprador);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCompradorController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int idComprador = Integer.parseInt(request.getParameter("txtIdComprador"));
            Comprador comprador = CompradorDAO.obterInstancia().obterComprador(idComprador);
            
            request.setAttribute("comprador", comprador);
            request.setAttribute("pessoas", PessoaDAO.obterInstancia().obterPessoas());

            RequestDispatcher view = request.getRequestDispatcher("/manterComprador.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
             int idComprador = Integer.parseInt(request.getParameter("txtIdComprador"));
            String tipo = request.getParameter("txtTipo");
            Pessoa pessoa = PessoaDAO.obterInstancia().obterPessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));
            
            Comprador comprador = new Comprador(idComprador, tipo);
            comprador.setPessoaidPessoa(pessoa);
            
            CompradorDAO.obterInstancia().gravar(comprador);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCompradorController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
             request.setAttribute("operacao", "Editar");

            int idComprador = Integer.parseInt(request.getParameter("txtIdComprador"));
            Comprador comprador = CompradorDAO.obterInstancia().obterComprador(idComprador);
            
            request.setAttribute("comprador", comprador);
            request.setAttribute("pessoas", PessoaDAO.obterInstancia().obterPessoas());

            RequestDispatcher view = request.getRequestDispatcher("/manterComprador.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int idComprador = Integer.parseInt(request.getParameter("txtIdComprador"));
            String tipo = request.getParameter("txtTipo");
            Pessoa pessoa = PessoaDAO.obterInstancia().obterPessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));
            
            Comprador comprador = new Comprador(idComprador, tipo);
            comprador.setPessoaidPessoa(pessoa);
            
            CompradorDAO.obterInstancia().gravar(comprador);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCompradorController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
