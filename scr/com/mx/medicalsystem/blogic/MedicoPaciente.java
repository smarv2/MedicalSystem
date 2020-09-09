package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.dao.ctrlCitas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;


public class MedicoPaciente extends JFrame{
	JPanel panel = new JPanel();
	
	JLabel idmedico = new JLabel("Clave medico:");
	JTextField txtidmedico = new JTextField(3);
	JLabel idpaciente = new JLabel("Clave paciente:");
	JTextField txtidpaciente = new JTextField(10);
	JLabel fecha = new JLabel("Fecha:");
	JTextField txtfecha=new JTextField(10);
	JLabel horario= new JLabel("Horario:");
	JTextField txthorario= new JTextField(2);
	private JLabel imagen =new JLabel(new ImageIcon ("medico.gif"));
	
	private JPanel datos=new JPanel();
	private JPanel generales=new JPanel();
	
	
	private final JToolBar herramientas=new JToolBar();
	
	private final ImageIcon imagen1=new ImageIcon("nuevo.gif");
	private JButton btnnuevo=new JButton(imagen1);
	
	private final ImageIcon imagen2=new ImageIcon("buscar.gif");
	private JButton btnbuscar=new JButton(imagen2);
	
	private final ImageIcon imagen3=new ImageIcon("eliminar.gif");
	private JButton btneliminar=new JButton(imagen3);
	
	private final ImageIcon imagen4=new ImageIcon("modificar.gif");
	private JButton btnmodificar=new JButton(imagen4);
	
	private final ImageIcon imagen5=new ImageIcon("guardar.gif");
	private JButton btnguardar=new JButton(imagen5);
	
	private final ImageIcon imagen6=new ImageIcon("regresar.gif");
	private JButton btnregresar=new JButton(imagen6);
	
	private final ImageIcon imagen7=new ImageIcon(getClass().getResource("imprimir.gif"));

	private JButton btnimprimir=new JButton(imagen7);
	
	
	private Border borde;
private Border borde1;
	
public static ctrlCitas ctrlcitas=new ctrlCitas();
			
		MedicoPaciente(){
		super("Citas");
		setSize(450,410);
		setVisible(true);
		setResizable(false);
		
		 setIconImage(new ImageIcon(MedicoPaciente.class.getResource("icono.jpg")).getImage());   

		
		Dimension pantalla,cuadro;
    pantalla=Toolkit.getDefaultToolkit().getScreenSize();
    cuadro=this.getSize();
    this.setLocation(((pantalla.width-cuadro.width)/2),(pantalla.height-cuadro.height)/2);
		
			borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde,"");
	datos.setBorder(titulo);
	
		borde1=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo1=BorderFactory.createTitledBorder(borde1," Cita ");
	generales.setBorder(titulo1);
	
	datos.setBounds(50,15,335,100);
	datos.setLayout(null);
	
	generales.setBounds(50,125,335,110);
	generales.setLayout(null);
	
		
		
		panel.setLayout(null);
		idmedico.setBounds(new Rectangle(100,30,120,20));
		txtidmedico.setBounds(new Rectangle(205,30,50,20));
		
		idpaciente.setBounds(new Rectangle(100,70,200,20));
		txtidpaciente.setBounds(new Rectangle(205,70,50,20));
		fecha.setBounds(new Rectangle(100,145,200,20));
		txtfecha.setBounds(new Rectangle(205,145,90,20));
	//	txtdia.setBounds(new Rectangle(140,100,80,20));
		horario.setBounds(new Rectangle(100,185,200,20));
		txthorario.setBounds(new Rectangle(205,185,90,20));
		imagen.setBounds(new Rectangle (170,230,100,100));
 	  	
 	  	panel.add(imagen);
		
		
		panel.add(idmedico);  
		panel.add(txtidmedico);
		panel.add(idpaciente);
		panel.add(txtidpaciente);
		panel.add(fecha);
		panel.add(txtfecha);
		panel.add(horario);
		panel.add(txthorario);
		panel.add(datos);
		panel.add(generales);
		
		add(panel);
		
