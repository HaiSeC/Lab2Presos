/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

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
public class BDCriminales {

    private ResultSet rs = null;
    private Statement s = null;
    BDConexion conexion = new BDConexion();
    private Connection connection = null;

    
    public void insertarCriminal(Preso Preso) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Delincuentes\" (codigo,nombre,fecha_nacimineto, pais_origen, recompensa, alias, tipo, organizacion, cantidad_delitos, fecha_primer_delito) VALUES ('" + Preso.getCodigo()+ "','" + Preso.getNombre() + "','" + Preso.getFec_Nac() +"','" + Preso.getPais()+ "','" + Preso.getRecompensa()+ "','" + Preso.getAlias() + "','" + Preso.getTipo()+ "','" + Preso.getOrganizacion() + "','" + Preso.getCant_Del() + "','" + Preso.getFec_1Del() +"')");
            int zl = s.executeUpdate("INSERT INTO \"Relacion\" (codigo_agente, codigo_delincuente) VALUES ('" + Preso.getCodigoA() + "','" + Preso.getCodigo() +"')");
            if ((z == 1) && (zl == 1)) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el registro", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Preso> cargarCriminales() {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT e.codigo AS codigo, e.nombre AS nombre, e.fecha_nacimineto AS fecha_nacimineto, e.pais_origen AS pais_origen, e.recompensa AS recompensa, e.alias AS alias, e.tipo AS tipo, e.organizacion AS organizacion, e.cantidad_delitos AS cantidad_delitos, e.fecha_primer_delito AS fecha_primer_delito, n.codigo AS codigoR, n.codigo_agente AS codigoA, n.codigo_delincuente AS codigoD FROM \"Delincuentes\" e, \"Relacion\" n WHERE e.codigo = n.codigo_delincuente ORDER BY e.nombre ASC");
            while (rs.next()) {
                Preso.listaPresos.add(new Preso(rs.getString("codigo"), rs.getString("nombre"), rs.getString("alias"),rs.getString("pais_origen"), rs.getDate("fecha_nacimineto"), rs.getInt("recompensa"), rs.getInt("organizacion"), rs.getInt("tipo"), rs.getDate("fecha_primer_delito"),rs.getInt("cantidad_delitos"), rs.getString("codigoA"), rs.getInt("codigoR")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return Preso.listaPresos;
    }
    
   
    public void modificarPreso(Preso Preso) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("Update \"Delincuentes\" SET nombre='"+ Preso.getNombre() + "',fecha_nacimineto='" + Preso.getFec_Nac() +"',pais_origen ='" + Preso.getPais()+ "',recompensa ='" + Preso.getRecompensa()+ "',alias ='" + Preso.getAlias() + "',tipo ='" + Preso.getTipo()+ "',organizacion='" + Preso.getOrganizacion() + "',cantidad_delitos='" + Preso.getCant_Del() + "',fecha_primer_delito ='" + Preso.getFec_1Del() +"' WHERE codigo ='" + Preso.getCodigo() + "'");
            int zl = s.executeUpdate("Update \"Relacion\" SET codigo_agente='" + Preso.getCodigoA() +"' WHERE codigo='" + Preso.getCodigoR() + "'");
            if ((z == 1) && (zl == 1)) {
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

    public void eliminarPreso(String codigo, Integer codigoR) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Relacion\" WHERE codigo = '" + codigoR + "'");
            int z1 = s.executeUpdate("DELETE FROM \"Delincuentes\" WHERE codigo = '" + codigo + "'");
            if ((z == 1) && (z1 == 1)) {
                JOptionPane.showMessageDialog(null, "Se eliminó el registro correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList cargardesdePoli(String indx) {
        ArrayList arr1 = new ArrayList();
        
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT ag.nombre AS nombreA, e.nombre AS nombreD, e.alias AS aliasD, e.tipo AS tipo, e.organizacion AS organizacion " +
                                "FROM \"Delincuentes\" e, \"Relacion\" n, \"Agentes\" ag " +
                                "WHERE e.codigo = n.codigo_delincuente AND '" + indx + "' = n.codigo_agente AND '" + indx + "' = ag.codigo " +
                                "ORDER BY e.nombre ASC");
            while (rs.next()) {
                arr1.add(rs.getString("nombreA"));
                arr1.add(rs.getString("nombreD"));
                arr1.add(rs.getString("aliasD"));
                arr1.add(rs.getInt("tipo"));
                arr1.add(rs.getInt("organizacion"));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return arr1;        
    }
}
