import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.text.*;
import java.util.*;
import java.sql.*;



public class Compras extends JFrame{
	private JTextField txtIdMedicamento=new JTextField(15);
	private JLabel lblIdMedicamento=new JLabel("Clave de medicamento:");
	private JTextField txtIdProveedor=new JTextField(10);
	private JLabel lblIdProveedor=new JLabel("Clave del proveedor:");
	private JTextField txtPrecioCompra=new JTextField(10);
	private JLabel lblPrecioCompra=new JLabel("Precio de compra:");
	private JTextField txtUltimaFecha=new JTextField(10);
	private JLabel lblUltimaFecha =new JLabel("Fecha de compra:");
	private JTextField txtCantidadCompra=new JTextField(10);
	private JLabel lblCantidadCompra=new JLabel ("Cantidad de compra:");
	private JLabel imagen = new JLabel (new ImageIcon ("engranes.gif"));
	JPanel datos=new JPanel();
	JPanel generales=new JPanel();
	

	private final JToolBar herramientas=new JToolBar();
	
	private final ImageIcon imagen1=new ImageIcon(getClass().getResource("nuevo.gif"));
	private final ImageIcon imagen2=new ImageIcon(getClass().getResource("buscar.gif"));
	private final ImageIcon imagen3=new ImageIcon(getClass().getResource("eliminar.gif"));
	private final ImageIcon imagen4=new ImageIcon(getClass().getResource("modificar.gif"));
	private final ImageIcon imagen5=new ImageIcon(getClass().getResource("guardar.gif"));
	private final ImageIcon imagen6=new ImageIcon(getClass().getResource("regresar.gif"));
	private final ImageIcon imagen7=new ImageIcon(getClass().getResource("imprimir.gif"));

	private JButton btnImprimir=new JButton(imagen7);
	private JButton btnAltas=new JButton(imagen1);
	private JButton btnConsultas=new JButton(imagen2);
	private JButton btnEliminar=new JButton(imagen3);
	private JButton btnModificar=new JButton(imagen4);
	private JButton btnGuardar=new JButton(imagen5);
	private JButton btnRegresar=new JButton(imagen6);
	private JPanel principal=new JPanel();
	
	private Border borde;
    private Border borde1;
    
  public static crlCompras ctrlCom=new crlCompras();
	
	public Compras(){
    super  ("Compras");
    setLayout(new BorderLayout());
    setSize(600,400);
    
    setResizable(false);
	Dimension pantalla, cuadro;
    pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    cuadro = this.getSize();
    this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
  
    borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde," Control Compras ");
	datos.setBorder(titulo);
	
	borde1=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo1=BorderFactory.createTitledBorder(borde1," Datos ");
	generales.setBorder(titulo1);
	
	datos.setBounds(10,115,550,110);
	datos.setLayout(null);
	
	generales.setBounds(10,5,550,100);
	generales.setLayout(null);
	
	   
    setIconImage(new ImageIcon(Compras.class.getResource("icono.jpg")).getImage());   
	    
    
    txtIdMedicamento.setBounds(175,25,50,20);
    lblIdMedicamento.setBounds(20,25,160,20); 
    txtIdProveedor.setBounds(175,65,50,20);  
    lblIdProveedor.setBounds(20,65,150,20); 
    txtPrecioCompra.setBounds(175,175,80,20); 
    lblPrecioCompra.setBounds(20,175,150,20); 
    txtUltimaFecha.setBounds(175,135,80,20); 
    lblUltimaFecha.setBounds(20,135,150,20); 
    txtCantidadCompra.setBounds(440,175,55,20);  
    lblCantidadCompra.setBounds(290,175,150,20);
    imagen.setBounds(new Rectangle(250,210,110,120));
	principal.add(imagen);
    
    
    
    principal.add(datos);principal.setLayout(null);
    principal.add(txtIdMedicamento);
    principal.add(lblIdMedicamento);
    principal.add(txtIdProveedor);
    principal.add(lblIdProveedor);
    principal.add(txtPrecioCompra);
    principal.add(lblPrecioCompra);
    principal.add(txtUltimaFecha);
    principal.add(lblUltimaFecha);
    principal.add(txtCantidadCompra);
    principal.add(lblCantidadCompra);
		
	principal.add(generales);
	principal.add(datos);
	
	lblIdMedicamento.setFont(new Font("Georgia",Font.BOLD,12));
	lblIdMedicamento.setForeground(Color.black);
	
	 lblIdProveedor.setFont(new Font("Georgia",Font.BOLD,12));
	 lblIdProveedor.setForeground(Color.black);
	
	lblPrecioCompra.setFont(new Font("Georgia",Font.BOLD,12));
	lblPrecioCompra.setForeground(Color.black);
	
	lblUltimaFecha.setFont(new Font("Georgia",Font.BOLD,12));
	lblUltimaFecha.setForeground(Color.black);
	
	lblCantidadCompra.setFont(new Font("Georgia",Font.BOLD,12));
    lblCantidadCompra.setForeground(Color.black);
	
	   	
  	btnAltas.setToolTipText("Nuevo registro");
  	btnConsultas.setToolTipText("Buscar registro");
  	btnEliminar.setToolTipText("Eliminar registro");
  	btnModificar.setToolTipText("Modificar registro");
  	btnGuardar.setToolTipText("Guardar registro");
  	btnRegresar.setToolTipText("Regresar al menu principal");
  	btnImprimir.setToolTipText("Imprimir registro");


