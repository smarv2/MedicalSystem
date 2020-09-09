package com.mx.medicalsystem.dao;

import static com.mx.medicalsystem.blogic.Medico.ctrlMedi;
import com.mx.medicalsystem.util.ConexionMySQL;
import com.mx.medicalsystem.util.Utils;
import com.mx.medicalsystem.vo.MedicosVO;
import javax.swing.*;
import java.sql.*;

public class ctrlMedico {

    Utils utils = new Utils();

    /*public static String url = "jdbc:odbc:Driver={Microsoft Access driver (*.mdb)};DBQ=Clinica.mdb";
    public static final String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    public static final String usuario = "";
    public static final String password = "";*/

    /*public static Connection conexion;
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
    
        public MedicosVO buscaMedico(int idMedico) {
            MedicosVO medicosVO = null;
        try {
            //Connection conexion = DriverManager.getConnection(ctrlMedi.url);
            
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            
            PreparedStatement sentencia = conexion.prepareStatement("select * from medicos where IdMedico=?");
            sentencia.setInt(1, idMedico);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                medicosVO = new MedicosVO();
                medicosVO.setNombre(resultado.getString("nombre"));
                medicosVO.setPatenro(resultado.getString("paterno"));
                medicosVO.setMaterno(resultado.getString("materno"));
                medicosVO.setIdEspecialidad(resultado.getInt("idEspecialidad"));
                medicosVO.setIdTurno(resultado.getInt("idTurno"));
                medicosVO.setDireccion(resultado.getString("direccion"));
                medicosVO.setColonia(resultado.getString("colonia"));
                medicosVO.setDelegacion(resultado.getString("delegacion"));
                medicosVO.setEstado(resultado.getString("estado"));
                medicosVO.setCp(resultado.getString("cp"));
                medicosVO.setTelefono(resultado.getString("telefono"));
                medicosVO.setCedulaProfecional(resultado.getString("cedulaProfesional"));
                medicosVO.setIdConsultorio(resultado.getInt("idConsultorio"));

                resultado.close();
                sentencia.close();
                conexion.close();
            } 
        } catch (Exception e) {
            utils.msgError("Error al obtener el registro.");
            System.err.println("Error: " + e);
        }
        return medicosVO;
    }
    
    public void insertaMedico(MedicosVO medicosVO) {

        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();

            sentencia = conexion.prepareStatement("insert into medicos values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            sentencia.setInt(1, medicosVO.getIdMedico());
            sentencia.setString(2, medicosVO.getNombre());
            sentencia.setString(3, medicosVO.getPatenro());
            sentencia.setString(4, medicosVO.getMaterno());
            sentencia.setInt(5, medicosVO.getIdEspecialidad());
            sentencia.setInt(6, medicosVO.getIdTurno());
            sentencia.setString(7, medicosVO.getDireccion());
            sentencia.setString(8, medicosVO.getColonia());
            sentencia.setString(9, medicosVO.getDelegacion());
            sentencia.setString(10, medicosVO.getEstado());
            sentencia.setString(11, medicosVO.getCp());
            sentencia.setString(12, medicosVO.getTelefono());
            sentencia.setString(13, medicosVO.getCedulaProfecional());
            sentencia.setInt(14, medicosVO.getIdConsultorio());

            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            utils.msgInf("Los datos han sido guardados");
        } catch (Exception e) {
            utils.msgError("Ocurrio un error al guardar el registro.");
            System.err.println("Ocurrio un error en el metodo insertaMedico " + e);
        }
    }

    public void eliminaMedico(String id) {
        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            sentencia = conexion.prepareStatement("delete from medicos where IdMedico=?");
            sentencia.setString(1, id);
            sentencia.executeUpdate();

            utils.msgInf("El registro ha sido eliminado satisfactoriamente");
        } catch (Exception err) {
            utils.msgError("La clave no existe." + "\nNo es posible eliminar el registro definido");
        }
    }

    public void actualizaMedico(MedicosVO medicosVO) {
        PreparedStatement sentencia;
        try {
            //conexion = DriverManager.getConnection(url);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            sentencia = conexion.prepareStatement(
                    "update medicos set nombre=?, paterno=?, materno=?, "
                    + "idEspecialidad=?, idTurno=?, direccion=?, colonia=?, delegacion=?,"
                    + "estado=?, cp=?, telefono=?, cedulaProfesional=?, idConsultorio=? where idMedico=?");

            sentencia.setString(1, medicosVO.getNombre());
            sentencia.setString(2, medicosVO.getPatenro());
            sentencia.setString(3, medicosVO.getMaterno());
            sentencia.setInt(4, medicosVO.getIdEspecialidad());
            sentencia.setInt(5, medicosVO.getIdTurno());
            sentencia.setString(6, medicosVO.getDireccion());
            sentencia.setString(7, medicosVO.getColonia());
            sentencia.setString(8, medicosVO.getDelegacion());
            sentencia.setString(9, medicosVO.getEstado());
            sentencia.setString(10, medicosVO.getCp());
            sentencia.setString(11, medicosVO.getTelefono());
            sentencia.setString(12, medicosVO.getCedulaProfecional());
            sentencia.setInt(13, medicosVO.getIdConsultorio());
            sentencia.setInt(14, medicosVO.getIdMedico());

            sentencia.executeUpdate();

            utils.msgInf("El registro ha sido actualizado satisfactoriamente");
        } catch (Exception e) {
            utils.msgError("Error al actualizar el registro.");
            System.err.println("Error en metodo actualizaMedico" + e);
        }
    }

}
