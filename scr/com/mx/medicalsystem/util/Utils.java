package com.mx.medicalsystem.util;

import javax.swing.JOptionPane;

/**
 *
 * @author smarv
 */
public class Utils {

    public void msgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void msgInf(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Información", JOptionPane.WARNING_MESSAGE);
    }

}
