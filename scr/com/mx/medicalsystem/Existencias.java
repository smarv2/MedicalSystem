package com.mx.medicalsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Existencias extends JFrame{
	private JTextField txtIdMedicamento=new JTextField(15);
	private JLabel lblIdMedicamento=new JLabel("Clave del medicamento:");
	private JTextField txtExistencia=new JTextField(10);
	private JLabel lblExistencia=new JLabel("Existencia:");
	JPanel datos=new JPanel();
	
	
	private final JToolBar herramientas=new JToolBar();
	
	private final ImageIcon imagen1=new ImageIcon(getClass().getResource("nuevo.gif"));
	private final ImageIcon imagen2=new ImageIcon(getClass().getResource("buscar.gif"));
	private final ImageIcon imagen3=new ImageIcon(getClass().getResource("eliminar.gif"));
	private final ImageIcon imagen4=new ImageIcon(getClass().getResource("modificar.gif"));
	private final ImageIcon imagen5=new ImageIcon(getClass().getResource("guardar.gif"));
	private final ImageIcon imagen6=new ImageIcon(getClass().getResource("regresar.gif"));
	private final ImageIcon imagen7=new ImageIcon(getClass().getResource("imprimir.gif"));

	private JButton btnimprimir=new JButton(imagen7);
	private JButton btnAltas=new JButton(imagen1);
	private JButton btnConsultas=new JButton(imagen2);
	private JButton btnEliminar=new JButton(imagen3);
	private JButton btnModificar=new JButton(imagen4);
	private JButton btnGuardar=new JButton(imagen5);
	private JButton btnRegresar=new JButton(imagen6);
	private JPanel principal=new JPanel();
	private Border borde;
	
		
	public Existencias(){
    super  ("Existencias");
    setLayout(new BorderLayout());
    setSize(480,260);
    
    setResizable(false);
	Dimension pantalla, cuadro;
    pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    cuadro = this.getSize();
    this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
 
 	borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde,"");
	datos.setBorder(titulo);
	
	datos.setBounds(40,10,385,150);
	datos.setLayout(null);
	
	lblIdMedicamento.setBounds(new Rectangle(100,50,140,20));
  	txtIdMedicamento.setBounds(new Rectangle(240,50,60,20));
		
	lblExistencia.setBounds(new Rectangle(175,90,200,20));
	 	txtExistencia.setBounds(new Rectangle(240,90,60,20));
	
	

	  
    
    principal.setLayout(null);
    principal.add(txtIdMedicamento);
    principal.add(lblIdMedicamento);
    principal.add(txtExistencia);
    principal.add(lblExistencia);
    principal.add(datos);
    
    lblIdMedicamento.setFont(new Font("Georgia",Font.BOLD,12));
	lblIdMedicamento.setForeground(Color.black);
		
	lblExistencia.setFont(new Font("Georgia",Font.BOLD,12));
	lblExistencia.setForeground(Color.black);

	
     	
  	btnAltas.setToolTipText("Nuevo registro");
  	btnConsultas.setToolTipText("Buscar registro");
  	btnEliminar.setToolTipText("Eliminar registro");
  	btnModificar.setToolTipText("Modificar registro");
  	btnGuardar.setToolTipText("Guardar registro");
  	btnimprimir.setToolTipText("Imprimir registro");
  	btnRegresar.setToolTipText("Regresar al menu principal");

  	this.add(herramientas, BorderLayout.NORTH);
  	this.add(principal, BorderLayout.CENTER);
  	
    
    setVisible(true);
	agregaABarra();
	setResizable(false);
	
	//ctrlExis.conexion();
	
	eventos();

}

