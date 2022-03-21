/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.BDdelitos;
import Objeto.Delito;
import Objeto.Preso;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Delitos {
   
    BDdelitos bd = new BDdelitos();
   
    
   public String getTipo(int tipoN) {
        return bd.cargarTipo(tipoN);
    }
    public ArrayList<Delito> cargarDelitos() {
        return bd.cargarDelitos();
    }   
    public ArrayList<Delito> ObtenerLista() {
        return Delito.getLDelitos();
    }   
    
    public int getCode(int IND) {
          return ObtenerLista().get(IND).getCodigo();
    }
    
    public ArrayList<String> cargarCantidadDelitos() {
        ArrayList<String> Estadisticas = new ArrayList<>();
        ArrayList<Delito> CD = new ArrayList<>();
        Criminales cr = new Criminales();
        ArrayList<Preso> AP = new ArrayList<>();
        AP = cr.cargarCriminales();
        CD = cargarDelitos();
        for (int i = 0; i < AP.size(); i++) {
            int tipo = AP.get(i).getTipo();
            for (int j = 0; j < CD.size(); j++) {
                int dl = CD.get(j).getCodigo();
                if (tipo == dl) {
                    Estadisticas.add(CD.get(j).getName());
                }
            }
        }
        return Estadisticas;
    }
 
    
}
