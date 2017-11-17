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
 * @author yulio_94
 */
public class TiposDeMovimientoSQL extends Conexion{
        
        public boolean Registrar(TiposDeMovimiento tdm)
    {
        PreparedStatement ps = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "INSERT INTO tipodemovimientos(tipodemovimiento,descripcion,signo)"+
                "values(?,?,?)";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tdm.getTipodemovimiento());
            ps.setString(2, tdm.getDescripcion());
            ps.setInt(3, tdm.getSigno());
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
    
     public boolean Modificar(TiposDeMovimiento tdm)
    {
        PreparedStatement ps = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "UPDATE tipodemovimientos SET descripcion=?, signo=?"+
                "where tipodemovimiento = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tdm.getTipodemovimiento());
             ps.setString(2, tdm.getDescripcion());
             ps.setInt(3, tdm.getSigno());
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
     
     public boolean Eliminar(TiposDeMovimiento tdm)
    {
        PreparedStatement ps = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "Delete FROM tipodemovimientos where tipodemovimiento = ?";
        try
        {
            ps = con.prepareStatement(sql);
             ps.setInt(1, tdm.getTipodemovimiento());
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
     
         public boolean Buscar(TiposDeMovimiento tdm)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "SELECT tipodemovimiento, descripcion, signo FROM tipodemovimientos where tipodemovimiento = ?";
        try
        {
            ps = con.prepareStatement(sql);
             ps.setInt(1, tdm.getTipodemovimiento());
            rs = ps.executeQuery();
            if(rs.next())
            {
                tdm.setTipodemovimiento(rs.getInt("tipodemovimiento"));
                tdm.setDescripcion(rs.getString("descripcion"));
                tdm.setSigno(rs.getInt("signo"));
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
        
        
        
    