public void agregaABarra(){
	herramientas.add(btnAltas);
	herramientas.add(btnConsultas);
	herramientas.add(btnEliminar);
	herramientas.add(btnModificar);
	herramientas.add(btnGuardar);
	herramientas.add(btnimprimir);
	herramientas.add(btnRegresar);
	
}
 public void eventos(){
	btnGuardar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{
				String lblIdMedicamento=txtIdMedicamento.getText();
				int existencias=Integer.parseInt(txtExistencias.getText());
				
				ctrlExis.insertaExistencia(idMedicamento, nombreMedicamento, tipoMedicamento,
				precioVenta, entradas, salidas, existencias);
			}catch(Exception fi){
			}
		}
	}
	);
	
	btnConsultas.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			buscaMedicamento();
		}
	}
	);
	
	btnEliminar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String idMedic=txtIdMedicamento.getText();
			
			if(idMedic.equalsIgnoreCase("")||idMedic.equalsIgnoreCase(" ")||idMedic.equalsIgnoreCase("  ")){
				ctrlMed.msgError("La caja de texto est� vac�a");
			}else{
				buscaEliminaMedicamento();
			}
		}
	}
	);
	
	
	 btnRegresar.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		hide();
    	}
    }
    );
	btnModificar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(txtIdMedicamento.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") ||
			txtPrecioVenta.getText().equalsIgnoreCase("") || txtEntradas.getText().equalsIgnoreCase("") ||
			txtSalidas.getText().equalsIgnoreCase("") || txtExistencias.getText().equalsIgnoreCase("")){
				ctrlMed.msgError("Todos los campos deben contener datos" +
				"\ncon el formato correspondiente");
			}else{
				String idMedicamento=txtIdMedicamento.getText();
				String nombreMedicamento=txtNombre.getText();
				String tipoMedicamento=box1.getSelectedItem().toString();
				Double precioVenta=Double.parseDouble(txtPrecioVenta.getText());
				int entradas=Integer.parseInt(txtEntradas.getText());
				int salidas=Integer.parseInt(txtSalidas.getText());
				int existencias=Integer.parseInt(txtExistencias.getText());
				
				ctrlMed.actualizaMedicamentos(idMedicamento, nombreMedicamento, tipoMedicamento, precioVenta,
				entradas, salidas, existencias);
			}
		}
	}
	);
}
public void buscaMedicamento(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlMed.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Medicamento where IdMedicamento=?");
		sentencia.setString(1, String.valueOf(txtIdMedicamento.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtNombre.setText(resultado.getString("NombreMedicamento"));
			box1.setSelectedItem(resultado.getString("TipoMedicamento"));
			txtPrecioVenta.setText(resultado.getString("PrecioVenta"));
			txtEntradas.setText(resultado.getString("Entradas"));
			txtSalidas.setText(resultado.getString("Salidas"));
			txtExistencias.setText(resultado.getString("Existencias"));
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlMed.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlMed.msgError("La clave a buscar no existe");
	}
}

public void buscaEliminaMedicamento(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlMed.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Medicamento where IdMedicamento=?");
		sentencia.setString(1, String.valueOf(txtIdMedicamento.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtNombre.setText(resultado.getString("NombreMedicamento"));
			box1.setSelectedItem(resultado.getString("TipoMedicamento"));
			txtPrecioVenta.setText(resultado.getString("PrecioVenta"));
			txtEntradas.setText(resultado.getString("Entradas"));
			txtSalidas.setText(resultado.getString("Salidas"));
			txtExistencias.setText(resultado.getString("Existencias"));
			
			int val=JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el registro actual?",
			"Medicamentos", JOptionPane.YES_NO_OPTION);
			if(val==JOptionPane.YES_OPTION){
				String idMedic=txtIdMedicamento.getText();
				ctrlMed.eliminaMedicamentos(idMedic);
				
				txtIdMedicamento.setText("");
				txtNombre.setText("");
				txtPrecioVenta.setText("");
				
				txtEntradas.setText("");
				txtSalidas.setText("");
				txtExistencias.setText("");
			}
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlMed.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlMed.msgError("La clave a buscar no existe");
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
	    new Medicamento();
	
	}
}
	
	
	
	

  	