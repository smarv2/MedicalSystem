package com.mx.medicalsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;

public class passwordmedico extends JFrame {

    //ImageIcon ImgI1 = new ImageIcon(getClass().getResource("/imagenes/dsicono.jpg"));
            
    JLabel lblusuario = new JLabel("MEDICO");
    JLabel lblcontraseña = new JLabel("PASSWORD");
    JLabel n = new JLabel("BIENVENIDO ");

    JTextField txtusuario = new JTextField(15);
    JPasswordField txtcontraseña = new JPasswordField(10);
    JButton B1 = new JButton("Aceptar");
    JPanel p = new JPanel();
//    Show Manejador=new Show();

    passwordmedico() {

        super("LOGIN MEDICO");

        ImageIcon as = new ImageIcon("candado.gif");
        JLabel qs = new JLabel(as);
        add(qs);
        p.setLayout(null);
        p.add(lblusuario);
        p.add(txtusuario);
        p.add(lblcontraseña);
        txtcontraseña.setToolTipText("Ingrese tu passwordmedico correcto");
        p.add(txtcontraseña);
        //p.add(t2);
        p.add(B1);
        n.setFont(new Font("Times new Roman", 7, 60));
        n.setForeground(Color.red);
        p.add(n);

        /* p.setBackground(Color.black);
 	    lblusuario.setForeground(Color.white);
 	    lblcontrase�a.setForeground(Color.white);
 	    B1.setForeground(Color.blue);*/
        lblusuario.setBounds(20, 25, 80, 10);
        txtusuario.setBounds(100, 25, 160, 20);
        lblcontraseña.setBounds(20, 70, 80, 10);
        txtcontraseña.setBounds(100, 70, 160, 20);
        B1.setBounds(110, 120, 130, 30);
        qs.setBounds(260, 75, 85, 100);

        this.add(qs);
        this.add(p);

        setSize(350, 200);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        
        txtcontraseña.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtusuario.getText();
                String contraseña = txtcontraseña.getText();
                if (usuario.equals("digital")) {
                    if (contraseña.equals("stone")) {
                        new MenuMedico();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                        txtcontraseña.setText("");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Medico Incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtusuario.setText("");
                    txtcontraseña.setText("");
                }

            }
        }
        );

        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtusuario.getText();
                String contraseña = txtcontraseña.getText();
                if (usuario.equals("digital")) {
                    if (contraseña.equals("stone")) {
                        new MenuMedico();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                        txtcontraseña.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Medico Incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtusuario.setText("");
                    txtcontraseña.setText("");
                }
            }
        }
        );

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);
    }

    //static public void main(String... h) {
    public static void main(String[] agrs) {
        MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            System.out.println("Falló la carga del tema");
            System.out.println(ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new passwordmedico().setVisible(true);
    }
}
