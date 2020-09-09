package com.mx.medicalsystem.dao;

import javax.swing.*;
import java.sql.*;

public class crlCompras{
    public static String url = "jdbc:odbc:Driver={Microsoft Access driver (*.mdb)};DBQ=Clinica.mdb";
	public static final String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	public static final String usuario="";
	public static final String password="";
	
	public static Connection conexion;
	public static PreparedStatement sentencia;
	public static ResultSet resultado;
	
	public void conexion(){
		try{
			Class.forName(driver);
		}catch(Exception noDriver){
			try{
				Class.forName(url);
			}catch(Exception noURL){
				msgError("La URL o driver no existen: " + noURL);
			}
		}
	}
	
	public void insertaCompras(String lblIdMedicamento, String lblIdProveedor,
	Double lblPrecioCompra, String lblUltimaFecha, int lblCantidadCompra){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("insert into Compras values(?, ?, ?, ?, ?)");
			
			sentencia.setString(1, lblIdMedicamento);
			sentencia.setString(2, lblIdProveedor);
			sentencia.setDouble(3, lblPrecioCompra);
			sentencia.setString(4, lblUltimaFecha);
			sentencia.setInt(5, lblCantidadCompra);
			
			
			sentencia.executeUpdate();
			
			sentencia.close();
			conexion.close();
			
			msgInf("Los datos han sido guardados");
		}catch(Exception err){
			msgError("Alguno de los datos insertados es incorrecto: "+ err);
		}
	}
	
	public void eliminaCompras(String lblIdMedicamento){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("delete from Compras where IdMedicamento=?");
			sentencia.setString(1, lblIdMedicamento);
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido eliminado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
		}
	}
	
	public void actualizaCompras(String lblIdMedicamento, String lblIdProveedor,
	Double lblPrecioCompra, String lblUltimaFecha, int lblCantidadCompra){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement(
			"update Compras set IdMedicamento=?, IdProveedor=?, PrecioCompra=?, FechaCompra=?, " +
			"CantidadCompra=? where IdMedicamento=?");
			
			sentencia.setString(1, lblIdMedicamento);
			sentencia.setString(2, lblIdProveedor);
			sentencia.setDouble(3, lblPrecioCompra);
			sentencia.setString(4, lblUltimaFecha);
			sentencia.setInt(5, lblCantidadCompra);
			sentencia.setString(6, lblIdMedicamento);
			
			
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido actualizado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido: " + err);
		}
	}
    
    public void msgError(String error){
    	JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void msgInf(String inf){
    	JOptionPane.showMessageDialog(null, inf, "Informaci�n", JOptionPane.WARNING_MESSAGE);
    }
    
}
    
