package com.mx.medicalsystem.dao;

import javax.swing.*;
import java.sql.*;

public class ctrlProveedor{
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
	
	public void insertaProveedor(String lblIdProveedor, String lblNombreProveedo, String apepat,String apemat,
    int lblTelefono,String direccion,String  colonia,String delegacion, String estado ,int cp){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("insert into Proveedor values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			sentencia.setString(1, lblIdProveedor);
			sentencia.setString(2,  lblNombreProveedo);
			sentencia.setString(3, apepat);
			sentencia.setString(4, apemat);
			sentencia.setInt(5,lblTelefono);
			sentencia.setString(6, direccion);
			sentencia.setString(7, colonia);
			sentencia.setString(8, delegacion);
			sentencia.setString(9, estado);
			sentencia.setInt(10, cp);
		
			
			sentencia.executeUpdate();
			
			sentencia.close();
			conexion.close();
			
			msgInf("Los datos han sido guardados");
		}catch(Exception err){
			msgError("Alguno de los datos insertados es incorrecto: "+ err);
		}
	}
	
	public void eliminaProveedor(String  lblIdProveedor){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("delete from Proveedor where IdProveedor=?");
			sentencia.setString(1, lblIdProveedor);
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido eliminado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
		}
	}
	
	public void actualizaProveedor(String lblIdProveedor, String lblNombreProveedo, String apepat,String apemat,
    int lblTelefono,String direccion,String  colonia,String delegacion, String estado ,int cp){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement(
			"update Proveedor set IdProveedor=?, NombreProveedpr=?, ApePat=?, ApeMat=?, " +
			"Telefono=?, CalleNumero=?, Colonia=?,Delegacion=?,Estado=?,CP=? where IdProveedor=?");
			
			sentencia.setString(1,lblIdProveedor);
			sentencia.setString(2, lblNombreProveedo);
			sentencia.setString(3, apepat);
			sentencia.setString(4, apemat);
			sentencia.setInt(5, lblTelefono);
			sentencia.setString(6,direccion);
			sentencia.setString(7, colonia);
			sentencia.setString(8, delegacion);
			sentencia.setString(9,  estado);
			sentencia.setInt(10,  cp);
			sentencia.setString(11, lblIdProveedor);
			
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