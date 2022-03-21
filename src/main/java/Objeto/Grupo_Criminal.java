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
public class Grupo_Criminal {
    private int codigo;
    private String nombre;
    private String descripcion;
    
    public static ArrayList<Grupo_Criminal> listaGCriminales = new ArrayList();
    
    public Grupo_Criminal(int code, String name, String desc) {
        this. codigo = code;
        this.nombre = name;
        this.descripcion = desc;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static ArrayList<Grupo_Criminal> getListaGCriminales() {
        return listaGCriminales;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
