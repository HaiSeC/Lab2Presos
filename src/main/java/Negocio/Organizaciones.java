/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.BDOrganizaciones;
import Objeto.Grupo_Criminal;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Organizaciones {
    private int codigo;
    private String nombre;
    private String Descripcion;
    
    BDOrganizaciones bd = new BDOrganizaciones();
    
    public String getORG(int ORGN) {
        return bd.cargarORG(ORGN);
    }
    
    public ArrayList<Grupo_Criminal> cargarOrganizaciones() {
        return bd.cargarORGS();
    }
    public ArrayList<Grupo_Criminal> ObtenerLista() {
        return bd.cargarORGS();
    }
    
    
    public int getCode(int IND) {
          return ObtenerLista().get(IND).getCodigo();
    }
}
