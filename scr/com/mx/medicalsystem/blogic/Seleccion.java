package com.mx.medicalsystem.blogic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class Seleccion extends JFrame {

    JPanel panel = new JPanel();
    public JLabel lbletiqueta = new JLabel("Seleccione Su Tipo De Usuario");
    public JLabel lblmedico = new JLabel("Médico");
    public JLabel lbladministrador = new JLabel("Administrador");
    public JButton btnmedico = new JButton("Aceptar");
    public JButton btnadministrador = new JButton("Acepatar");
    //private final JLabel imagen = new JLabel(new ImageIcon("MedicalSystem.jpg"));
    private final JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/imagenes/MedicalSystem.jpg")));
    private final JLabel imagen2 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/tin.gif")));
    private final JLabel imagen3 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/medicods11.gif")));
    private final JLabel imagen4 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/engraness.gif")));
    
    Seleccion() {
        super("SELECTOR DE USUARIO");
        setSize(800, 450);
        setVisible(true);
        setResizable(false);

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        panel.setLayout(null);

        lbletiqueta.setBounds(new Rectangle(280, -20, 350, 100));
        lblmedico.setBounds(new Rectangle(260, 35, 300, 97));
        lbladministrador.setBounds(new Rectangle(510, 35, 300, 97));
        btnmedico.setBounds(new Rectangle(250, 200, 90, 20));
        btnadministrador.setBounds(new Rectangle(530, 200, 90, 20));
        imagen.setBounds(new Rectangle(1, 1, 800, 450));
        imagen2.setBounds(new Rectangle (380,250,100,100));
        imagen3.setBounds(new Rectangle(243, 250, 100, 100));
        imagen4.setBounds(new Rectangle(525, 250, 100, 100));

        panel.add(lbletiqueta);
        panel.add(lblmedico);
        panel.add(lbladministrador);
        panel.add(btnmedico);
        panel.add(btnadministrador);
        panel.add(imagen);
        imagen.add(imagen2);
        imagen.add(imagen3);
        imagen.add(imagen4);

        lbletiqueta.setFont(new Font("Georgia", Font.BOLD, 16));
        lbletiqueta.setForeground(Color.red);

        lblmedico.setFont(new Font("Georgia", Font.BOLD, 14));
        lblmedico.setForeground(Color.black);

        lbladministrador.setFont(new Font("Georgia", Font.BOLD, 14));
        lbladministrador.setForeground(Color.black);

        add(panel);
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        btnmedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new passwordmedico().show();
                dispose();
            }
        }
        );

        btnadministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new passwordAdm().show();
                dispose();
            }
        }
        );

    }

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
        new Seleccion();
    }

}
