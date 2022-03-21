/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Preso {
    private String codigo;
    private String nombre;
    private String alias;
    private String Pais;
    private Date Fec_Nac;
    private int Recompensa;
    private int organizacion;
    private int tipo;
    private Date Fec_1Del;
    private int cant_Del;
    private String codigoA;
    private int codigoR;
    
    public static ArrayList<Preso> listaPresos = new ArrayList<>();

    public Preso() {
        
    }
    
    public Preso( String codigo, String nombre, String alias, String Pais, Date Fec_Nac, int Recompensa,
                            int organizacion, int tipo , Date Fec_1Del, int cant_Del, String codigoA, int codigoR) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.alias = alias;
    this.Pais = Pais;
    this.Fec_Nac = Fec_Nac;
    this.Recompensa = Recompensa;
    this.organizacion = organizacion;
    this.tipo = tipo;
    this.Fec_1Del = Fec_1Del;
    this.cant_Del = cant_Del;
    this.codigoA = codigoA;
    this.codigoR = codigoR;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public String getPais() {
        return Pais;
    }

    public Date getFec_Nac() {
        return Fec_Nac;
    }

    public int getRecompensa() {
        return Recompensa;
    }

    public int getOrganizacion() {
        return organizacion;
    }

    public int getTipo() {
        return tipo;
    }

    public Date getFec_1Del() {
        return Fec_1Del;
    }

    public int getCant_Del() {
        return cant_Del;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public void setFec_Nac(Date Fec_Nac) {
        this.Fec_Nac = Fec_Nac;
    }

    public void setRecompensa(int Recompensa) {
        this.Recompensa = Recompensa;
    }

    public void setOrganizacion(int organizacion) {
        this.organizacion = organizacion;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setFec_1Del(Date Fec_1Del) {
        this.Fec_1Del = Fec_1Del;
    }

    public void setCant_Del(int cant_Del) {
        this.cant_Del = cant_Del;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public int getCodigoR() {
        return codigoR;
    }

    public static ArrayList<Preso> getListaPresos() {
        return listaPresos;
    }
    
    
    
    
}
