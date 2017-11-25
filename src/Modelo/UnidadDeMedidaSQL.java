/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ialonzo
 */
public class UnidadDeMedidaSQL extends Conexion{
   /*public boolean Registrar(UnidadDeMedida um)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO UnidadesMedida(UnidadDeMedida,Descripcion)"+
                "values(?,?)";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, um.getUnidadDeMedida());
            ps.setString(2, um.getDescripcion());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }finally
        {
            try
            {
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    */
     public boolean Modificar(UnidadDeMedida um)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE UnidadesMedida SET Descripcion=?"+
                "where UnidadDeMedida = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, um.getDescripcion());
             ps.setString(2, um.getUnidadDeMedida());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }finally
        {
            try
            {
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
     
     public boolean Eliminar(UnidadDeMedida um)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "Delete FROM UnidadesMedida where UnidadDeMedida = ?";
        try
        {
            ps = con.prepareStatement(sql);
             ps.setString(1, um.getUnidadDeMedida());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }finally
        {
            try
            {
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
     
         public boolean Buscar(UnidadDeMedida um)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT UnidadDeMedida, Descripcion FROM UnidadesMedida where UnidadDeMedida = ?";
        try
        {
            ps = con.prepareStatement(sql);
             ps.setString(1, um.getUnidadDeMedida());
            rs = ps.executeQuery();
            if(rs.next())
            {
                um.setUnidadDeMedida(rs.getString("UnidadDeMedida"));
                um.setDescripcion(rs.getString("Descripcion"));
                return true;
            }
            return false;
        }catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }finally
        {
            try
            {
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
}