  	this.add(herramientas, BorderLayout.NORTH);
  	this.add(principal, BorderLayout.CENTER);
  	
    
    setVisible(true);
	agregaABarra();
	setResizable(false);
	
	ctrlCom.conexion();
	eventos();

}

public void agregaABarra(){
	herramientas.add(btnAltas);
	herramientas.add(btnConsultas);
	herramientas.add(btnEliminar);
	herramientas.add(btnModificar);
	herramientas.add(btnGuardar);
	herramientas.add(btnImprimir);
	herramientas.add(btnRegresar);
	
}
	

public void eventos(){
	btnGuardar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{
				String lblIdMedicamento=txtIdMedicamento.getText();
				String lblIdProveedor=txtIdProveedor.getText();
				Double lblPrecioCompra=Double.parseDouble(txtPrecioCompra.getText());
				String lblUltimaFecha=txtUltimaFecha.getText();
			    int lblCantidadCompra=Integer.parseInt(txtCantidadCompra.getText());
					
				ctrlCom.insertaCompras(lblIdMedicamento, lblIdProveedor, lblPrecioCompra,
				lblUltimaFecha, lblCantidadCompra);
			}catch(Exception fi){
			}
		}
	}
	);
	
	btnConsultas.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			buscaCompras();
		}
	}
	);
	
	
		btnAltas.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
    	txtIdMedicamento.setText("");
		txtIdProveedor.setText("");
		txtPrecioCompra.setText("");
		txtUltimaFecha.setText("");
		txtCantidadCompra.setText("");
		
		}
	});
	
	 btnRegresar.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		hide();
    	}
    }
    );
	
	
	btnEliminar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String lblIdMedicamento=txtIdMedicamento.getText();
			
			if(lblIdMedicamento.equalsIgnoreCase("")||lblIdMedicamento.equalsIgnoreCase(" ")||lblIdMedicamento.equalsIgnoreCase("  ")){
				ctrlCom.msgError("La caja de texto está vacía");
			}else{
				buscaEliminaCompras();
			}
		}
	}
	);
	
	btnModificar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(txtIdMedicamento.getText().equalsIgnoreCase("") || txtIdProveedor.getText().equalsIgnoreCase("") ||
			txtPrecioCompra.getText().equalsIgnoreCase("") || txtUltimaFecha.getText().equalsIgnoreCase("") ||
	     	txtCantidadCompra.getText().equalsIgnoreCase("") ){
	     		
				ctrlCom.msgError("Todos los campos deben contener datos" +
				"\ncon el formato correspondiente");
			}else{
				String lblIdMedicamento=txtIdMedicamento.getText();
				String lblIdProveedor=txtIdProveedor.getText();
				Double lblPrecioCompra=Double.parseDouble(txtPrecioCompra.getText());
				String lblUltimaFecha=txtUltimaFecha.getText();
			    int lblCantidadCompra=Integer.parseInt(txtCantidadCompra.getText());
					
				ctrlCom.actualizaCompras(lblIdMedicamento, lblIdProveedor,
	            lblPrecioCompra, lblUltimaFecha, lblCantidadCompra);
			}
		}
	}
	);
}
public void buscaCompras(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlCom.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Compras where IdMedicamento=?");
		sentencia.setString(1, String.valueOf(txtIdMedicamento.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtIdProveedor.setText(resultado.getString("IdProveedor"));
			txtPrecioCompra.setText(resultado.getString("PrecioCompra"));
			txtUltimaFecha.setText(resultado.getString("FechaCompra"));
			txtCantidadCompra.setText(resultado.getString("CantidadCompra"));
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlCom.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlCom.msgError("La clave a buscar no existe");
	}
}

public void buscaEliminaCompras(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlCom.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Compras where IdMedicamento=?");
		sentencia.setString(1, String.valueOf(txtIdMedicamento.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			txtIdProveedor.setText(resultado.getString("IdProveedor"));
			txtPrecioCompra.setText(resultado.getString("PrecioCompra"));
			txtUltimaFecha.setText(resultado.getString("FechaCompra"));
			txtCantidadCompra.setText(resultado.getString("CantidadCompra"));
			
			
			int val=JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro actual?",
			"Compras", JOptionPane.YES_NO_OPTION);
			if(val==JOptionPane.YES_OPTION){
				String lblIdMedicamento=txtIdMedicamento.getText();
				ctrlCom.eliminaCompras(lblIdMedicamento);
				
				txtIdMedicamento.setText("");
				txtIdProveedor.setText("");
				txtPrecioCompra.setText("");
				txtUltimaFecha.setText("");
				txtCantidadCompra.setText("");
				
		}
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlCom.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlCom.msgError("La clave a buscar no existe");
	}
}


public static void main(String []args){
  		MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
      try{
         UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      } catch (Exception ex) {
         System.out.println("Falló la carga del tema");
         System.out.println(ex);
      }
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);
	    new Compras();
	
	}
}
	
	
	
	
