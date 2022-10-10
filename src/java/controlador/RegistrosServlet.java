/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Listado;
import modelo.Registro;

/**
 *
 * @author pipe
 */
@WebServlet(name = "RegistrosServlet", urlPatterns = {"/RegistrosServlet"})
public class RegistrosServlet extends HttpServlet {
    private final static Logger LOG = Logger.getLogger(RegistrosServlet.class.getName());
    

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
            out.println("<title>Servlet RegistrosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrosServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        
        String respuesta;
        ArrayList<String> errores = new ArrayList<String>();
        
        //Recibiendo parametros
        int id = 0, peso = 0, centro = 0;
        String nombre = request.getParameter("nombre");
        String centroP = request.getParameter("centro");
        
        
        Date fecha = new Date();
        
        
        boolean prematuro = false;
        char sex = ' ';
        if("f".equals(request.getParameter("sexo"))){sex = 'F';}
        if("m".equals(request.getParameter("sexo"))){sex = 'M';}
        if("Si".equals(request.getParameter("prematuro"))){prematuro = true;}
        if("No".equals(request.getParameter("prematuro"))){prematuro = false;}
        
        
        
        //Validadores
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch(Exception e){
            errores.add("Debe ingresar id");
            //validar numero
        }
        
        if (nombre.isEmpty()) {
            errores.add("Debe ingresar nombre");
        }
        try{
            peso = Integer.parseInt(request.getParameter("peso"));
        }
        catch(Exception e){
            errores.add("Debe ingresar peso");
            //Validar numero
        }
        if (centroP.equals("Seleccione")) {
            errores.add("Debe ingresar centro");
        }else{
            centro = Integer.parseInt(centroP);
        }
        
        
        //Logica de negocio
        if (errores.size() == 0) {
            Registro reg = new Registro(
                id,
                peso,
                centro,
                nombre,
                fecha,
                prematuro,
                sex
            );
            HttpSession session = request.getSession();
            Listado listado = (Listado) session.getAttribute("listado");
            
            if (listado == null) {
                listado = new Listado();
                session.setAttribute("listado", listado);
            }
            listado.agregarRegistro(reg);
            respuesta = "Se ha registrado el nacimiento correctamente";
            
            LOG.log(Level.INFO, "Proceso exitoso", request);
            
        } else {
            respuesta = "No se ha podido registrar el nacimiento";
            LOG.log(Level.SEVERE, "Proceso NO exitoso");
        }
        
        
        
        //Despachar vista
        request.setAttribute("respuesta", respuesta);
        request.setAttribute("error", errores);
        
        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
        despachador.forward(request, response);  
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
