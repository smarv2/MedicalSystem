package com.mx.medicalsystem;

import javax.swing.*;
import java.sql.*;

public class ctrlRevision {

    public static String url = "jdbc:odbc:Driver={Microsoft Access driver (*.mdb)};DBQ=Clinica.mdb";
    public static final String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    public static final String usuario = "";
    public static final String password = "";

    public static Connection conexion;
    public static PreparedStatement sentencia;
    public static ResultSet resultado;

    public void conexion() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException noDriver) {
            msgError("Driver no existe: " + noDriver);
            try {
                Class.forName(url);
            } catch (Exception noURL) {
                msgError("La URL no existe: " + noURL);
            }
        }
    }

    public void insertaRevision(String id, String lblnombre, String lbledad, String lblfecha, String lbltemp, String lblfc,
            String lblfr, String lblta, String lblpeso, String lbldiagnostico) {
        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement("insert into Revicion values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            sentencia.setString(1, id);
            sentencia.setString(2, lblnombre);
            sentencia.setString(3, lbledad);
            sentencia.setString(4, lblfecha);
            sentencia.setString(5, lbltemp);
            sentencia.setString(6, lblfc);
            sentencia.setString(7, lblfr);
            sentencia.setString(8, lblta);
            sentencia.setString(9, lblpeso);
            sentencia.setString(10, lbldiagnostico);

            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            msgInf("Los datos han sido guardados");
        } catch (SQLException err) {
            msgError("Alguno de los datos insertados es incorrecto: " + err);
            System.err.println("Error en ctrlRevision: " + err);
        }
    }

    public void eliminaRevision(String id) {
        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement("delete from Revicion where idpaciente=?");
            sentencia.setString(1, id);
            sentencia.executeUpdate();

            msgInf("El registro ha sido eliminado satisfactoriamente");
        } catch (Exception err) {
            msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
        }
    }

    public void actualizaRevision(String id, String lblnombre, String lbledad, String lblfecha,
            String lbltemp, String lblfc, String lblfr, String lblta, String lblpeso, String lbldiagnostico) {
        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement(
                    "update Revicion set idpaciente=?,Nombre=?,edad=?, fecha=?, temp=?, fc=?, "
                    + "fr=?, ta=?,peso=?,diagnostico=? where idpaciente=?");

            sentencia.setString(1, id);
            sentencia.setString(2, lblnombre);
            sentencia.setString(3, lbledad);
            sentencia.setString(4, lblfecha);
            sentencia.setString(5, lbltemp);
            sentencia.setString(6, lblfc);
            sentencia.setString(7, lblfr);
            sentencia.setString(8, lblta);
            sentencia.setString(9, lblpeso);
            sentencia.setString(10, lbldiagnostico);
            sentencia.setString(11, id);

            sentencia.executeUpdate();

            msgInf("El registro ha sido actualizado satisfactoriamente");
        } catch (Exception err) {
            msgError("La clave no existe." + "\nNo es posible eliminar el registro definido: " + err);
        }
    }

    public void msgError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void msgInf(String inf) {
        JOptionPane.showMessageDialog(null, inf, "Informaci�n", JOptionPane.WARNING_MESSAGE);
    }

}
