package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProveedor extends Conexion {

    public boolean registrar(proveedor pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO proveedores (nit, nombre, telefono , direccion) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNit());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getTelefono());
            ps.setString(4, pro.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(proveedor pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE proveedores SET nombre=?, telefono=?, direccion=? WHERE nit=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getTelefono());
            ps.setString(3, pro.getDireccion());
            ps.setString(4, pro.getNit());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(proveedor pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM proveedores WHERE nit=? ";

        try {
            ps = con.prepareStatement(sql);
           ps.setString(1, pro.getNit());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(proveedor pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM proveedores WHERE nit=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNit());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               pro.setNit(rs.getString("nit"));
               pro.setNombre(rs.getString("nombre"));
               pro.setTelefono(rs.getString("telefono"));
               pro.setDireccion(rs.getString("direccion"));
             
               return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}

