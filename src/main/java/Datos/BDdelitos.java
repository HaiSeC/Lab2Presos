/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Objeto.Delito;
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
public class BDdelitos {
    private ResultSet rs = null;
    private Statement s = null;
    BDConexion conexion = new BDConexion();
    private Connection connection = null;  
    
        public String cargarTipo(int T) {
        String Tipo = "";
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre FROM  \"Tipos\" WHERE codigo = " + T );
            while (rs.next()) {
                Tipo = rs.getString("nombre");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return Tipo;
    }
    public ArrayList<Delito> cargarDelitos() {
        Delito.LDelitos.clear();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Tipos\" ORDER BY nombre ASC");
            while (rs.next()) {
                Delito.LDelitos.add(new Delito(rs.getInt("codigo"), rs.getString("nombre")));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return Delito.getLDelitos();
    }
    
        
}
