/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Producto;
import modelo.RegistroProducto;

/**
 *
 * @author yayi
 */
@WebServlet(name = "agregarProductoServlet", urlPatterns = {"/agregarProductoServlet"})
public class agregarProductoServlet extends HttpServlet {
    private final static Logger LOG = Logger.getLogger(agregarProductoServlet.class.getName());
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet agregarProductoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet agregarProductoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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

        int codigo = 0, precio = 0, cc = 0;
        ArrayList<String> errores = new ArrayList<String>();
        String respuesta;

        response.setContentType("text/html;charset=UTF-8");

        //recibir parámetros
        String codigoP = request.getParameter("codigo");
        String descripcion = request.getParameter("descripcion");
        String categoria = request.getParameter("categoria");
        String precioP = request.getParameter("precio");
        String ccP = request.getParameter("cc");

        //validar parámetros
        if (codigoP.isEmpty()) {
            errores.add("Ingrese código");
        }

        if (descripcion.isEmpty()) {
            errores.add("Ingrese descripción");
        }

        if (categoria.equals("Seleccione")) {
            errores.add("Seleccione categoría");
        }

        if (precioP.isEmpty()) {
            errores.add("Ingrese precio");
        }

        if (ccP.isEmpty()) {
            errores.add("Ingrese cc");
        }

        try {
            codigo = Integer.parseInt(codigoP);
        } catch (Exception e) {
            errores.add("El código debe ser un número");
        }

        try {
            precio = Integer.parseInt(precioP);
        } catch (Exception e) {
            errores.add("El precio debe ser un número");
        }

        try {
            cc = Integer.parseInt(ccP);
        } catch (Exception e) {
            errores.add("cc debe ser un número");
        }

        if (codigo <= 0) {
            errores.add("El código debe ser mayor a 0");
        }
        if (precio <= 0) {
            errores.add("El precio debe ser mayor a 0");
        }
        if (cc <= 0) {
            errores.add("cc debe ser mayor a 0");
        }
        descripcion = descripcion.toUpperCase();
        categoria = categoria.toUpperCase();
    

        //ejecutar lógica de negocio
        if (errores.size() == 0) {
            Producto productito = new Producto(codigo, descripcion, categoria, precio, cc);

            // agregar mensaje a la session
            HttpSession session = request.getSession();
            RegistroProducto registroProd = (RegistroProducto) session.getAttribute("registro");
            if (registroProd == null) {
                registroProd = new RegistroProducto();
                session.setAttribute("registro", registroProd);
            }
            registroProd.agregarProducto(productito);
            
            respuesta = "Tu Producto se ingresó exitosamente";
            
            LOG.log(Level.INFO, "Proceso exitoso", request);
            
        } else {
            respuesta = "Tu Producto no se ingresó";
            
            LOG.log(Level.SEVERE, "Proceso NO exitoso");
        }

        //despachar vista
        request.setAttribute("respuesta", respuesta);
        request.setAttribute("error", errores);

        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
        despachador.forward(request, response);
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
