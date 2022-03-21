/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Objeto.Policia;
import Objeto.Preso;
import datos.BDConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class BDAgentes {
   
    private ResultSet rs = null;
    private Statement s = null;
    BDConexion conexion = new BDConexion();
    private Connection connection = null;

    public void insertarAgente(Policia Policia) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Agentes\" (codigo,nombre,direccion, telefono) VALUES ('" + Policia.getCodigo()+ "','" + Policia.getNombre() + "','" + Policia.getDireccion() +"','" + Policia.getTelefono()+ "')");
            if ((z == 1)) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el registro", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Policia> cargarAgentes() {
        Policia.policias.clear();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Agentes\" ORDER BY nombre ASC");
            while (rs.next()) {
                Policia.policias.add(new Policia(rs.getString("codigo"), rs.getString("nombre"), rs.getString("direccion"),rs.getInt("telefono")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return Policia.policias;        
    }
    
    public void modificarPreso(Policia Agente) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("Update \"Agentes\" SET nombre='"+ Agente.getNombre() + "', direccion='" + Agente.getDireccion() + "' telefono='" + Agente.getTelefono() +"' WHERE codigo ='" + Agente.getCodigo() + "'");
            if ((z == 1)) {
                JOptionPane.showMessageDialog(null, "Se modificó el registro correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el registro", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  
    
    public void eliminarAgente(Policia Agente) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z1 = s.executeUpdate("DELETE FROM \"Agentes\" WHERE codigo = '" + Agente.getCodigo() + "'");
            if ( (z1 == 1)) {
                JOptionPane.showMessageDialog(null, "Se eliminó el registro correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
}
