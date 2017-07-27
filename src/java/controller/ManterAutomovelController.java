package controller;

import dao.AutomovelDAO;
import dao.MarcaDAO;
import dao.EstadoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Automovel;
import model.Marca;
import model.Estado;

public class ManterAutomovelController extends HttpServlet {

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
            request.setAttribute("marcas", MarcaDAO.obterInstancia().obterMarca());
            request.setAttribute("estados", EstadoDAO.obterInstancia().obterEstados());

            RequestDispatcher view = request.getRequestDispatcher("/manterAutomovel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int placa = Integer.parseInt(request.getParameter("txtplaca"));
            String nome = request.getParameter("txtNome");
            String modelo = request.getParameter("txtModelo");
            String anoFabricacao = request.getParameter("txtAnoFabricacao");
            String cor = request.getParameter("txtCor");
            float preco = Float.parseFloat(request.getParameter("txtPreco"));
            
            Estado estado = EstadoDAO.obterInstancia().obterEstado(Integer.parseInt(request.getParameter("txtIdEstado")));
            Marca marca = MarcaDAO.obterInstancia().obterMarca(Integer.parseInt(request.getParameter("txtIdMarca")));
            Automovel automovel = new Automovel(placa);
        
            automovel.setMarcaidMarca(marca);
            automovel.setEstadoidEstado(estado);
            
            AutomovelDAO.obterInstancia().gravar(automovel);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAutomovelController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int placa = Integer.parseInt(request.getParameter("txtplaca"));
            Automovel automovel = AutomovelDAO.obterInstancia().obterAutomovel(placa);
            
            request.setAttribute("automoveis", automovel);
            request.setAttribute("marcas", MarcaDAO.obterInstancia().obterMarca());
            request.setAttribute("estados", EstadoDAO.obterInstancia().obterEstados());

            RequestDispatcher view = request.getRequestDispatcher("/manterAutomovel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int placa = Integer.parseInt(request.getParameter("txtplaca"));
            String nome = request.getParameter("txtNome");
            String modelo = request.getParameter("txtModelo");
            String anoFabricacao = request.getParameter("txtAnoFabricacao");
            String cor = request.getParameter("txtCor");
            String preco = request.getParameter("txtPreco");
            
            Estado estado = EstadoDAO.obterInstancia().obterEstado(Integer.parseInt(request.getParameter("txtIdEstado")));
            Marca marca = MarcaDAO.obterInstancia().obterMarca(Integer.parseInt(request.getParameter("txtIdMarca")));
            Automovel automovel = new Automovel(placa);
        
            automovel.setMarcaidMarca(marca);
            automovel.setEstadoidEstado(estado);
            
            AutomovelDAO.obterInstancia().gravar(automovel);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAutomovelController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("operacao", "Excluir");

            int placa = Integer.parseInt(request.getParameter("txtplaca"));
            Automovel automovel = AutomovelDAO.obterInstancia().obterAutomovel(placa);
            
            request.setAttribute("automoveis", automovel);
            request.setAttribute("marcas", MarcaDAO.obterInstancia().obterMarca());
            request.setAttribute("estados", EstadoDAO.obterInstancia().obterEstados());

            RequestDispatcher view = request.getRequestDispatcher("/manterAutomovel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int placa = Integer.parseInt(request.getParameter("txtplaca"));
            String nome = request.getParameter("txtNome");
            String modelo = request.getParameter("txtModelo");
            String anoFabricacao = request.getParameter("txtAnoFabricacao");
            String cor = request.getParameter("txtCor");
            String preco = request.getParameter("txtPreco");
            
            Estado estado = EstadoDAO.obterInstancia().obterEstado(Integer.parseInt(request.getParameter("txtIdEstado")));
            Marca marca = MarcaDAO.obterInstancia().obterMarca(Integer.parseInt(request.getParameter("txtIdMarca")));
            Automovel automovel = new Automovel(placa);
        
            automovel.setMarcaidMarca(marca);
            automovel.setEstadoidEstado(estado);
            
            AutomovelDAO.obterInstancia().gravar(automovel);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAutomovelController");
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
            Logger.getLogger(ManterAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
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
