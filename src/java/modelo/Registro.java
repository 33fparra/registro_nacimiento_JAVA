/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro implements Serializable {
    private int id, peso, centro;
    private String nombre;
    private Date fechaNacimiento;
    private String fechaFormato;
    private boolean prematuro;
    private char sexo;

    public Registro(int id, int peso, int centro, String nombre, Date fechaNacimiento, boolean prematuro, char sexo) {
        this.id = id;
        this.peso = peso;
        this.centro = centro;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.prematuro = prematuro;
        this.sexo = sexo;
    }

    public Registro() {
    }

    public String getFechaFormato() {
        return fechaFormato;
    }

    public void setFechaFormato(String fechaFormato) {
        this.fechaFormato = fechaFormato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCentro() {
        return centro;
    }

    public void setCentro(int centro) {
        this.centro = centro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    
    public boolean isPrematuro() {
        return prematuro;
    }

    public void setPrematuro(boolean prematuro) {
        this.prematuro = prematuro;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", peso=" + peso + ", centro=" + centro + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", prematuro=" + prematuro + ", sexo=" + sexo + '}';
    }
    
}
