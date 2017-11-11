/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Julito
 */
public class Consultaproducto extends Conexion {
    
    public boolean Registrar(producto pro){
        PreparedStatement ps = null;
        Connection con = getConexion ();
        
        String sql = "INSERT INTO producto (Idproducto, nombre, precio, UnidadDeMedida) VALUES (?,?,?,?) ";
        
        try
        {
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getIdproducto());
        ps.setString(2, pro.getNombre());
        ps.setDouble(3, pro.getPrecio());
        ps.setString(4, pro.getUnidadDeMedida());
        ps.execute();
        return true;
        
        } 
        catch (SQLException e)
        {
            System.err.println (e);
            return false;
            
        } finally {
            try {
                con.close();
                }
            catch (SQLException e)
                    {
                System.err.println (e);
            }
        }
        
    }
    
    public boolean Modificar (producto pro){
        PreparedStatement ps = null;
        Connection con = getConexion ();
        
        String sql = "UPDAT producto SET Idproducto=?, nombre=?, precio=?, UnidadDeMedida=? WHERE id=? ";
        
        try
        {
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getIdproducto());
        ps.setString(2, pro.getNombre());
        ps.setDouble(3, pro.getPrecio());
        ps.setString(4, pro.getUnidadDeMedida());
        ps.execute();
        return true;
        
        } 
        catch (SQLException e)
        {
            System.err.println (e);
            return false;
            
        } finally {
            try {
                con.close();
                }
            catch (SQLException e)
                    {
                System.err.println (e);
            }
        }
        
    }

public boolean Eliminar (producto pro){
        PreparedStatement ps = null;
        Connection con = getConexion ();
        
        String sql = "DELETE FROM producto WHERE id=? ";
        
        try
        {
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getIdproducto());
        ps.execute();
        return true;
        
        } 
        catch (SQLException e)
        {
            System.err.println (e);
            return false;
            
        } finally {
            try {
                con.close();
                }
            catch (SQLException e)
                    {
                System.err.println (e);
            }
        }
        
    }

public boolean Buscar (producto pro){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion ();
        
        String sql = "SELEC * FROM producto WHERE Idproducto=? ";
        
        try
        {
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getIdproducto());
        rs = ps.executeQuery();
        
        if (rs.next())
        {    
         pro.setIdproducto(rs.getString("Idproducto"));
         pro.setNombre(rs.getString("Nombre"));
         pro.setPrecio(Double.parseDouble(rs.getString("Precio")));
         pro.setUnidadDeMedida(rs.getString("UnidadDeMedida"));
         return true;
                 }   
         
      
        return false;
        
        } 
        catch (SQLException e)
        {
            System.err.println (e);
            return false;
            
        } finally {
            try {
                con.close();
                }
            catch (SQLException e)
                    {
                System.err.println (e);
            }
        }
        
    }

}
