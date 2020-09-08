package com.mx.medicalsystem;

import static com.mx.medicalsystem.Consultorio.ctrlConsul;
import com.mx.medicalsystem.util.ConexionMySQL;
import javax.swing.*;
import java.sql.*;

public class ctrlConsultorio {

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
        ResultSet resultado;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            sentencia = conexion.prepareStatement("insert into Consultorio values(?, ?)");

            sentencia.setString(1, idConsul);
            sentencia.setString(2, desc);

            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            msgInf("Los datos han sido guardados");
        } catch (SQLException err) {
            msgError("Alguno de los datos insertados es incorrecto: " + err);
        }
    }

    public void EliminaConsultorio(String idConsul) {
        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            sentencia = conexion.prepareStatement("delete from Consultorio where IdConsultorio=?");
            sentencia.setString(1, idConsul);
            sentencia.executeUpdate();

            msgInf("El registro ha sido eliminado satisfactoriamente");
        } catch (SQLException err) {
            msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
        }
    }

    public void actualizaConsultorio(String idConsul, String desc) {
        PreparedStatement sentencia;
        ResultSet resultado;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            sentencia = conexion.prepareStatement(
                    "update Consultorio set IdConsultorio=?, DescripcionConsultorio=? where IdConsultorio=?");

            sentencia.setString(1, idConsul);
            sentencia.setString(2, desc);
            sentencia.setString(3, idConsul);

            sentencia.executeUpdate();

            msgInf("El registro ha sido actualizado satisfactoriamente");
        } catch (Exception err) {

            err.printStackTrace();
            msgError("La clave no existe." + "\nNo es posible actualizar el registro: " + err);
        }
    }

    public String buscaConsultorio(String idConsul ) {
        System.out.println("buscaConsultorio");
        String descConsultorio = null;
        try {
            //Connection conexion = DriverManager.getConnection(ctrlConsul.url);
                        
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            PreparedStatement sentencia = conexion.prepareStatement("select * from Consultorio where IdConsultorio=?");
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
            ctrlConsul.msgError("La clave a buscar no existe");
            System.err.println("Error: " + e);
        } finally {

        }
        return descConsultorio;
    }

    public void msgError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void msgInf(String inf) {
        JOptionPane.showMessageDialog(null, inf, "Información", JOptionPane.WARNING_MESSAGE);
    }

}
