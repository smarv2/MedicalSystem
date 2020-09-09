package com.mx.medicalsystem.dao;

import javax.swing.*;
import java.sql.*;

public class ctrlPaciente {

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
        } catch (Exception noDriver) {
            try {
                Class.forName(url);
            } catch (Exception noURL) {
                msgError("La URL o driver no existen: " + noURL);
            }
        }
    }

    public void insertaPaciente(String id, String nom, String apepat,
            String apemat, String sexo, int edad, String noconsulta, int tel, String direccion, String colonia,
            int cp, String delegacion, String estado) {
        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement("insert into Paciente values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            sentencia.setString(1, id);
            sentencia.setString(2, nom);
            sentencia.setString(3, apepat);
            sentencia.setString(4, apemat);
            sentencia.setString(5, sexo);
            sentencia.setInt(6, edad);
            sentencia.setString(7, noconsulta);
            sentencia.setInt(8, tel);
            sentencia.setString(9, direccion);
            sentencia.setString(10, colonia);
            sentencia.setInt(11, cp);
            sentencia.setString(12, delegacion);
            sentencia.setString(13, estado);

            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            msgInf("Los datos han sido guardados");
        } catch (Exception err) {
            msgError("Alguno de los datos insertados es incorrecto: " + err);
        }
    }

    public void eliminaPaciente(String id) {
        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement("delete from Paciente where IdPaciente=?");
            sentencia.setString(1, id);
            sentencia.executeUpdate();

            msgInf("El registro ha sido eliminado satisfactoriamente");
        } catch (Exception err) {
            msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
        }
    }

    public void actualizaPaciente(String id, String nom, String apepat,
            String apemat, String sexo, int edad, String noconsulta, int tel, String direccion, String colonia,
            int cp, String delegacion, String estado) {
        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.prepareStatement(
                    "update Paciente set IdPaciente=?,NombrePaciente=?, ApellidoPaterno=?, ApellidoMaterno=?, Sexo=?, "
                    + "Edad=?, NoConsuta=? ,Telefono=?, CalleNumero=?, Colonia=?,CP=?,Delegacion=?,"
                    + "Estado=? where IdPaciente=?");

            sentencia.setString(1, id);
            sentencia.setString(2, nom);
            sentencia.setString(3, apepat);
            sentencia.setString(4, apemat);
            sentencia.setString(5, sexo);
            sentencia.setInt(6, edad);
            sentencia.setString(7, noconsulta);
            sentencia.setInt(8, tel);
            sentencia.setString(9, direccion);
            sentencia.setString(10, colonia);
            sentencia.setInt(11, cp);
            sentencia.setString(12, delegacion);
            sentencia.setString(13, estado);
            sentencia.setString(14, id);

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
