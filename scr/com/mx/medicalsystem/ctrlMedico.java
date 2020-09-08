import javax.swing.*;
import java.sql.*;

public class ctrlMedico{
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
	
	public void insertaMedico(String id, String nom, String apepat,String apemat,String espe,String tur,
	String direccion, String  colonia,String delegacion,String estado,int cp, int tel,String  cedula,String consul){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("insert into Medico values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			sentencia.setString(1, id);
			sentencia.setString(2, nom);
			sentencia.setString(3, apepat);
			sentencia.setString(4, apemat);
			sentencia.setString(5, espe);
			sentencia.setString(6, tur);
			sentencia.setString(7, direccion);
			sentencia.setString(8, colonia);
		    sentencia.setString(9, delegacion);
			sentencia.setString(10, estado);
			sentencia.setInt(11, cp);
			sentencia.setInt(12, tel);
			sentencia.setString(13, cedula);
			sentencia.setString(14, consul);
		
			sentencia.executeUpdate();
			
			sentencia.close();
			conexion.close();
			
			msgInf("Los datos han sido guardados");
		}catch(Exception err){
			msgError("Alguno de los datos insertados es incorrecto: "+ err);
		}
	}
	
	public void eliminaMedico(String id){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("delete from Medico where IdMedico=?");
			sentencia.setString(1, id);
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido eliminado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
		}
	}
	
	public void actualizaMedico(String id, String nom, String apepat,String apemat,String espe,String tur,
	String direccion, String  colonia,String delegacion,String estado,int cp, int tel,String  cedula,String consul){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement(
			"update Medico set IdMedico=?,NombreMedico=?, ApellidoPat=?, ApellidoMat=?, " +
			"IdEspecialidad=?,IdTurno=?, CalleNumero=?,Colonia=?,Delegacion=?,"+
			"Estado=?,CP=?,Telefono=?,Cedula=?,IdConsultorio=? where IdMedico=?");
			
			sentencia.setString(1, id);
			sentencia.setString(2, nom);
			sentencia.setString(3, apepat);
			sentencia.setString(4, apemat);
			sentencia.setString(5, espe);
			sentencia.setString(6, tur);
			sentencia.setString(7, direccion);
			sentencia.setString(8, colonia);
		    sentencia.setString(9, delegacion);
			sentencia.setString(10, estado);
			sentencia.setInt(11, cp);
			sentencia.setInt(12, tel);
			sentencia.setString(13, cedula);
			sentencia.setString(14, consul);
			sentencia.setString(15, id);
			
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
    	JOptionPane.showMessageDialog(null, inf, "Información", JOptionPane.WARNING_MESSAGE);
    }
    
}