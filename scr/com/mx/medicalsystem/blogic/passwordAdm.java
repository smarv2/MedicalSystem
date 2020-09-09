package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.blogic.TemaDigitalStone;
import com.mx.medicalsystem.blogic.MenuAdministracion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;

public class passwordAdm extends JFrame {

    //ImageIcon I1 = new ImageIcon(getClass().getResource("/imagenes/dsicono.jpg"));
    JLabel lblcontraseña = new JLabel("PASSWORD");
    JLabel n = new JLabel("BIENVENIDO ");

    JPasswordField txtcontraseña = new JPasswordField(10);
    JButton B1 = new JButton("Aceptar");
    JPanel p = new JPanel();
//    Show Manejador=new Show();

    passwordAdm() {

        super("CONTRASEÑA DE ACCESO");

        ImageIcon as = new ImageIcon("candado.gif");
        JLabel qs = new JLabel(as);
        add(qs);
        p.setLayout(null);
        p.add(lblcontraseña);
        txtcontraseña.setToolTipText("Ingrese tu password correcto");
        p.add(txtcontraseña);
        //p.add(t2);
        p.add(B1);
        n.setFont(new Font("Times new Roman", 7, 60));
        n.setForeground(Color.red);
        p.add(n);

        lblcontraseña.setBounds(20, 70, 80, 10);
        txtcontraseña.setBounds(100, 70, 160, 20);
        B1.setBounds(110, 120, 130, 30);
        qs.setBounds(260, 75, 85, 100);

        this.add(qs);
        this.add(p);

        setSize(350, 200);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String contraseña = txtcontraseña.getText();
                if (contraseña.equals("administrador")) {

                    new MenuAdministracion();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña de administracion erronea", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );

        txtcontraseña.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String contraseña = txtcontraseña.getText();
                if (contraseña.equals("administrador")) {

                    new MenuAdministracion();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña de administracion erronea", "ERROR", JOptionPane.ERROR_MESSAGE);
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
            System.out.println("Fall� la carga del tema");
            System.out.println(ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new passwordAdm().show();
    }
}
