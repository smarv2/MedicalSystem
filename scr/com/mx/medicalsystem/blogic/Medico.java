package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.dao.ctrlMedico;
import com.mx.medicalsystem.util.ConexionMySQL;
import com.mx.medicalsystem.util.Utils;
import com.mx.medicalsystem.vo.MedicosVO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Medico extends JFrame {

    Utils utils = new Utils();
    JPanel panel = new JPanel();

    JLabel id = new JLabel("Clave Medico:");
    JTextField txtid = new JTextField(10);
    JLabel nom = new JLabel("Nombre del medico:");
    JTextField txtnom = new JTextField(10);
    JLabel apepat = new JLabel("Apellido Paterno:");
    JTextField apellidopaterno = new JTextField(10);
    JLabel apemat = new JLabel("Apellido Materno:");
    JTextField apellidomaterno = new JTextField(10);
    JLabel espe = new JLabel("Especialidad:");
    JTextField txtespe = new JTextField(10);
    JLabel tur = new JLabel("Turno:");
    private String[] pa = {"Matutino", "Vespertino", "Nocturno"};
    private JComboBox box1 = new JComboBox(pa);
    JPanel datos = new JPanel();
    JPanel generales = new JPanel();
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
    JLabel tel = new JLabel("Telefono:");
    JTextField txttel = new JTextField(10);
    JLabel cedula = new JLabel("Cedula Profecional:");
    JTextField txtcedula = new JTextField(10);
    JLabel consul = new JLabel("Clave Consultorio:");
    JTextField txtconsul = new JTextField(10);

    private final JToolBar herramientas = new JToolBar();

    private final JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/imagenes/engranes.gif")));
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
    private Border borde1;

    public static ctrlMedico ctrlMedi = new ctrlMedico();

    Medico() {
        super("Administración de Médicos");
        setSize(800, 480);
        setVisible(true);
        setResizable(false);

        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

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

        datos.setBounds(10, 185, 770, 120);
        datos.setLayout(null);

        generales.setBounds(10, 5, 770, 180);
        generales.setLayout(null);

        panel.setLayout(null);
        id.setBounds(new Rectangle(55, 20, 120, 20));
        txtid.setBounds(new Rectangle(150, 20, 50, 20));

        nom.setBounds(new Rectangle(20, 60, 200, 20));
        txtnom.setBounds(new Rectangle(150, 60, 120, 20));
        apepat.setBounds(new Rectangle(280, 60, 200, 20));
        apellidopaterno.setBounds(new Rectangle(400, 60, 120, 20));
        apemat.setBounds(new Rectangle(530, 60, 200, 20));
        apellidomaterno.setBounds(new Rectangle(650, 60, 120, 20));

        espe.setBounds(new Rectangle(60, 100, 200, 20));
        txtespe.setBounds(new Rectangle(150, 100, 120, 20));
        tur.setBounds(new Rectangle(340, 100, 200, 20));
        box1.setBounds(new Rectangle(400, 100, 120, 20));
        //txttur.setBounds(new Rectangle(430,100,50,20));

        cedula.setBounds(new Rectangle(25, 140, 200, 20));
        txtcedula.setBounds(new Rectangle(150, 140, 120, 20));
        tel.setBounds(new Rectangle(575, 140, 200, 20));
        txttel.setBounds(new Rectangle(650, 140, 100, 20));

        direccion.setBounds(new Rectangle(45, 215, 120, 20));
        txtdireccion.setBounds(new Rectangle(150, 215, 120, 20));

        colonia.setBounds(new Rectangle(330, 215, 280, 20));
        txtcolonia.setBounds(new Rectangle(400, 215, 120, 20));

        cp.setBounds(new Rectangle(605, 215, 200, 20));
        txtcp.setBounds(new Rectangle(650, 215, 100, 20));

        consul.setBounds(new Rectangle(525, 100, 200, 20));
        txtconsul.setBounds(new Rectangle(650, 100, 50, 20));

        delegacion.setBounds(new Rectangle(65, 255, 200, 20));
        txtdelegacion.setBounds(new Rectangle(150, 255, 120, 20));

        estado.setBounds(new Rectangle(335, 255, 200, 20));
        txtestado.setBounds(new Rectangle(400, 255, 120, 20));
        imagen.setBounds(new Rectangle(350, 290, 110, 120));
        panel.add(imagen);

        panel.add(id);
        panel.add(txtid);
        panel.add(nom);
        panel.add(txtnom);
        panel.add(apepat);
        panel.add(apellidopaterno);
        panel.add(apemat);
        panel.add(apellidomaterno);
        panel.add(espe);
        panel.add(txtespe);
        panel.add(tur);
        panel.add(box1);
        panel.add(tel);
        panel.add(txttel);
        panel.add(cedula);
        panel.add(txtcedula);
        panel.add(consul);
        panel.add(txtconsul);
        panel.add(colonia);
        panel.add(txtcolonia);
        panel.add(cp);
        panel.add(txtcp);
        panel.add(delegacion);
        panel.add(txtdelegacion);
        panel.add(estado);
        panel.add(txtestado);

        panel.add(direccion);
        panel.add(txtdireccion);
        panel.add(datos);

        panel.add(generales);

        add(panel);

        datos.setFont(new Font("Georgia", Font.BOLD, 14));
        datos.setForeground(Color.blue);

        generales.setFont(new Font("Georgia", Font.BOLD, 14));
        generales.setForeground(Color.blue);

        nom.setFont(new Font("Georgia", Font.BOLD, 12));
        nom.setForeground(Color.black);

        id.setFont(new Font("Georgia", Font.BOLD, 12));
        id.setForeground(Color.black);

        apepat.setFont(new Font("Georgia", Font.BOLD, 12));
        apepat.setForeground(Color.black);

        apemat.setFont(new Font("Georgia", Font.BOLD, 12));
        apemat.setForeground(Color.black);

        espe.setFont(new Font("Georgia", Font.BOLD, 12));
        espe.setForeground(Color.black);

        tur.setFont(new Font("Georgia", Font.BOLD, 12));
        tur.setForeground(Color.black);

        tel.setFont(new Font("Georgia", Font.BOLD, 12));
        tel.setForeground(Color.black);

        cedula.setFont(new Font("Georgia", Font.BOLD, 12));
        cedula.setForeground(Color.black);

        consul.setFont(new Font("Georgia", Font.BOLD, 12));
        consul.setForeground(Color.black);

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
        btnimprimir.setToolTipText("Imprimir registro");
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
                    MedicosVO medicosVO;
                    medicosVO = fillMedicosVO();
                    ctrlMedi.insertaMedico(medicosVO);
                } else {
                    utils.msgError("Debe capturar la informnacion a guardar.");
                }

            }
        }
        );

        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtid.getText().equalsIgnoreCase("")) {
                    buscaMedico();
                } else {
                    utils.msgError("Debe indicar el registro a buscar.");
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

        btneliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = txtid.getText();

                if (id.equalsIgnoreCase("") || id.equalsIgnoreCase(" ") || id.equalsIgnoreCase("  ")) {
                    utils.msgError("Debe indicar la informacion del registro a eliminar.");
                } else {
                    buscaEliminaMedico();
                    limpiaCampos();
                }
            }
        }
        );

        btnmodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtid.getText().equalsIgnoreCase("") || txtnom.getText().equalsIgnoreCase("")
                        || apellidopaterno.getText().equalsIgnoreCase("") || apellidomaterno.getText().equalsIgnoreCase("")
                        || txtespe.getText().equalsIgnoreCase("") || txtdireccion.getText().equalsIgnoreCase("")
                        || txtcolonia.getText().equalsIgnoreCase("") || txtdelegacion.getText().equalsIgnoreCase("")
                        || txtestado.getText().equalsIgnoreCase("") || txtcp.getText().equalsIgnoreCase("")
                        || txttel.getText().equalsIgnoreCase("") || txtcedula.getText().equalsIgnoreCase("")
                        || txtconsul.getText().equalsIgnoreCase("")) {

                    utils.msgError("Todos los campos deben contener datos"
                            + "\ncon el formato correspondiente");
                } else {
                    MedicosVO medicosVO;
                    medicosVO = fillMedicosVO();
                    ctrlMedi.actualizaMedico(medicosVO);
                    limpiaCampos();
                }
            }
        });
    }

    public void buscaMedico() {
        MedicosVO medicosVO;
        String idMedico = txtid.getText();
        medicosVO = ctrlMedi.buscaMedico(Integer.parseInt(idMedico));

        if (medicosVO != null) {
            txtnom.setText(medicosVO.getNombre());
            apellidopaterno.setText(medicosVO.getPatenro());
            apellidomaterno.setText(medicosVO.getMaterno());
            txtespe.setText(medicosVO.getIdEspecialidad() + "");
            box1.setSelectedItem(medicosVO.getIdTurno());
            txtdireccion.setText(medicosVO.getDireccion());
            txtcolonia.setText(medicosVO.getColonia());
            txtdelegacion.setText(medicosVO.getDelegacion());
            txtestado.setText(medicosVO.getEstado());
            txtcp.setText(medicosVO.getCp());
            txttel.setText(medicosVO.getTelefono());
            txtcedula.setText(medicosVO.getCedulaProfecional());
            txtconsul.setText(medicosVO.getIdConsultorio() + "");
        } else {
            utils.msgError("La clave a buscar no existe.");
            limpiaCampos();
        }
    }

    public void buscaEliminaMedico() {

        MedicosVO medicosVO;
        String idMedico = txtid.getText();
        medicosVO = ctrlMedi.buscaMedico(Integer.parseInt(idMedico));

        if (medicosVO != null) {
            int val = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro de Medico seleccionado?",
                    "Eliminacion de Medico.", JOptionPane.YES_NO_OPTION);
            if (val == JOptionPane.YES_OPTION) {
                String id = txtid.getText();
                ctrlMedi.eliminaMedico(id);
            }
        } else {
            utils.msgError("El registro a eliminar no existe.");
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
        new Medico();
    }

    public MedicosVO fillMedicosVO() {
        MedicosVO medicosVO = new MedicosVO();
        medicosVO.setIdMedico(Integer.parseInt(txtid.getText()));
        medicosVO.setNombre(txtnom.getText());
        medicosVO.setPatenro(apellidopaterno.getText());
        medicosVO.setMaterno(apellidomaterno.getText());
        medicosVO.setIdEspecialidad(Integer.parseInt(txtespe.getText()));
        //medicosVO.setIdTurno(Integer.parseInt(box1.getSelectedItem().toString()));
        medicosVO.setIdTurno(box1.getItemCount());
        medicosVO.setDireccion(txtdireccion.getText());
        medicosVO.setColonia(txtcolonia.getText());
        medicosVO.setDelegacion(txtdelegacion.getText());
        medicosVO.setEstado(txtestado.getText());
        medicosVO.setCp(txtcp.getText());
        medicosVO.setTelefono(txttel.getText());
        medicosVO.setCedulaProfecional(txtcedula.getText());
        medicosVO.setIdConsultorio(Integer.parseInt(txtconsul.getText()));
        return medicosVO;
    }

    public void limpiaCampos() {
        txtid.setText("");
        txtnom.setText("");
        apellidopaterno.setText("");
        apellidomaterno.setText("");
        txtespe.setText("");
        txtcedula.setText("");
        txtconsul.setText("");
        txtdelegacion.setText("");
        txttel.setText("");
        txtdireccion.setText("");
        txtcolonia.setText("");
        txtestado.setText("");
        txtcp.setText("");
    }

}
