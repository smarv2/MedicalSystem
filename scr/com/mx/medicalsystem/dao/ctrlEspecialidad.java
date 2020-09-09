package com.mx.medicalsystem.dao;

import static com.mx.medicalsystem.blogic.Especialidad.ctrlEsp;
import com.mx.medicalsystem.util.ConexionMySQL;
import com.mx.medicalsystem.util.Utils;
import java.sql.*;

public class ctrlEspecialidad {
    
    Utils utils = new Utils();

    /*public static String url = "jdbc:odbc:Driver={Microsoft Access driver (*.mdb)};DBQ=Clinica.mdb";
    public static final String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    public static final String usuario = "";
    public static final String password = "";

    public static Connection conexion;
    public static PreparedStatement sentencia;
    public static ResultSet resultado;

    public void conexion() {
        try {
            Class.forName(driver);
        } catch (Exception noDriver) {
            try {
                Class.forName(url);
            } catch (Exception noURL) {
                msgError("La URL o driver no existen: " + noURL);
            }
        }
    }*/
    public void insertaEspecialidad(String id, String descri) {
        PreparedStatement sentencia;
        try {

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            //conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement("insert into especialidades values(?, ?)");

            sentencia.setString(1, id);
            sentencia.setString(2, descri);

            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            utils.msgInf("Los datos han sido guardados");
        } catch (Exception e) {
            utils.msgError("Error al guardar el registro de especialidad.");
            System.err.println("Error en metiodo insertaEspecialidad: " + e);
        }
    }

    public void eliminaEspecialidad(String id) {
        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            sentencia = conexion.prepareStatement("delete from especialidades where idEspecialidad=?");
            sentencia.setString(1, id);
            sentencia.executeUpdate();

            utils.msgInf("El registro ha sido eliminado satisfactoriamente");
        } catch (Exception e) {
            utils.msgError("Error al eliminar la especialidad.");
            System.err.println("Error en metodo eliminaEspecialidad: " + e);
        }
    }

    public void actualizaEspecialidad(String id, String descri) {
        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);
            
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            
            sentencia = conexion.prepareStatement(
                    "update especialidades set idEspecialidad=?, descripcionEspecialidad=? where idEspecialidad=?");

            sentencia.setString(1, id);
            sentencia.setString(2, descri);
            sentencia.setString(3, id);

            sentencia.executeUpdate();

            utils.msgInf("El registro ha sido actualizado satisfactoriamente");
        } catch (Exception e) {
            utils.msgError("Error al actualizar la especialidad.");
            System.err.println("Error en metodo actualizaEspecialidad: " + e);
        }
    }
    
    public String buscaEspecialidad(int idEspecialidad) {
        PreparedStatement sentencia;
        String descripcionEspecialidad = null;
        try {
            //Connection conexion = DriverManager.getConnection(ctrlEsp.url);
            
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            
            sentencia = conexion.prepareStatement("select * from especialidades where idEspecialidad=?");
            sentencia.setInt(1, idEspecialidad);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                descripcionEspecialidad = resultado.getString("descripcionEspecialidad");

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                utils.msgError("La clave a buscar no existe");
            }
        } catch (Exception e) {
            utils.msgError("Error al buscar la especialidad.");
            System.err.println("Error en el metodo buscaEspecialidad: " + e);
        }
        return descripcionEspecialidad;
    }

}
