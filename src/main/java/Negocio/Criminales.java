/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.BDCriminales;
import Datos.BDOrganizaciones;
import Datos.BDdelitos;
import Objeto.Preso;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Criminales {
    BDCriminales bd = new BDCriminales();

    public void AgregarCriminal(Preso pr) {
        bd.insertarCriminal(pr);
    }
    
 
    
    public ArrayList<Preso> cargarCriminales() {    
        return bd.cargarCriminales();
    }
    
    public ArrayList<Preso> ObtenerLista() {
        return Preso.getListaPresos();
    }

    public ArrayList<Preso> ObtenerListaA(String indx) {
        return bd.cargardesdePoli(indx);
    }
    
    public void Actualizar(Preso criminal) {
        bd.modificarPreso(criminal);
    }
    
}
