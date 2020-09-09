package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.dao.ctrlPaciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Paciente extends JFrame {

    JPanel panel = new JPanel();

    JLabel id = new JLabel("Id Paciente:");
    JTextField txtid = new JTextField(3);
    JLabel nom = new JLabel("Nombre:");
    JTextField txtnom = new JTextField(10);
    JLabel apepat = new JLabel("Apellido Paterno:");
    JTextField apellidopaterno = new JTextField(2);
    JLabel apemat = new JLabel("Apellido Materno:");
    JTextField apellidomaterno = new JTextField(2);
    JLabel sexo = new JLabel("Sexo:");
    private String[] pa = {"Masculino", "Femenino"};
    private JComboBox box1 = new JComboBox(pa);
    //JTextField txtsexo = new JTextField(2);
    JLabel edad = new JLabel("Edad:");
    JTextField txtedad = new JTextField(3);
    JLabel tel = new JLabel("Telefono:");
    JTextField txttel = new JTextField(10);
    JLabel noconsulta = new JLabel("No. Consulta:");
    JTextField txtno = new JTextField(5);
    JLabel direccion = new JLabel("Calle y Numero:");
    JTextField txtdireccion = new JTextField(15);
    JLabel colonia = new JLabel("Colonia:");
    JTextField txtcolonia = new JTextField(15);
    JLabel delegacion = new JLabel("Delegacion:");
    JTextField txtdelegacion = new JTextField(15);
    JLabel estado = new JLabel("Estado:");
    JTextField txtestado = new JTextField(15);
    JLabel cp = new JLabel("CP:");
    JTextField txtcp = new JTextField(15);
    
    private JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/imagenes/medico.gif")));
    
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
    JPanel datos = new JPanel();
    private Border borde1;
    JPanel generales = new JPanel();

    public static ctrlPaciente ctrlPac = new ctrlPaciente();

    Paciente() {
        super("Paciente");
        setSize(740, 500);
        setVisible(true);
        setResizable(false);

        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

        borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.darkGray);
        Border titulo = BorderFactory.createTitledBorder(borde, "Datos");
        datos.setBorder(titulo);

        borde1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.darkGray);
        Border titulo1 = BorderFactory.createTitledBorder(borde1, "Datos Generales");
        generales.setBorder(titulo1);

        datos.setBounds(10, 10, 710, 190);
        datos.setLayout(null);

        generales.setBounds(10, 205, 710, 120);
        generales.setLayout(null);

        panel.setLayout(null);
        id.setBounds(new Rectangle(20, 20, 120, 20));
        txtid.setBounds(new Rectangle(110, 20, 50, 20));

        nom.setBounds(new Rectangle(20, 60, 200, 20));
        txtnom.setBounds(new Rectangle(110, 60, 120, 20));
        apepat.setBounds(new Rectangle(240, 60, 180, 20));
        apellidopaterno.setBounds(new Rectangle(360, 60, 100, 20));
        apemat.setBounds(new Rectangle(465, 60, 180, 20));
        apellidomaterno.setBounds(new Rectangle(590, 60, 100, 20));

        sexo.setBounds(new Rectangle(20, 100, 200, 20));
        box1.setBounds(new Rectangle(110, 100, 90, 20));
        //txtsexo.setBounds(new Rectangle(90,100,90,20));
        edad.setBounds(new Rectangle(300, 100, 200, 20));
        txtedad.setBounds(new Rectangle(360, 100, 30, 20));

        tel.setBounds(new Rectangle(280, 140, 200, 20));
        txttel.setBounds(new Rectangle(360, 140, 100, 20));

        noconsulta.setBounds(new Rectangle(20, 140, 200, 20));
        txtno.setBounds(new Rectangle(110, 140, 50, 20));

        direccion.setBounds(new Rectangle(20, 240, 200, 20));
        txtdireccion.setBounds(new Rectangle(130, 240, 120, 20));

        colonia.setBounds(new Rectangle(290, 240, 280, 20));
        txtcolonia.setBounds(new Rectangle(360, 240, 120, 20));

        cp.setBounds(new Rectangle(555, 240, 200, 20));
        txtcp.setBounds(new Rectangle(580, 240, 100, 20));

        delegacion.setBounds(new Rectangle(20, 280, 200, 20));
        txtdelegacion.setBounds(new Rectangle(130, 280, 120, 20));

        estado.setBounds(new Rectangle(290, 280, 200, 20));
        txtestado.setBounds(new Rectangle(360, 280, 120, 20));
        imagen.setBounds(new Rectangle(323, 320, 100, 100));

        panel.add(imagen);

        datos.add(id);
        datos.add(txtid);
        datos.add(nom);
        datos.add(txtnom);
        datos.add(apepat);
        datos.add(apellidopaterno);
        datos.add(apemat);
        datos.add(apellidomaterno);
        datos.add(sexo);
        datos.add(box1);
        //panel.add(txtsexo);
        datos.add(edad);
        datos.add(txtedad);

        datos.add(tel);
        datos.add(txttel);
        datos.add(noconsulta);
        datos.add(txtno);

        panel.add(direccion);
        panel.add(txtdireccion);

        panel.add(delegacion);
        panel.add(txtdelegacion);
        panel.add(colonia);
        panel.add(txtcolonia);
        panel.add(cp);
        panel.add(txtcp);

        panel.add(delegacion);
        panel.add(txtdelegacion);
        panel.add(estado);
        panel.add(txtestado);

        panel.add(datos);
        panel.add(generales);
        add(panel);

        id.setFont(new Font("Georgia", Font.BOLD, 12));
        id.setForeground(Color.black);

        nom.setFont(new Font("Georgia", Font.BOLD, 12));
        nom.setForeground(Color.black);

        apepat.setFont(new Font("Georgia", Font.BOLD, 12));
        apepat.setForeground(Color.black);

        apemat.setFont(new Font("Georgia", Font.BOLD, 12));
        apemat.setForeground(Color.black);

        sexo.setFont(new Font("Georgia", Font.BOLD, 12));
        sexo.setForeground(Color.black);

        edad.setFont(new Font("Georgia", Font.BOLD, 12));
        edad.setForeground(Color.black);

        tel.setFont(new Font("Georgia", Font.BOLD, 12));
        tel.setForeground(Color.black);

        noconsulta.setFont(new Font("Georgia", Font.BOLD, 12));
        noconsulta.setForeground(Color.black);

        direccion.setFont(new Font("Georgia", Font.BOLD, 12));
        direccion.setForeground(Color.black);

        delegacion.setFont(new Font("Georgia", Font.BOLD, 12));
        delegacion.setForeground(Color.black);

        colonia.setFont(new Font("Georgia", Font.BOLD, 12));
        colonia.setForeground(Color.black);

        cp.setFont(new Font("Georgia", Font.BOLD, 12));
        cp.setForeground(Color.black);

        delegacion.setFont(new Font("Georgia", Font.BOLD, 12));
        delegacion.setForeground(Color.black);

        estado.setFont(new Font("Georgia", Font.BOLD, 12));
        estado.setForeground(Color.black);

        btnnuevo.setToolTipText("Nuevo registro");
        btnbuscar.setToolTipText("Buscar registro");
        btneliminar.setToolTipText("Eliminar registro");
        btnmodificar.setToolTipText("Modificar registro");
        btnguardar.setToolTipText("Guardar registro");
        btnimprimir.setToolTipText("Imprimir registro");
        btnregresar.setToolTipText("Regresar al menu principal");

        this.add(herramientas, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        agregaABarra();

        ctrlPac.conexion();
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

                    String id = txtid.getText();
                    String nom = txtnom.getText();
                    String apepat = apellidopaterno.getText();
                    String apemat = apellidomaterno.getText();
                    String sexo = box1.getSelectedItem().toString();
                    int edad = Integer.parseInt(txtedad.getText());
                    int tel = Integer.parseInt(txttel.getText());
                    String noconsulta = txtno.getText();
                    String direccion = txtdireccion.getText();
                    String colonia = txtcolonia.getText();
                    String delegacion = txtdelegacion.getText();
                    String estado = txtestado.getText();
                    int cp = Integer.parseInt(txtcp.getText());

                    ctrlPac.insertaPaciente(id, nom, apepat, apemat, sexo, edad, noconsulta,
                            tel, direccion, colonia, cp, delegacion, estado);
                } catch (Exception fi) {
                }
            }
        }
        );

        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscaPaciente();
            }
        }
        );

        btnnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtid.setText("");
                txtnom.setText("");
                apellidopaterno.setText("");
                apellidomaterno.setText("");
                txtdelegacion.setText("");
                txtedad.setText("");
                txttel.setText("");
                txtno.setText("");
                txtdireccion.setText("");
                txtcolonia.setText("");
                txtestado.setText("");
                txtcp.setText("");

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
                String id = txtid.getText();

                if (id.equalsIgnoreCase("") || id.equalsIgnoreCase(" ") || id.equalsIgnoreCase("  ")) {
                    ctrlPac.msgError("La caja de texto est� vac�a");
                } else {
                    buscaEliminaPaciente();
                }
            }
        }
        );

        btnmodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtid.getText().equalsIgnoreCase("") || txtnom.getText().equalsIgnoreCase("")
                        || apellidopaterno.getText().equalsIgnoreCase("") || apellidomaterno.getText().equalsIgnoreCase("")
                        || txtedad.getText().equalsIgnoreCase("")
                        || txttel.getText().equalsIgnoreCase("") || txtno.getText().equalsIgnoreCase("")
                        || txtdireccion.getText().equalsIgnoreCase("") || colonia.getText().equalsIgnoreCase("")
                        || txtdelegacion.getText().equalsIgnoreCase("") || txtestado.getText().equalsIgnoreCase("")
                        || txtcp.getText().equalsIgnoreCase("")) {

                    ctrlPac.msgError("Todos los campos deben contener datos"
                            + "\ncon el formato correspondiente");
                } else {
                    String id = txtid.getText();
                    String nom = txtnom.getText();
                    String apepat = apellidopaterno.getText();
                    String apemat = apellidomaterno.getText();
                    String sexo = box1.getSelectedItem().toString();
                    int edad = Integer.parseInt(txtedad.getText());
                    int tel = Integer.parseInt(txttel.getText());
                    String noconsulta = txtno.getText();
                    String direccion = txtdireccion.getText();
                    String colonia = txtcolonia.getText();
                    String delegacion = txtdelegacion.getText();
                    String estado = txtestado.getText();
                    int cp = Integer.parseInt(txtcp.getText());

                    ctrlPac.actualizaPaciente(id, nom, apepat, apemat, sexo, edad, noconsulta,
                            tel, direccion, colonia, cp, delegacion, estado);
                }
            }
        }
        );
    }

    public void buscaPaciente() {
        try {
            Connection conexion = DriverManager.getConnection(ctrlPac.url);
            PreparedStatement sentencia = conexion.prepareStatement("select * from Paciente where IdPaciente=?");
            sentencia.setString(1, String.valueOf(txtid.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                txtid.setText(resultado.getString("IdPaciente"));
                txtnom.setText(resultado.getString("NombrePaciente"));
                apellidopaterno.setText(resultado.getString("ApellidoPaterno"));
                apellidomaterno.setText(resultado.getString("ApellidoMaterno"));
                box1.setSelectedItem(resultado.getString("Sexo"));
                txtedad.setText(resultado.getString("Edad"));
                txttel.setText(resultado.getString("Telefono"));
                txtno.setText(resultado.getString("NoConsuta"));
                txtdireccion.setText(resultado.getString("CalleNumero"));
                txtcolonia.setText(resultado.getString("Colonia"));
                txtdelegacion.setText(resultado.getString("Delegacion"));
                txtestado.setText(resultado.getString("Estado"));
                txtcp.setText(resultado.getString("CP"));

                resultado.close();
                sentencia.close();
                conexion.close();
            } else {
                ctrlPac.msgError("La clave a buscar no existe");
            }
        } catch (Exception noE) {
            ctrlPac.msgError("La clave a buscar no existe");
        }
    }

    public void buscaEliminaPaciente() {
        try {
            Connection conexion = DriverManager.getConnection(ctrlPac.url);
            PreparedStatement sentencia = conexion.prepareStatement("select * from Paciente where IdPaciente=?");
            sentencia.setString(1, String.valueOf(txtid.getText()));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                txtid.setText(resultado.getString("IdPaciente"));
                txtnom.setText(resultado.getString("NombrePaciente"));
                apellidopaterno.setText(resultado.getString("ApellidoPaterno"));
                apellidomaterno.setText(resultado.getString("ApellidoMaterno"));
                box1.setSelectedItem(resultado.getString("Sexo"));
                txtedad.setText(resultado.getString("Edad"));
                txttel.setText(resultado.getString("Telefono"));
                txtno.setText(resultado.getString("NoConsuta"));
                txtdireccion.setText(resultado.getString("CalleNumero"));
                txtcolonia.setText(resultado.getString("Colonia"));
                txtdelegacion.setText(resultado.getString("Delegacion"));
                txtestado.setText(resultado.getString("Estado"));
                txtcp.setText(resultado.getString("CP"));

                int val = JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el registro actual?",
                        "Paciente", JOptionPane.YES_NO_OPTION);
                if (val == JOptionPane.YES_OPTION) {
                    String id = txtid.getText();
                    ctrlPac.eliminaPaciente(id);

                    txtid.setText("");
                    txtnom.setText("");
                    apellidopaterno.setText("");
                    apellidomaterno.setText("");
                    box1.setSelectedItem("");
                    txtedad.setText("");
                    txttel.setText("");
                    txtno.setText("");
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
                ctrlPac.msgError("La clave a buscar no existe");
            }
        } catch (HeadlessException | SQLException noE) {
            ctrlPac.msgError("La clave a buscar no existe");
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
        new Paciente();
    }

}
