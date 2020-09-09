package com.mx.medicalsystem.blogic;

import com.mx.medicalsystem.dao.ctrlEspecialidad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Especialidad extends JFrame{
	JPanel panel = new JPanel();
	
	JLabel id = new JLabel("Clave de especialidad:");
	JTextField txtid = new JTextField(10);
	JLabel descri = new JLabel("Descripcion de especialidad:");
	JTextField txtdescri = new JTextField(10);
	private JLabel imagen = new JLabel (new ImageIcon ("engranes.gif"));
	JPanel datos=new JPanel();
	

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
	
	private final ImageIcon imagen7=new ImageIcon("imprimir.gif");
	private JButton btnimprimir=new JButton(imagen7);
	
	private Border borde;
	public static ctrlEspecialidad ctrlEsp=new ctrlEspecialidad();
	
	
	Especialidad(){
		super("Especialidad");
		setSize(480,320);
		setVisible(true);
		setResizable(false);
		
		Dimension pantalla,cuadro;
    pantalla=Toolkit.getDefaultToolkit().getScreenSize();
    cuadro=this.getSize();
    this.setLocation(((pantalla.width-cuadro.width)/2),(pantalla.height-cuadro.height)/2);
		
	 borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde,"");
	datos.setBorder(titulo);
	
	datos.setBounds(40,10,385,130);
	datos.setLayout(null);
	
   setIconImage(new ImageIcon(Especialidad.class.getResource("icono.jpg")).getImage());		
		
		panel.setLayout(null);
		id.setBounds(new Rectangle(65,30,200,20));
		txtid.setBounds(new Rectangle(250,30,50,20));
		
		descri.setBounds(new Rectangle(65,70,200,20));
		txtdescri.setBounds(new Rectangle(250,70,150,20));
		imagen.setBounds(new Rectangle(180,130,110,120));
		panel.add(imagen);
	
				
		panel.add(id);
		panel.add(txtid);
		panel.add(descri);
		panel.add(txtdescri);
		panel.add(datos);
		
		id.setFont(new Font("Georgia",Font.BOLD,12));
		id.setForeground(Color.black);
		
		descri.setFont(new Font("Georgia",Font.BOLD,12));
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
	    
	    ctrlEsp.conexion();
	    	
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
				String id=txtid.getText();
				String descri=txtdescri.getText();
					
				ctrlEsp.insertaEspecialidad(id, descri);
			}catch(Exception fi){
			}
		}
	}
	);
	
	btnbuscar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			buscaEspecialidad();
		}
	}
	);
	
	btneliminar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String id=txtid.getText();
			
			if(id.equalsIgnoreCase("")||id.equalsIgnoreCase(" ")||id.equalsIgnoreCase("  ")){
				ctrlEsp.msgError("La caja de texto est� vac�a");
			}else{
				buscaEliminaEspecialidad();
			}
		}
	}
	);
	
	
		btnnuevo.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		txtid.setText("");
		txtdescri.setText("");	
			
		}
	});
	
	
	 btnregresar.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		hide();
    	}
    }
    );
	
	
	btnmodificar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(txtid.getText().equalsIgnoreCase("") || txtdescri.getText().equalsIgnoreCase("")){
				ctrlEsp.msgError("Todos los campos deben contener datos" +
				"\ncon el formato correspondiente");
			}else{
				String id=txtid.getText();
				String descri=txtdescri.getText();
				
				
				ctrlEsp.actualizaEspecialidad(id, descri);
			}
		}
	}
	);
}



public void buscaEspecialidad(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlEsp.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Especialidad where IdEspecialidad=?");
		sentencia.setString(1, String.valueOf(txtid.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtdescri.setText(resultado.getString("Descripcion"));
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlEsp.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlEsp.msgError("La clave a buscar no existe");
	}
}

public void buscaEliminaEspecialidad(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlEsp.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Especialidad where IdEspecialidad=?");
		sentencia.setString(1, String.valueOf(txtid.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtdescri.setText(resultado.getString("Descripcion"));
			
			int val=JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el registro actual?",
			"Especialidad", JOptionPane.YES_NO_OPTION);
			if(val==JOptionPane.YES_OPTION){
				String id=txtid.getText();
				ctrlEsp.EliminaEspecialidad(id);
				
				txtid.setText("");
				txtdescri.setText("");
			}
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlEsp.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlEsp.msgError("La clave a buscar no existe");
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
	    new Especialidad();
	
	}	
	
	
}
	
