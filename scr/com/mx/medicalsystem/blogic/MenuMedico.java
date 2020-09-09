package com.mx.medicalsystem.blogic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MenuMedico extends JFrame {

    JLabel lbletiqueta = new JLabel("Elija una opcion");
    String dos[] = {"SERVICIOS", "Citas", "Consultas", "Pacientes"};

    JComboBox opcioneservicios = new JComboBox(dos);
    JPanel panel = new JPanel();
    JButton btnaceptar = new JButton("Aceptar");
    
    private JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/imagenes/jeringas2.gif")));
    private JLabel imagen2 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/boton.gif")));
    
    MenuMedico() {
        super("CONTROL MEDICO");
        setSize(470, 300);
        setVisible(true);
        setResizable(false);

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        opcioneservicios.setMaximumRowCount(10);

        panel.setLayout(null);
        lbletiqueta.setFont(new Font("Batang", Font.BOLD, 15));

        //lbletiqueta.setBounds(new Rectangle (20,1,200,97));
        lbletiqueta.setBounds(new Rectangle(135, -40, 200, 97));

        opcioneservicios.setBounds(new Rectangle(125, 80, 200, 27));
        btnaceptar.setBounds(new Rectangle(80, 230, 300, 30));
        imagen.setBounds(new Rectangle(1, 1, 470, 300));
        imagen2.setBounds(new Rectangle(330, 230, 40, 40));

        imagen.add(lbletiqueta);
        panel.add(opcioneservicios);

        imagen.add(btnaceptar);
        imagen.add(imagen2);
        panel.add(imagen);

        add(panel);
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        btnaceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String control = (String) opcioneservicios.getSelectedItem();

                if (control.equals("Consultas")) {
                    new Revicion();
                }
                if (control.equals("Citas")) {
                    new MedicoPaciente();
                }
                if (control.equals("Pacientes")) {
                    new Paciente();
                }
                if (control.equals("SERVICIOS")) {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione una opcion de la lista", "OPCION INVALIDA", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

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
        new MenuMedico();
    }
}
