import javax.swing.*;
import java.sql.*;

public class ctrlMedicamentos{
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
	
	public void insertaMedicamento(String idMedicamento, String nombreMedicamento, String tipoMedicamento,
	Double precioVenta, int entradas, int salidas, int existencias){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("insert into Medicamento values(?, ?, ?, ?, ?, ?, ?)");
			
			sentencia.setString(1, idMedicamento);
			sentencia.setString(2, nombreMedicamento);
			sentencia.setString(3, tipoMedicamento);
			sentencia.setDouble(4, precioVenta);
			sentencia.setInt(5, entradas);
			sentencia.setInt(6, salidas);
			sentencia.setInt(7, existencias);
			
			sentencia.executeUpdate();
			
			sentencia.close();
			conexion.close();
			
			msgInf("Los datos han sido guardados");
		}catch(Exception err){
			msgError("Alguno de los datos insertados es incorrecto: "+ err);
		}
	}
	
	public void eliminaMedicamentos(String idMedicamento){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement("delete from Medicamento where IdMedicamento=?");
			sentencia.setString(1, idMedicamento);
			sentencia.executeUpdate();
			
			msgInf("El registro ha sido eliminado satisfactoriamente");
		}catch(Exception err){
			msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
		}
	}
	
	public void actualizaMedicamentos(String idMedicamento, String nombreMedicamento, String tipoMedicamento,
	Double precioVenta, int entradas, int salidas, int existencias){
		try{
			conexion=DriverManager.getConnection(url);
			sentencia=conexion.prepareStatement(
			"update Medicamento set IdMedicamento=?, NombreMedicamento=?, TipoMedicamento=?, PrecioVenta=?, " +
			"Entradas=?, Salidas=?, Existencias=? where IdMedicamento=?");
			
			sentencia.setString(1, idMedicamento);
			sentencia.setString(2, nombreMedicamento);
			sentencia.setString(3, tipoMedicamento);
			sentencia.setDouble(4, precioVenta);
			sentencia.setInt(5, entradas);
			sentencia.setInt(6, salidas);
			sentencia.setInt(7, existencias);
			sentencia.setString(8, idMedicamento);
			
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