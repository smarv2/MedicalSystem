/*
 * (#)ConexionMySQL.java 1.00 04/01/2018
 * 
 * Copyright (c) 2018 SURA Mexico. Derechos reservados. https://www.suramexico.com/afore/
 */
package com.mx.medicalsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;

/**
 * Mario Alan Ramirez Vazquez.
 * 
 * @author MXI01020253A
 * @version 1.00, 04/01/2018
 */
public class ConexionMySQL {
	
	/**
	 * Campo LOG de tipo Logger.
	 */
	protected static final Logger LOG = Logger.getLogger(ConexionMySQL.class);

	/**
	 * Campo db de tipo String.
	 */
	public static final String DB = "medicalsystem_tsu";
	/**
	 * Campo url de tipo String.
	 */
	public static final String URL = "jdbc:mysql://localhost/" + DB;
	/**
	 * Campo user de tipo String.
	 */
	public static final String USER = "root";
	/**
	 * Campo pass de tipo String.
	 */
	public static final String PASS = "";

	/*
	 * public ConexionMySQL() { }
	 */

	/**
	 * Metodo que realiza la conexion a DB.
	 * 
	 * @return link
	 */
	public final Connection conectar() {
		Connection link = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			link = DriverManager.getConnection(ConexionMySQL.URL, ConexionMySQL.USER, ConexionMySQL.PASS);
			//LOG.info("Conexion exitosa.");
		} catch (Exception e) {
			LOG.error("Error al realiar la conexion: " + e);
		}
		return link;
	}

}
