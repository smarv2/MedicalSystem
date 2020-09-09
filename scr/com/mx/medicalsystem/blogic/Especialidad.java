package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.dao.ctrlEspecialidad;
import com.mx.medicalsystem.util.Utils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Especialidad extends JFrame {

    Utils utils = new Utils();
    JPanel panel = new JPanel();

    JLabel id = new JLabel("Clave de especialidad:");
    JTextField txtid = new JTextField(10);
    JLabel descri = new JLabel("Descripcion de especialidad:");
    JTextField txtdescri = new JTextField(10);
    private final JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/imagenes/engranes.gif")));
    JPanel datos = new JPanel();

    private final JToolBar herramientas = new JToolBar();

    private final ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/nuevo.gif"));
    private final ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/buscar.gif"));
    private final ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imagenes/eliminar.gif"));
    private final ImageIcon imagen4 = new ImageIcon(getClass().getResource("/imagenes/modificar.gif"));
    private final ImageIcon imagen5 = new ImageIcon(getClass().getResource("/imagenes/guardar.gif"));
    private final ImageIcon imagen6 = new ImageIcon(getClass().getResource("/imagenes/imprimir.gif"));
    private final ImageIcon imagen7 = new ImageIcon(getClass().getResource("/imagenes/regresar.gif"));

    private final JButton btnnuevo = new JButton(imagen1);
    private final JButton btnbuscar = new JButton(imagen2);
    private final JButton btneliminar = new JButton(imagen3);
    private final JButton btnmodificar = new JButton(imagen4);
    private final JButton btnguardar = new JButton(imagen5);
    private final JButton btnimprimir = new JButton(imagen6);
    private final JButton btnregresar = new JButton(imagen7);

    private Border borde;
    public static ctrlEspecialidad ctrlEsp = new ctrlEspecialidad();

    Especialidad() {
        super("Especialidad");
        setSize(480, 320);
        setVisible(true);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.darkGray);
        Border titulo = BorderFactory.createTitledBorder(borde, "");
        datos.setBorder(titulo);

        datos.setBounds(40, 10, 385, 130);
        datos.setLayout(null);

        panel.setLayout(null);
        id.setBounds(new Rectangle(65, 30, 200, 20));
        txtid.setBounds(new Rectangle(250, 30, 50, 20));

        descri.setBounds(new Rectangle(65, 70, 200, 20));
        txtdescri.setBounds(new Rectangle(250, 70, 150, 20));
        imagen.setBounds(new Rectangle(180, 130, 110, 120));
        panel.add(imagen);

        panel.add(id);
        panel.add(txtid);
        panel.add(descri);
        panel.add(txtdescri);
        panel.add(datos);

        id.setFont(new Font("Georgia", Font.BOLD, 12));
        id.setForeground(Color.black);

        descri.setFont(new Font("Georgia", Font.BOLD, 12));
        descri.setForeground(Color.black);

        add(panel);

        btnnuevo.setToolTipText("Nuevo registro");
        btnimprimir.setToolTipText("Imprimir registro");
        btnbuscar.setToolTipText("Buscar registro");
        btneliminar.setToolTipText("Eliminar registro");
        btnmodificar.setToolTipText("Modificar registro");
        btnguardar.setToolTipText("Guardar registro");
        btnregresar.setToolTipText("Regresar al menu principal");

        this.add(herramientas, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        agregaABarra();
        eventos();
    }

    public void agregaABarra() {
        herramientas.add(btnnuevo);
        herramientas.add(btnbuscar);
        herramientas.add(btneliminar);
        herramientas.add(btnmodificar);
        herramientas.add(btnguardar);
        herramientas.add(btnimprimir);
        herramientas.add(btnregresar);

    }

    public void eventos() {
        btnguardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtid.getText().equalsIgnoreCase("")) {
                    String id = txtid.getText();
                    String descri = txtdescri.getText();
                    ctrlEsp.insertaEspecialidad(id, descri);
                } else {
                    utils.msgError("Debe capturar la informacion a guardar.");
                }
            }
        }
        );

        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscaEspecialidad();
            }
        }
        );

        btneliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = txtid.getText();

                if (id.equalsIgnoreCase("") || id.equalsIgnoreCase(" ") || id.equalsIgnoreCase("  ")) {
                    utils.msgError("Debe indicar la informacion del registro a eliminar.");
                } else {
                    buscaEliminaEspecialidad();
                }
            }
        }
        );

        btnnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiaCampos();
            }
        });

        btnregresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hide();
            }
        }
        );

        btnmodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtid.getText().equalsIgnoreCase("") || txtdescri.getText().equalsIgnoreCase("")) {
                    utils.msgError("Todos los campos deben contener datos"
                            + "\ncon el formato correspondiente");
                } else {
                    String id = txtid.getText();
                    String descri = txtdescri.getText();
                    ctrlEsp.actualizaEspecialidad(id, descri);
                    limpiaCampos();
                }
            }
        }
        );
    }

    public void buscaEspecialidad() {
        String descpripcionEspecialidad;
        if (!txtid.getText().equalsIgnoreCase("")) {
            descpripcionEspecialidad = ctrlEsp.buscaEspecialidad(Integer.parseInt(txtid.getText().toString()));
            txtdescri.setText(descpripcionEspecialidad);
        } else {
            utils.msgError("Debe indicar la clave a buscar.");
        }
    }

    public void buscaEliminaEspecialidad() {
        String descpripcionEspecialidad;
        if (!txtid.getText().equalsIgnoreCase("")) {
            descpripcionEspecialidad = ctrlEsp.buscaEspecialidad(Integer.parseInt(txtid.getText().toString()));
            if (descpripcionEspecialidad != null) {
                int val = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro de Especialidad seleccionado?",
                        "Eliminacion de Especialidad.", JOptionPane.YES_NO_OPTION);
                if (val == JOptionPane.YES_OPTION) {
                    String id = txtid.getText();
                    ctrlEsp.eliminaEspecialidad(id);
                    limpiaCampos();
                }
            } else {
                utils.msgError("El registro a eliminar no existe.");
            }
        } else {
            utils.msgError("Debe indicar la clave a buscar.");
        }
    }

    public void limpiaCampos() {
        txtid.setText("");
        txtdescri.setText("");
    }

    public static void main(String[] args) {
        MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            System.out.println("Fall� la carga del tema");
            System.out.println(ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new Especialidad();

    }

}
