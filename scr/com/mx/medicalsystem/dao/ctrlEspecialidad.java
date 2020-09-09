package com.mx.medicalsystem.dao;

import javax.swing.*;
import java.sql.*;

public class ctrlEspecialidad{
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
	
	public void insertaEspecialidad(String id, String descri ){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("insert into Especialidad values(?, ?)");
			
			sentencia.setString(1, id);
			sentencia.setString(2, descri);
			
			
			sentencia.executeUpdate();
			
			sentencia.close();
			conexion.close();
			
			msgInf("Los datos han sido guardados");
		}catch(Exception err){
			msgError("Alguno de los datos insertados es incorrecto: "+ err);
		}
	}
	
	public void EliminaEspecialidad(String id){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("delete from Especialidad where IdEspecialidad=?");
			sentencia.setString(1, id);
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido eliminado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
		}
	}
	
	public void actualizaEspecialidad(String id, String descri){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement(
			"update Especialidad set IdEspecialidad=?, Descripcion=? where IdEspecialidad=?");
			
			sentencia.setString(1, id);
			sentencia.setString(2, descri);
			sentencia.setString(3, id);
			
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido actualizado satisfactoriamente");
		}catch(Exception err){
			
			err.printStackTrace();
			msgError("La clave no existe." + "\nNo es posible actualizar el registro: " + err);
		}
	}
    
    public void msgError(String error){
    	JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void msgInf(String inf){
    	JOptionPane.showMessageDialog(null, inf, "Informaci�n", JOptionPane.WARNING_MESSAGE);
    }
    
}