		idmedico.setFont(new Font("Georgia",Font.BOLD,12));
		idmedico.setForeground(Color.black);
		
		idpaciente.setFont(new Font("Georgia",Font.BOLD,12));
		idpaciente.setForeground(Color.black);
		
		fecha.setFont(new Font("Georgia",Font.BOLD,12));
		fecha.setForeground(Color.black);
		
		horario.setFont(new Font("Georgia",Font.BOLD,12));
		horario.setForeground(Color.black);
		
			
		
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
	
		ctrlcitas.conexion();
	
	eventos();
}
public void agregaABarra(){
	herramientas.add(btnnuevo);
	herramientas.add(btnbuscar);
	herramientas.add(btneliminar);
	herramientas.add(btnmodificar);
	herramientas.add(btnguardar);
	herramientas.add(btnimprimir);
	herramientas.add(btnregresar);
	
}
	

public void eventos(){
	btnguardar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{
				String idmedico=txtidmedico.getText();
				String idpaciente=txtidpaciente.getText();
				String fecha=txtfecha.getText();
			    String horario=txthorario.getText();
				
				ctrlcitas.insertaCitas( idmedico,idpaciente, fecha,horario);
			}catch(Exception fi){
			}
		}
	}
	);
	
	btnbuscar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			buscaCitas();
		}
	}
	);
	
	
		btnnuevo.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		txtidmedico.setText("");
		txtidpaciente.setText("");
		txtfecha.setText("");
		txthorario.setText("");
		
		}
	});
	
	 btnregresar.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		hide();
    	}
    }
    );
	
	
	btneliminar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String idmedico=txtidmedico.getText();
			
			if(idmedico.equalsIgnoreCase("")||idmedico.equalsIgnoreCase(" ")||idmedico.equalsIgnoreCase("  ")){
				ctrlcitas.msgError("La caja de texto est� vac�a");
			}else{
				buscaEliminaCitas();
			}
		}
	}
	);

	btnmodificar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(	txtidmedico.getText().equalsIgnoreCase("") || txtidpaciente.getText().equalsIgnoreCase("") ||
			txtfecha.getText().equalsIgnoreCase("") || txthorario.getText().equalsIgnoreCase("")){
				ctrlcitas.msgError("Todos los campos deben contener datos" +
				"\ncon el formato correspondiente");
			}else{
				String idmedico=txtidmedico.getText();
				String idpaciente=txtidpaciente.getText();
				String fecha=txtfecha.getText();
			    String horario=txthorario.getText();
				
				ctrlcitas.actualizaCitas(idmedico,idpaciente, fecha,horario);
			}
		}
	}
	);
}
public void buscaCitas(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlcitas.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from MedicoPaciente where IdMedico=?");
		sentencia.setString(1, String.valueOf(txtidmedico.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtidpaciente.setText(resultado.getString("IdPaciente"));
			txtfecha.setText(resultado.getString("Fecha"));
			txthorario.setText(resultado.getString("Horario"));
				
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlcitas.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlcitas.msgError("La clave a buscar no existe");
	}
}

public void buscaEliminaCitas(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlcitas.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from MedicoPaciente where IdMedico=?");
		sentencia.setString(1, String.valueOf(txtidmedico.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
	    	txtidpaciente.setText(resultado.getString("IdPaciente"));
			txtfecha.setText(resultado.getString("Fecha"));
			txthorario.setText(resultado.getString("Horario"));
			
	
		int val=JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el registro actual?",
			"MedicoPaciente", JOptionPane.YES_NO_OPTION);
			if(val==JOptionPane.YES_OPTION){
				String idmedico=txtidmedico.getText();
				ctrlcitas.eliminaCitas(idmedico);
				
				
			txtidmedico.setText("");
		    txtidpaciente.setText("");
			txtfecha.setText("");
			txthorario.setText("");
		
			}
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlcitas.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlcitas.msgError("La clave a buscar no existe");
	}
}



 
  	public static void main(String []args){
  		MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
      try{
         UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      } catch (Exception ex) {
         System.out.println("Fall� la carga del tema");
         System.out.println(ex);
      }
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);
	    new MedicoPaciente();
	
	}	
	
	
}


	