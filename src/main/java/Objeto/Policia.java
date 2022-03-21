/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Policia {
    private String codigo;
    private String Nombre;
    private String Direccion;
    private int telefono;
    
    public static ArrayList<Policia> policias = new ArrayList();
    
    public Policia() {
        
    }
    public Policia(String codigo, String Nombre, String dir, int cel) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Direccion = dir;
        this.telefono = cel;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public static ArrayList<Policia> getPolicias() {
        return policias;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public static void setPolicias(ArrayList<Policia> policias) {
        Policia.policias = policias;
    }
    
    
    
}
