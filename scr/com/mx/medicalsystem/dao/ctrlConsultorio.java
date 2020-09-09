package com.mx.medicalsystem.dao;

import com.mx.medicalsystem.util.ConexionMySQL;
import com.mx.medicalsystem.util.Utils;
import java.sql.*;

public class ctrlConsultorio {

    Utils utils = new Utils();

    /*public static String url = "jdbc:odbc:Driver={Microsoft Access driver (*.mdb)};DBQ=Clinica.mdb";
    public static final String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    public static final String usuario = "";
    public static final String password = "";*/
    //public static Connection conexion;
    /*public static PreparedStatement sentencia;
    public static ResultSet resultado;*/

 /*public void conexion() {
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
    public void insertaConsultorio(String idConsul, String desc) {
        PreparedStatement sentencia;
        //ResultSet resultado;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            sentencia = conexion.prepareStatement("insert into consultorios values(?, ?)");

            sentencia.setString(1, idConsul);
            sentencia.setString(2, desc);

            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            utils.msgInf("Los datos han sido guardados");
        } catch (SQLException e) {
            utils.msgError("Error al guardar la informacion del Consultrio.");
            System.err.println("Error en metodo insertaConsultorio: " + e);
        }
    }

    public void EliminaConsultorio(String idConsul) {
        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            sentencia = conexion.prepareStatement("delete from consultorios where IdConsultorio=?");
            sentencia.setString(1, idConsul);
            sentencia.executeUpdate();

            utils.msgInf("El registro ha sido eliminado satisfactoriamente");
        } catch (SQLException err) {
            utils.msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
        }
    }

    public void actualizaConsultorio(String idConsul, String desc) {
        PreparedStatement sentencia;
        //ResultSet resultado;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            sentencia = conexion.prepareStatement(
                    "update consultorios set IdConsultorio=?, DescripcionConsultorio=? where IdConsultorio=?");

            sentencia.setString(1, idConsul);
            sentencia.setString(2, desc);
            sentencia.setString(3, idConsul);

            sentencia.executeUpdate();

            utils.msgInf("El registro ha sido actualizado satisfactoriamente");
        } catch (Exception err) {
            utils.msgError("La clave no existe." + "\nNo es posible actualizar el registro: ");
            System.err.println("La clave no existe." + "\nNo es posible actualizar el registro: " + err);
        }
    }

    public String buscaConsultorio(String idConsul) {
        String descConsultorio = null;
        try {
            //Connection conexion = DriverManager.getConnection(ctrlConsul.url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            PreparedStatement sentencia = conexion.prepareStatement("select * from consultorios where IdConsultorio=?");
            sentencia.setString(1, idConsul);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                descConsultorio = resultado.getString("DescripcionConsultorio");
            } else {
                descConsultorio = "";
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            utils.msgError("La clave a buscar no existe");
            System.err.println("Error: " + e);
        } finally {

        }
        return descConsultorio;
    }

}
