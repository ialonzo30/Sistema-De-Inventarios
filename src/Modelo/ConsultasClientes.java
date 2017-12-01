
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasClientes extends Conexion{   
public boolean registrar(clientes pro){
        PreparedStatement ps= null;
        Connection con= getConexion();
    String sql = " INSERT INTO clientes(NIT, nombre, telefono, direccion) VALUES(?,?,?,?) ";
    try{
        ps=con.prepareStatement(sql);
        ps.setString(1,pro.getNIT());
        ps.setString(2,pro.getNombre());
        ps.setString(3,pro.getTelefono());
        ps.setString(4,pro.getDireccion());
        ps.execute();
           return true;
    }catch(SQLException e){
        System.err.println(e);
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
               System.err.println(e);
        }
    }
   
    }
public boolean modificar(clientes pro){
        PreparedStatement ps= null;
        Connection con= getConexion();
    String sql = " UPDATE clientes SET nombre=?, telefono=?, direccion=? WHERE NIT=? ";
    try{
        ps=con.prepareStatement(sql);
        ps.setString(1,pro.getNombre());
        ps.setString(2,pro.getTelefono());
        ps.setString(3,pro.getDireccion());
        ps.setString(4,pro.getNIT());
        ps.execute();
        return true;
    }catch(SQLException e){
        System.err.println(e);
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
               System.err.println(e);
        }
    }
   
    }
public boolean eliminar(clientes pro){
        PreparedStatement ps= null;
        Connection con= getConexion();
    String sql = " DELETE FROM clientes  WHERE NIT=? ";
    try{
        ps=con.prepareStatement(sql);
        ps.setString(1,pro.getNIT());
        ps.execute();
        return true;
    }catch(SQLException e){
        System.err.println(e);
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
               System.err.println(e);
        }
    }
   
    }    
public boolean buscar(clientes pro){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con= getConexion();
    String sql = " SELECT * FROM clientes  WHERE nombre=? ";
    try{
        ps=con.prepareStatement(sql);
        ps.setString(1,pro.getNombre());
       rs= ps.executeQuery();
       
       if(rs.next()){
           pro.setNIT(rs.getString("NIT"));
           pro.setNombre(rs.getString("nombre"));
           pro.setTelefono(rs.getString("telefono"));
           pro.setDireccion(rs.getString("direccion"));
           return true;
       }
       
        return false;
    }catch(SQLException e){
        System.err.println(e);
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
               System.err.println(e);
        }
    }
   
    }    
    
    
}
