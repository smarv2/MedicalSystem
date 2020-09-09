package com.mx.medicalsystem.dao;

import javax.swing.*;
import java.sql.*;

public class ctrlCitas{
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
	
	public void insertaCitas(String idmedico, String idpaciente, String fecha,
	String horario){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("insert into MedicoPaciente values(?, ?, ?, ?)");
			
			sentencia.setString(1, idmedico);
			sentencia.setString(2, idpaciente);
			sentencia.setString(3, fecha);
			sentencia.setString(4, horario);
			
			sentencia.executeUpdate();
			
			sentencia.close();
			conexion.close();
			
			msgInf("Los datos han sido guardados");
		}catch(Exception err){
			msgError("Alguno de los datos insertados es incorrecto: "+ err);
		}
	}
	
	public void eliminaCitas(String idmedico){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("delete from MedicoPaciente where IdMedico=?");
			sentencia.setString(1, idmedico);
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido eliminado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
		}
	}
	
	public void actualizaCitas(String idmedico, String idpaciente, String fecha,
	String horario){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement(
			"update MedicoPaciente set IdMedico=?, IdPaciente=?, Fecha=?, Horario=? where IdMedico=?");
			
			sentencia.setString(1, idmedico);
			sentencia.setString(2, idpaciente);
			sentencia.setString(3, fecha);
			sentencia.setString(4, horario);
			sentencia.setString(5, idmedico);
			
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