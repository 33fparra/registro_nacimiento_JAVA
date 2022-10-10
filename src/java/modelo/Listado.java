/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
/**
 *
 * @author pipe
 */

public class Listado implements Serializable {
    private static ArrayList<Registro> lstRegistros;
    private String fechaFormato;
    public Listado() {
        lstRegistros = new ArrayList<Registro>();
    }
    
    public boolean agregarRegistro(Registro reg){
        setFechaFormato(reg.getFechaNacimiento());
        reg.setFechaFormato(fechaFormato);
        return lstRegistros.add(reg);
    }

    public ArrayList<Registro> getLstRegistros() {
        return lstRegistros;
    }
    
    public static void eliminarRegistro(Registro registroEliminar){
        lstRegistros.remove(registroEliminar);
        
    }
    
    public String getFechaFormato() {
        return fechaFormato;
    }

    public void setFechaFormato(Date fecha) {
        String strDateFormat = "dd/MM/YYYY HH:mm:ss";  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 
        this.fechaFormato = objSDF.format(fecha);
    }
    
    public static Registro buscarRegistro(int codigo){
        Registro reg = null;
        for(Registro temp:lstRegistros) {
            if(temp.getId() == codigo){
                reg = temp;
                break;
            }
        }
        return reg;
    }
}
