package com.mx.medicalsystem;

import com.mx.medicalsystem.util.ConexionMySQL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Consultorio extends JFrame {

    JPanel panel = new JPanel();

    JLabel idConsul = new JLabel("Clave de consultorio:");
    JTextField txtidConsul = new JTextField(3);
    JLabel desc = new JLabel("Descripcion de consultorio:");
    JTextField txtdesc = new JTextField(10);
    private JLabel imagen = new JLabel(new ImageIcon("engranes.gif"));
    JPanel datos = new JPanel();

    private final JToolBar herramientas = new JToolBar();
    
    private final ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/nuevo.gif"));
    private final ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/buscar.gif"));
    private final ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imagenes/eliminar.gif"));
    private final ImageIcon imagen4 = new ImageIcon(getClass().getResource("/imagenes/modificar.gif"));
    private final ImageIcon imagen5 = new ImageIcon(getClass().getResource("/imagenes/guardar.gif"));
    private final ImageIcon imagen6 = new ImageIcon(getClass().getResource("/imagenes/imprimir.gif"));
    private final ImageIcon imagen7 = new ImageIcon(getClass().getResource("/imagenes/regresar.gif"));
    
    private JButton btnnuevo = new JButton(imagen1);
    private JButton btnbuscar = new JButton(imagen2);
    private JButton btneliminar = new JButton(imagen3);
    private JButton btnmodificar = new JButton(imagen4);
    private JButton btnguardar = new JButton(imagen5);
    private JButton btnimprimir = new JButton(imagen6);
    private JButton btnregresar = new JButton(imagen7);

    private Border borde;
    public static ctrlConsultorio ctrlConsul = new ctrlConsultorio();

    Consultorio() {
        super("Consultorio");
        setSize(500, 300);
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

        datos.setBounds(10, 15, 450, 110);
        datos.setLayout(null);

        panel.setLayout(null);
        idConsul.setBounds(new Rectangle(40, 40, 200, 20));
        txtidConsul.setBounds(new Rectangle(220, 40, 50, 20));

        desc.setBounds(new Rectangle(40, 80, 200, 20));
        txtdesc.setBounds(new Rectangle(220, 80, 120, 20));
        imagen.setBounds(new Rectangle(200, 113, 110, 120));
        panel.add(imagen);

        panel.add(idConsul);
        panel.add(txtidConsul);
        panel.add(desc);
        panel.add(txtdesc);
        panel.add(datos);
        add(panel);

        idConsul.setFont(new Font("Georgia", Font.BOLD, 12));
        idConsul.setForeground(Color.black);

        desc.setFont(new Font("Georgia", Font.BOLD, 12));
        desc.setForeground(Color.black);

        btnnuevo.setToolTipText("Nuevo registro");
        btnbuscar.setToolTipText("Buscar registro");
        btneliminar.setToolTipText("Eliminar registro");
        btnmodificar.setToolTipText("Modificar registro");
        btnguardar.setToolTipText("Guardar registro");
        btnregresar.setToolTipText("Regresar al menu principal");
        btnimprimir.setToolTipText("Imprimir registro");

        this.add(herramientas, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        agregaABarra();

        //ctrlConsul.conexion();
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
                try {
                    String idConsul = txtidConsul.getText();
                    String desc = txtdesc.getText();
                    
                    System.out.println("idConsul: " + idConsul);
                    System.out.println("desc: " + desc);

                    ctrlConsul.insertaConsultorio(idConsul, desc);
                } catch (Exception fi) {
                }
            }
        }
        );

        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idConsul = txtidConsul.getText();
                String descripcion;
                descripcion = ctrlConsul.buscaConsultorio(idConsul);
                
                if(descripcion != ""){
                    txtdesc.setText(descripcion);
                } else {
                    JOptionPane.showMessageDialog(null, "Se se encontró el regustro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );

        btnnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtidConsul.setText("");
                txtdesc.setText("");

            }
        });

        btneliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idConsul = txtidConsul.getText();

                if (idConsul.equalsIgnoreCase("") || idConsul.equalsIgnoreCase(" ") || idConsul.equalsIgnoreCase("  ")) {
                    ctrlConsul.msgError("La caja de texto est� vac�a");
                } else {
                    buscaEliminaConsultorio();
                }
            }
        }
        );

        btnregresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hide();
            }
        }
        );

        btnmodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtidConsul.getText().equalsIgnoreCase("") || txtdesc.getText().equalsIgnoreCase("")) {
                    ctrlConsul.msgError("Todos los campos deben contener datos"
                            + "\ncon el formato correspondiente");
                } else {
                    String idConsul = txtidConsul.getText();
                    String desc = txtdesc.getText();

                    ctrlConsul.actualizaConsultorio(idConsul, desc);
                }
            }
        }
        );
    }

    public void buscaEliminaConsultorio() {
        try {
            //Connection conexion = DriverManager.getConnection(ctrlConsul.url);
            
            ConexionMySQL mysql = new ConexionMySQL();
            Connection conexion = mysql.conectar();
            PreparedStatement sentencia = conexion.prepareStatement("select * from Consultorio where IdConsultorio=?");
            sentencia.setString(1, String.valueOf(txtidConsul.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                txtdesc.setText(resultado.getString("DescripcionConsultorio"));

                int val = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro actual?",
                        "Consultorio", JOptionPane.YES_NO_OPTION);
                if (val == JOptionPane.YES_OPTION) {
                    String idConsul = txtidConsul.getText();
                    ctrlConsul.EliminaConsultorio(idConsul);

                    txtidConsul.setText("");
                    txtdesc.setText("");
                }

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                ctrlConsul.msgError("La clave a buscar no existe");
            }
        } catch (Exception noE) {
            ctrlConsul.msgError("La clave a buscar no existe");
        }
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
        new Consultorio();

    }

}
