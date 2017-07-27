package controller;

import dao.VendasDAO;
import dao.AutomovelDAO;
import dao.VendedorDAO;
import dao.CompradorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vendas;
import model.Automovel;
import model.Vendedor;
import model.Comprador;


public class ManterVendasController extends HttpServlet {

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
            request.setAttribute("automoveis", AutomovelDAO.obterInstancia().obterAutomoveis());
            request.setAttribute("vendedor", VendedorDAO.obterInstancia().obterVendedores());
            request.setAttribute("compradores",CompradorDAO.obterInstancia().obterCompradores());

            RequestDispatcher view = request.getRequestDispatcher("/manterVendas.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int idVendas = Integer.parseInt(request.getParameter("txtIdVendas"));
            String data = request.getParameter("txtNomeData");
            
            Automovel automovel = AutomovelDAO.obterInstancia().obterAutomovel(Integer.parseInt(request.getParameter("txtIdAutomovel")));
            Vendedor vendedor = VendedorDAO.obterInstancia().obterVendedor(Integer.parseInt(request.getParameter("txtIdVendedor")));
            Comprador comprador = CompradorDAO.obterInstancia().obterComprador(Integer.parseInt(request.getParameter("txtIdComprador")));
                       
            Vendas vendas = new Vendas(idVendas);
            vendas.setAutomovelplaca(automovel);
            vendas.setVendedoridVendedor(vendedor);
            vendas.setCompradoridComprador(comprador);
            
            VendasDAO.obterInstancia().gravar(vendas);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaVendasController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int idVendas = Integer.parseInt(request.getParameter("txtIdVendas"));
            Vendas vendas = VendasDAO.obterInstancia().obterVendas(idVendas);
            
            request.setAttribute("automoveis", AutomovelDAO.obterInstancia().obterAutomoveis());
            request.setAttribute("vendedor", VendedorDAO.obterInstancia().obterVendedores());
            request.setAttribute("compradores",CompradorDAO.obterInstancia().obterCompradores());
            RequestDispatcher view = request.getRequestDispatcher("/manterVendas.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int idVendas = Integer.parseInt(request.getParameter("txtIdVendas"));
            String data = request.getParameter("txtNomeData");
            
            Automovel automovel = AutomovelDAO.obterInstancia().obterAutomovel(Integer.parseInt(request.getParameter("txtIdAutomovel")));
            Vendedor vendedor = VendedorDAO.obterInstancia().obterVendedor(Integer.parseInt(request.getParameter("txtIdVendedor")));
            Comprador comprador = CompradorDAO.obterInstancia().obterComprador(Integer.parseInt(request.getParameter("txtIdComprador")));
                       
            Vendas vendas = new Vendas(idVendas);
            vendas.setAutomovelplaca(automovel);
            vendas.setVendedoridVendedor(vendedor);
            vendas.setCompradoridComprador(comprador);
            
            VendasDAO.obterInstancia().gravar(vendas);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaVendasController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("operacao", "Excluir");

            int idVendas = Integer.parseInt(request.getParameter("txtIdVendas"));
            Vendas vendas = VendasDAO.obterInstancia().obterVendas(idVendas);
            
            request.setAttribute("automoveis", AutomovelDAO.obterInstancia().obterAutomoveis());
            request.setAttribute("vendedor", VendedorDAO.obterInstancia().obterVendedores());
            request.setAttribute("compradores",CompradorDAO.obterInstancia().obterCompradores());
            RequestDispatcher view = request.getRequestDispatcher("/manterVendas.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int idVendas = Integer.parseInt(request.getParameter("txtIdVendas"));
            String data = request.getParameter("txtNomeData");
            
            Automovel automovel = AutomovelDAO.obterInstancia().obterAutomovel(Integer.parseInt(request.getParameter("txtIdAutomovel")));
            Vendedor vendedor = VendedorDAO.obterInstancia().obterVendedor(Integer.parseInt(request.getParameter("txtIdVendedor")));
            Comprador comprador = CompradorDAO.obterInstancia().obterComprador(Integer.parseInt(request.getParameter("txtIdComprador")));
                       
            Vendas vendas = new Vendas(idVendas);
            vendas.setAutomovelplaca(automovel);
            vendas.setVendedoridVendedor(vendedor);
            vendas.setCompradoridComprador(comprador);
            
            VendasDAO.obterInstancia().gravar(vendas);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaVendasController");
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
            Logger.getLogger(ManterVendasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVendasController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterVendasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVendasController.class.getName()).log(Level.SEVERE, null, ex);
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
