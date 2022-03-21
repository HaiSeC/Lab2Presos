/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.BDAgentes;
import Objeto.Policia;
import java.util.ArrayList;



/**
 *
 * @author Cris
 */
public class Agentes {
    BDAgentes bd = new BDAgentes();
    
    public ArrayList<Policia> cargarAgentes() {
        return bd.cargarAgentes();
    }
    
    public ArrayList<Policia> ObtenerLista() {
        return Policia.getPolicias();
    }
    
    
    public void Agregar(Policia Agente) {
        bd.insertarAgente(Agente);
    }
    
    public void Actualizar(Policia Agente) {
        bd.modificarPreso(Agente);
    }

    public void Eliminar(Policia Agente) {
        bd.eliminarAgente(Agente);
    }    
    
      public String getCode(int IND) {
          return ObtenerLista().get(IND).getCodigo();
      }
    
 
}
