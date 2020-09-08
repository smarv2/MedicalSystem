package com.mx.medicalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Revicion extends JFrame {

    JPanel panel = new JPanel();
    JPanel datos = new JPanel();

    JLabel lbl1 = new JLabel("CLINICA MATERNO INFANTIL Y DE ESPECIALIDADES");
    JLabel lbl2 = new JLabel("''Ntra. Sra. De los Remedios''");
    JLabel lbl3 = new JLabel("Ginecologia y Obstetica");
    JLabel lbl4 = new JLabel("Embarazo de alto riesgo");
    JLabel lbl5 = new JLabel("Colposcopia y Esterilidad");
    private final JLabel imagen = new JLabel(new ImageIcon("pato.gif"));

    JLabel id = new JLabel("Clave Paciente:");
    JTextField txtid = new JTextField(14);
    JLabel lblfecha = new JLabel("Fecha:");
    JTextField txtfecha = new JTextField(14);
    JLabel lbltemp = new JLabel("Temp:");
    JTextField txttemp = new JTextField(5);
    JLabel lblfc = new JLabel("FC:");
    JTextField txtfc = new JTextField(10);
    JLabel lblfr = new JLabel("FR:");
    JTextField txtfr = new JTextField(10);
    JLabel lblta = new JLabel("TA:");
    JTextField txtta = new JTextField(10);
    JLabel lblpeso = new JLabel("Peso:");
    JTextField txtpeso = new JTextField(10);

    JLabel lblnombre = new JLabel("Nombre:");
    JTextField txtnombre = new JTextField(30);
    JLabel lbledad = new JLabel("Edad:");
    JTextField txtedad = new JTextField(10);
    JLabel lbldiagnostico = new JLabel("Diagnostico:");
    JTextArea txtdiagnostico = new JTextArea(500, 7);

    java.sql.Date hoy = new java.sql.Date(System.currentTimeMillis());

    private final JToolBar herramientas = new JToolBar();
    private final ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/nuevo.gif"));
    private final ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/buscar.gif"));
    private final ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imagenes/eliminar.gif"));
    private final ImageIcon imagen4 = new ImageIcon(getClass().getResource("/imagenes/modificar.gif"));
    private final ImageIcon imagen5 = new ImageIcon(getClass().getResource("/imagenes/guardar.gif"));
    private final ImageIcon imagen6 = new ImageIcon(getClass().getResource("/imagenes/regresar.gif"));

    private final JButton btnAltas = new JButton(imagen1);
    private final JButton btnConsultas = new JButton(imagen2);
    private final JButton btnEliminar = new JButton(imagen3);
    private final JButton btnModificar = new JButton(imagen4);
    private final JButton btnGuardar = new JButton(imagen5);
    private final JButton btnRegresar = new JButton(imagen6);
    private final Border borde;

    public static ctrlRevision ctrlRe = new ctrlRevision();

    Revicion() {

        super("Consulta");
        setSize(750, 500);
        setResizable(false);

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.darkGray);
        Border titulo = BorderFactory.createTitledBorder(borde, "");
        datos.setBorder(titulo);

        datos.setBounds(5, 100, 730, 300);
        datos.setLayout(null);
        panel.setLayout(null);

        lbl1.setFont(new Font("Currier New", Font.BOLD, 18));
        lbl2.setFont(new Font("Currier New", Font.ITALIC, 18));
        lbl3.setFont(new Font("Currier New", Font.ITALIC, 14));
        lbl4.setFont(new Font("Currier New", Font.ITALIC, 14));
        lbl5.setFont(new Font("Currier New", Font.ITALIC, 14));

        lbl1.setBounds(new Rectangle(150, 1, 500, 20));
        lbl2.setBounds(new Rectangle(250, 21, 300, 20));
        lbl3.setBounds(new Rectangle(290, 41, 300, 20));
        lbl4.setBounds(new Rectangle(285, 61, 300, 20));
        lbl5.setBounds(new Rectangle(280, 81, 300, 20));

        id.setBounds(new Rectangle(20, 111, 100, 20));
        txtid.setBounds(new Rectangle(130, 111, 100, 20));
        lblfecha.setBounds(new Rectangle(20, 180, 100, 20));
        txtfecha.setBounds(new Rectangle(130, 180, 80, 20));
        imagen.setBounds(new Rectangle(4, -7, 140, 100));
        panel.add(imagen);

        txtfecha.setText(hoy.toString());

        lbltemp.setBounds(new Rectangle(320, 180, 100, 20));
        txttemp.setBounds(new Rectangle(365, 180, 30, 20));
        lblfc.setBounds(new Rectangle(410, 180, 100, 20));
        txtfc.setBounds(new Rectangle(435, 180, 30, 20));
        lblfr.setBounds(new Rectangle(480, 180, 100, 20));
        txtfr.setBounds(new Rectangle(505, 180, 30, 20));
        lblta.setBounds(new Rectangle(550, 180, 50, 20));
        txtta.setBounds(new Rectangle(575, 180, 40, 20));
        lblpeso.setBounds(new Rectangle(630, 180, 100, 20));
        txtpeso.setBounds(new Rectangle(670, 180, 30, 20));
        lblnombre.setBounds(new Rectangle(20, 141, 100, 20));
        txtnombre.setBounds(new Rectangle(130, 141, 100, 20));
        lbledad.setBounds(new Rectangle(325, 141, 100, 20));
        txtedad.setBounds(new Rectangle(365, 141, 30, 20));
        lbldiagnostico.setBounds(new Rectangle(20, 230, 150, 20));
        txtdiagnostico.setBounds(new Rectangle(130, 230, 520, 120));

        btnAltas.setToolTipText("Nuevo registro");
        btnConsultas.setToolTipText("Buscar registro");
        btnEliminar.setToolTipText("Eliminar registro");
        btnModificar.setToolTipText("Modificar registro");
        btnGuardar.setToolTipText("Guardar registro");
        btnRegresar.setToolTipText("Regresar al menu principal");

        herramientas.add(btnAltas);
        herramientas.add(btnConsultas);
        herramientas.add(btnEliminar);
        herramientas.add(btnModificar);
        herramientas.add(btnGuardar);
        herramientas.add(btnRegresar);

        this.add(herramientas, BorderLayout.NORTH);

        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(lbl3);
        panel.add(lbl4);
        panel.add(lbl5);

        panel.add(id);
        panel.add(txtid);
        panel.add(lblfecha);
        panel.add(txtfecha);
        panel.add(lbltemp);
        panel.add(txttemp);
        panel.add(lblfc);
        panel.add(txtfc);
        panel.add(lblfr);
        panel.add(txtfr);
        panel.add(lblta);
        panel.add(txtta);
        panel.add(lblpeso);
        panel.add(txtpeso);
        panel.add(lblnombre);
        panel.add(txtnombre);
        panel.add(lbledad);
        panel.add(txtedad);
        panel.add(lbldiagnostico);
        panel.add(txtdiagnostico);

        id.setFont(new Font("Georgia", Font.BOLD, 12));
        id.setForeground(Color.black);

        lblfecha.setFont(new Font("Georgia", Font.BOLD, 12));
        lblfecha.setForeground(Color.black);

        lbltemp.setFont(new Font("Georgia", Font.BOLD, 12));
        lbltemp.setForeground(Color.black);

        lblfc.setFont(new Font("Georgia", Font.BOLD, 12));
        lblfc.setForeground(Color.black);

        lblfr.setFont(new Font("Georgia", Font.BOLD, 12));
        lblfr.setForeground(Color.black);

        lblta.setFont(new Font("Georgia", Font.BOLD, 12));
        lblta.setForeground(Color.black);

        lblpeso.setFont(new Font("Georgia", Font.BOLD, 12));
        lblpeso.setForeground(Color.black);

        lblnombre.setFont(new Font("Georgia", Font.BOLD, 12));
        lblnombre.setForeground(Color.black);

        lbledad.setFont(new Font("Georgia", Font.BOLD, 12));
        lbledad.setForeground(Color.black);

        lbldiagnostico.setFont(new Font("Georgia", Font.BOLD, 12));
        lbldiagnostico.setForeground(Color.black);

        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        panel.add(datos);
        add(panel);
        setVisible(true);

        ctrlRe.conexion();
        eventos();

    }

    public void eventos() {
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = txtid.getText();
                    String lblnombre = txtnombre.getText();
                    String lbledad = txtedad.getText();
                    String lblfecha = txtfecha.getText();
                    String lbltemp = txttemp.getText();
                    String lblfc = txtfc.getText();
                    String lblfr = txtfr.getText();
                    String lblta = txtta.getText();
                    String lblpeso = txtpeso.getText();
                    String lbldiagnostico = txtdiagnostico.getText();

                    txtid.setText("");
                    txtnombre.setText("");
                    txtedad.setText("");
                    txtfecha.setText("");
                    txttemp.setText("");
                    txtfc.setText("");
                    txtfr.setText("");
                    txtta.setText("");
                    txtpeso.setText("");
                    txtdiagnostico.setText("");

                    ctrlRe.insertaRevision(id, lblnombre, lbledad, lblfecha, lbltemp, lblfc, lblfr,
                            lblta, lblpeso, lbldiagnostico);
                } catch (Exception fi) {
                }
            }
        }
        );

        btnConsultas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscaRevision();
            }
        }
        );

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = txtid.getText();

                if (id.equalsIgnoreCase("") || id.equalsIgnoreCase(" ") || id.equalsIgnoreCase("  ")) {
                    ctrlRe.msgError("La caja de texto est� vac�a");
                } else {
                    buscaEliminaRevision();
                }
            }
        }
        );

        btnAltas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtid.setText("");
                txtnombre.setText("");
                txtedad.setText("");
                txtfecha.setText("");
                txttemp.setText("");
                txtfc.setText("");
                txtfr.setText("");
                txtta.setText("");
                txtpeso.setText("");
                txtdiagnostico.setText("");
                txtfecha.setText(hoy.toString());

            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hide();
            }
        }
        );

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtid.getText().equalsIgnoreCase("") || txtnombre.getText().equalsIgnoreCase("")
                        || txtedad.getText().equalsIgnoreCase("") || txtfecha.getText().equalsIgnoreCase("")
                        || txttemp.getText().equalsIgnoreCase("") || txtfc.getText().equalsIgnoreCase("")
                        || txtfr.getText().equalsIgnoreCase("") || lblta.getText().equalsIgnoreCase("")
                        || txtpeso.getText().equalsIgnoreCase("") || txtdiagnostico.getText().equalsIgnoreCase("")) {
                    ctrlRe.msgError("Todos los campos deben contener datos"
                            + "\ncon el formato correspondiente");
                } else {

                    String id = txtid.getText();
                    String lblnombre = txtnombre.getText();
                    String lbledad = txtedad.getText();
                    String lblfecha = txtfecha.getText();
                    String lbltemp = txttemp.getText();
                    String lblfc = txtfc.getText();
                    String lblfr = txtfr.getText();
                    String lblta = txtta.getText();
                    String lblpeso = txtpeso.getText();
                    String lbldiagnostico = txtdiagnostico.getText();

                    ctrlRe.actualizaRevision(id, lblnombre, lbledad, lblfecha, lbltemp, lblfc, lblfr, lblta,
                            lblpeso, lbldiagnostico);
                }
            }
        }
        );
    }

    public void buscaRevision() {
        try {
            Connection conexion = DriverManager.getConnection(ctrlRe.url);
            PreparedStatement sentencia = conexion.prepareStatement("select * from Revicion where idpaciente=?");
            sentencia.setString(1, String.valueOf(txtid.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                txtedad.setText(resultado.getString("edad"));
                txtnombre.setText(resultado.getString("Nombre"));
                txtfecha.setText(resultado.getString("fecha"));
                txttemp.setText(resultado.getString("temp"));
                txtfc.setText(resultado.getString("fc"));
                txtfr.setText(resultado.getString("fr"));
                txtta.setText(resultado.getString("ta"));
                txtpeso.setText(resultado.getString("peso"));
                txtdiagnostico.setText(resultado.getString("diagnostico"));

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                ctrlRe.msgError("La clave a buscar no existe");
            }
        } catch (Exception noE) {
            ctrlRe.msgError("La clave a buscar no existe");
        }
    }

    public void buscaEliminaRevision() {
        try {
            Connection conexion = DriverManager.getConnection(ctrlRe.url);
            PreparedStatement sentencia = conexion.prepareStatement("select * from Revicion where idpaciente=?");
            sentencia.setString(1, String.valueOf(txtid.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {

                txtedad.setText(resultado.getString("Nombre"));
                txtnombre.setText(resultado.getString("edad"));
                txtfecha.setText(resultado.getString("fecha"));
                txttemp.setText(resultado.getString("temp"));
                txtfc.setText(resultado.getString("fc"));
                txtfr.setText(resultado.getString("fr"));
                txtta.setText(resultado.getString("ta"));
                txtpeso.setText(resultado.getString("peso"));
                txtdiagnostico.setText(resultado.getString("diagnostico"));

                int val = JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el registro actual?",
                        "Revicion", JOptionPane.YES_NO_OPTION);
                if (val == JOptionPane.YES_OPTION) {
                    String id = txtid.getText();
                    ctrlRe.eliminaRevision(id);

                    txtid.setText("");
                    txtnombre.setText("");
                    txtedad.setText("");
                    txtfecha.setText("");
                    txttemp.setText("");
                    txtfc.setText("");
                    txtfr.setText("");
                    txtta.setText("");
                    txtpeso.setText("");
                    txtdiagnostico.setText("");
                }

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                ctrlRe.msgError("La clave a buscar no existe");
            }
        } catch (Exception noE) {
            ctrlRe.msgError("La clave a buscar no existe");
        }
    }

    public static void main(String[] agrs) {
        MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println("Fall� la carga del tema");
            System.out.println(ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new Revicion();
    }

}
