package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.dao.ctrlProveedor;
import com.mx.medicalsystem.util.Utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Proveedor extends JFrame {
    Utils utils = new Utils();
    private JTextField txtIdProveedor = new JTextField(15);
    private JLabel lblIdProveedor = new JLabel("Clave Proveedor:");
    private JTextField txtNombreProveedor = new JTextField(10);
    private JLabel lblNombreProveedor = new JLabel("Nombre:");
    JLabel apepat = new JLabel("Apellido Paterno:");
    JTextField apellidopaterno = new JTextField(2);
    JLabel apemat = new JLabel("Apellido Materno:");
    JTextField apellidomaterno = new JTextField(2);
    private JTextField txtTelefono = new JTextField(15);
    private JLabel lblTelefono = new JLabel("Telefono:");
    private JLabel direccion = new JLabel("Calle y Numero:");
    private JTextField txtdireccion = new JTextField(15);
    private JLabel colonia = new JLabel("Colonia:");
    private JTextField txtcolonia = new JTextField(15);
    private JLabel delegacion = new JLabel("Delegacion:");
    private JTextField txtdelegacion = new JTextField(15);
    private JLabel estado = new JLabel("Estado:");
    private JTextField txtestado = new JTextField(15);
    private JLabel imagen = new JLabel(new ImageIcon("engranes.gif"));

    private JLabel cp = new JLabel("CP:");
    private JTextField txtcp = new JTextField(15);

    JPanel datos = new JPanel();
    JPanel generales = new JPanel();

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
    
    
    private JPanel principal = new JPanel();

    private Border borde;
    private Border borde1;

    public static ctrlProveedor ctrlPro = new ctrlProveedor();

    public Proveedor() {
        super("Proveedor");
        setLayout(new BorderLayout());
        setSize(730, 440);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        setResizable(false);
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.darkGray);
        Border titulo = BorderFactory.createTitledBorder(borde, " Direccion ");
        datos.setBorder(titulo);

        borde1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.darkGray);
        Border titulo1 = BorderFactory.createTitledBorder(borde1, " Datos Generales ");
        generales.setBorder(titulo1);

        datos.setBounds(10, 155, 700, 110);
        datos.setLayout(null);

        generales.setBounds(10, 10, 700, 130);
        generales.setLayout(null);

        txtIdProveedor.setBounds(120, 35, 50, 20);
        lblIdProveedor.setBounds(20, 35, 100, 20);
        txtNombreProveedor.setBounds(120, 65, 120, 20);
        lblNombreProveedor.setBounds(20, 65, 120, 20);
        apepat.setBounds(new Rectangle(250, 65, 200, 20));
        apellidopaterno.setBounds(new Rectangle(365, 65, 100, 20));
        apemat.setBounds(new Rectangle(470, 65, 200, 20));
        apellidomaterno.setBounds(new Rectangle(590, 65, 100, 20));
        imagen.setBounds(new Rectangle(300, 250, 110, 120));

        txtTelefono.setBounds(120, 95, 120, 20);
        lblTelefono.setBounds(20, 95, 120, 20);

        direccion.setBounds(new Rectangle(20, 180, 200, 20));
        txtdireccion.setBounds(new Rectangle(130, 180, 120, 20));

        colonia.setBounds(new Rectangle(300, 180, 280, 20));
        txtcolonia.setBounds(new Rectangle(360, 180, 120, 20));

        cp.setBounds(new Rectangle(555, 180, 200, 20));
        txtcp.setBounds(new Rectangle(580, 180, 100, 20));

        delegacion.setBounds(new Rectangle(20, 215, 200, 20));
        txtdelegacion.setBounds(new Rectangle(130, 215, 120, 20));

        estado.setBounds(new Rectangle(300, 215, 200, 20));
        txtestado.setBounds(new Rectangle(360, 215, 120, 20));

        principal.setLayout(null);
        principal.add(txtIdProveedor);
        principal.add(lblIdProveedor);
        principal.add(txtNombreProveedor);
        principal.add(lblNombreProveedor);
        principal.add(apepat);
        principal.add(apellidopaterno);
        principal.add(apemat);
        principal.add(apellidomaterno);
        principal.add(imagen);

        principal.add(txtTelefono);
        principal.add(lblTelefono);

        principal.add(colonia);
        principal.add(txtcolonia);
        principal.add(cp);
        principal.add(txtcp);
        principal.add(delegacion);
        principal.add(txtdelegacion);
        principal.add(estado);
        principal.add(txtestado);

        principal.add(direccion);
        principal.add(txtdireccion);

        principal.add(datos);

        principal.add(generales);

        txtIdProveedor.setFont(new Font("Georgia", Font.BOLD, 12));
        txtIdProveedor.setForeground(Color.black);

        lblNombreProveedor.setFont(new Font("Georgia", Font.BOLD, 12));
        lblNombreProveedor.setForeground(Color.black);

        apepat.setFont(new Font("Georgia", Font.BOLD, 12));
        apepat.setForeground(Color.black);

        apemat.setFont(new Font("Georgia", Font.BOLD, 12));
        apemat.setForeground(Color.black);

        lblTelefono.setFont(new Font("Georgia", Font.BOLD, 12));
        lblTelefono.setForeground(Color.black);

        colonia.setFont(new Font("Georgia", Font.BOLD, 12));
        colonia.setForeground(Color.black);

        cp.setFont(new Font("Georgia", Font.BOLD, 12));
        cp.setForeground(Color.black);

        delegacion.setFont(new Font("Georgia", Font.BOLD, 12));
        delegacion.setForeground(Color.black);

        estado.setFont(new Font("Georgia", Font.BOLD, 12));
        estado.setForeground(Color.black);

        direccion.setFont(new Font("Georgia", Font.BOLD, 12));
        direccion.setForeground(Color.black);

        btnnuevo.setToolTipText("Nuevo registro");
        btnbuscar.setToolTipText("Buscar registro");
        btneliminar.setToolTipText("Eliminar registro");
        btnmodificar.setToolTipText("Modificar registro");
        btnguardar.setToolTipText("Guardar registro");
        btnimprimir.setToolTipText("Imprimier");
        btnregresar.setToolTipText("Regresar al menu principal");

        this.add(herramientas, BorderLayout.NORTH);
        this.add(principal, BorderLayout.CENTER);

        setVisible(true);
        agregaABarra();
        setResizable(false);

        ctrlPro.conexion();

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
                    String lblIdProveedor = txtIdProveedor.getText();
                    String lblNombreProveedor = txtNombreProveedor.getText();
                    String apemat = apellidomaterno.getText();
                    String apepat = apellidopaterno.getText();
                    int lblTelefono = Integer.parseInt(txtTelefono.getText());
                    String direccion = txtdireccion.getText();
                    String colonia = txtcolonia.getText();
                    String delegacion = txtdelegacion.getText();
                    String estado = txtestado.getText();
                    int cp = Integer.parseInt(txtcp.getText());

                    ctrlPro.insertaProveedor(lblIdProveedor, lblNombreProveedor, apepat, apemat,
                            lblTelefono, direccion, colonia, delegacion, estado, cp);
                } catch (Exception fi) {
                }
            }
        }
        );

        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscaProveedor();
            }
        }
        );
        
        btnnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtIdProveedor.setText("");
                txtNombreProveedor.setText("");
                apellidomaterno.setText("");
                apellidopaterno.setText("");
                txtTelefono.setText("");
                txtdireccion.setText("");
                txtcolonia.setText("");
                txtdelegacion.setText("");
                txtestado.setText("");
                cp.setText("");

            }
        });

        btnregresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hide();
            }
        }
        );

        btneliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lblIdProveedor = txtIdProveedor.getText();

                if (lblIdProveedor.equalsIgnoreCase("") || lblIdProveedor.equalsIgnoreCase(" ") || lblIdProveedor.equalsIgnoreCase("  ")) {
                    utils.msgError("La caja de texto est� vac�a");
                } else {
                    buscaEliminaProveedor();
                }
            }
        }
        );

        btnmodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtIdProveedor.getText().equalsIgnoreCase("") || txtNombreProveedor.getText().equalsIgnoreCase("")
                        || apellidopaterno.getText().equalsIgnoreCase("") || apellidomaterno.getText().equalsIgnoreCase("")
                        || txtTelefono.getText().equalsIgnoreCase("") || txtdireccion.getText().equalsIgnoreCase("")
                        || txtcolonia.getText().equalsIgnoreCase("") || txtdelegacion.getText().equalsIgnoreCase("")
                        || txtestado.getText().equalsIgnoreCase("") || txtcp.getText().equalsIgnoreCase("")) {
                    utils.msgError("Todos los campos deben contener datos"
                            + "\ncon el formato correspondiente");
                } else {
                    String lblIdProveedor = txtIdProveedor.getText();
                    String lblNombreProveedor = txtNombreProveedor.getText();
                    String apemat = apellidomaterno.getText();
                    String apepat = apellidopaterno.getText();
                    int lblTelefono = Integer.parseInt(txtTelefono.getText());
                    String direccion = txtdireccion.getText();
                    String colonia = txtcolonia.getText();
                    String delegacion = txtdelegacion.getText();
                    String estado = txtestado.getText();
                    int cp = Integer.parseInt(txtcp.getText());

                    ctrlPro.actualizaProveedor(lblIdProveedor, lblNombreProveedor, apepat, apemat,
                            lblTelefono, direccion, colonia, delegacion, estado, cp);
                }
            }
        }
        );
    }

    public void buscaProveedor() {
        try {
            Connection conexion = DriverManager.getConnection(ctrlPro.url);
            PreparedStatement sentencia = conexion.prepareStatement("select * from Proveedor where IdProveedor=?");
            sentencia.setString(1, String.valueOf(txtIdProveedor.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {

                //	txtIdProveedor.setText(resultado.getString("IdProveedor"));
                txtNombreProveedor.setText(resultado.getString("NombreProveedpr"));
                apellidopaterno.setText(resultado.getString("ApePat"));
                apellidomaterno.setText(resultado.getString("ApeMat"));
                txtTelefono.setText(resultado.getString("Telefono"));
                txtdireccion.setText(resultado.getString("CalleNumero"));
                txtcolonia.setText(resultado.getString("Colonia"));
                txtdelegacion.setText(resultado.getString("Delegacion"));
                txtestado.setText(resultado.getString("Estado"));
                txtcp.setText(resultado.getString("CP"));

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                utils.msgError("La clave a buscar no existe");
            }
        } catch (Exception noE) {
            utils.msgError("La clave a buscar no existe");
        }
    }

    public void buscaEliminaProveedor() {
        try {
            Connection conexion = DriverManager.getConnection(ctrlPro.url);
            PreparedStatement sentencia = conexion.prepareStatement("select * from Proveedor where IdProveedor=?");
            sentencia.setString(1, String.valueOf(txtIdProveedor.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {

                txtIdProveedor.setText(resultado.getString("IdProveedor"));
                txtNombreProveedor.setText(resultado.getString("NombreProveedpr"));
                apellidopaterno.setText(resultado.getString("ApePat"));
                apellidomaterno.setText(resultado.getString("ApeMat"));
                txtTelefono.setText(resultado.getString("Telefono"));
                txtdireccion.setText(resultado.getString("CalleNumero"));
                txtcolonia.setText(resultado.getString("Colonia"));
                txtdelegacion.setText(resultado.getString("Delegacion"));
                txtestado.setText(resultado.getString("Estado"));
                txtcp.setText(resultado.getString("CP"));

                int val = JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el registro actual?",
                        "Proveedor", JOptionPane.YES_NO_OPTION);
                if (val == JOptionPane.YES_OPTION) {
                    String lblIdProveedor = txtIdProveedor.getText();
                    ctrlPro.eliminaProveedor(lblIdProveedor);

                    txtIdProveedor.setText("");
                    txtNombreProveedor.setText("");
                    apellidopaterno.setText("");
                    apellidomaterno.setText("");
                    txtTelefono.setText("");
                    txtdireccion.setText("");
                    txtcolonia.setText("");
                    txtdelegacion.setText("");
                    txtestado.setText("");
                    txtcp.setText("");
                }

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                utils.msgError("La clave a buscar no existe");
            }
        } catch (Exception e) {
            utils.msgError("La clave a buscar no existe");
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
        new Proveedor();

    }

}
