package com.mx.medicalsystem.blogic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MenuAdministracion extends JFrame {

    JLabel lbletiqueta = new JLabel("Que Decea Controlar?");

    String uno[] = {"CONTROL DE CLINICA", "Consultorios", "Medicos", "Especialidades"};
    String tres[] = {"CONTROL DE INVENTARIO", "Proveedores", "Medicamentos", "Compras"};

    JComboBox opcionesclinica = new JComboBox(uno);
    JComboBox opcionesinventario = new JComboBox(tres);

    JPanel panel = new JPanel();
    JButton btnaceptar = new JButton("Aceptar");
    private final JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/imagenes/admin.jpg")));

    MenuAdministracion() {
        super("PANEL DE CONTROL");
        setSize(470, 300);
        setVisible(true);
        setResizable(false);

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        opcionesclinica.setMaximumRowCount(10);

        panel.setLayout(null);
        lbletiqueta.setFont(new Font("Batang", Font.BOLD, 14));
        lbletiqueta.setBounds(new Rectangle(20, 1, 200, 97));
        opcionesclinica.setBounds(new Rectangle(20, 80, 200, 27));
        opcionesinventario.setBounds(new Rectangle(240, 80, 200, 27));
        btnaceptar.setBounds(new Rectangle(80, 230, 300, 30));
        imagen.setBounds(new Rectangle(1, 1, 470, 300));

        panel.add(lbletiqueta);
        panel.add(opcionesclinica);
        panel.add(opcionesinventario);
        panel.add(btnaceptar);
        panel.add(imagen);

        add(panel);
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        btnaceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String control = (String) opcionesclinica.getSelectedItem();
                String controls = (String) opcionesinventario.getSelectedItem();

                if (control.equals("Consultorios")) {
                    new Consultorio();
                }
                if (control.equals("Medicos")) {
                    new Medico();
                }
                if (control.equals("Especialidades")) {
                    new Especialidad();
                }

                if (controls.equals("Proveedores")) {
                    new Proveedor();
                }
                if (controls.equals("Medicamentos")) {
                    new Medicamento();
                }
                if (controls.equals("Compras")) {
                    new Compras();
                }
                if (control.equals("CONTROL DE CLINICA") && controls.equals("CONTROL DE INVENTARIO")) {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione una opcion de las listas", "SELECCION INVALIDA", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

    }

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
        new MenuAdministracion();
    }
}
