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
public class Delito {
    private int codigo;
    private String name;
    
    public static ArrayList<Delito> LDelitos = new ArrayList<Delito>();
    
    public Delito(int codigo, String nombre) {
        this.codigo = codigo;
        this.name = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Delito> getLDelitos() {
        return LDelitos;
    }
    
    
}
