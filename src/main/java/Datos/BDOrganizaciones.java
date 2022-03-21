/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Objeto.Grupo_Criminal;
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
public class BDOrganizaciones {
    
    private ResultSet rs = null;
    private Statement s = null;
    BDConexion conexion = new BDConexion();
    private Connection connection = null;
    
     public String cargarORG(int T) {
        String Tipo = "";
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre FROM  \"Organizaciones\" WHERE codigo = " + T );
            while (rs.next()) {
                Tipo = rs.getString("nombre");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return Tipo;
    }
     
     public ArrayList<Grupo_Criminal> cargarORGS() {
         Grupo_Criminal.listaGCriminales.clear();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Organizaciones\" ORDER BY nombre ASC");
            while (rs.next()) {
                Grupo_Criminal.listaGCriminales.add(new Grupo_Criminal(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("descripcion")));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return Grupo_Criminal.getListaGCriminales();
    }
}
