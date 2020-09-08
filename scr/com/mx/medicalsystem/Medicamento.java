import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;


public class Medicamento extends JFrame{
	private JTextField txtIdMedicamento=new JTextField(15);
	private JLabel lblIdMedicamento=new JLabel("Clave del medicamento:");
	private JTextField txtNombre=new JTextField(10);
	private JLabel lblNombre=new JLabel("Nombre del medicamento:");
	private JTextField txtTipo=new JTextField(10);
	private JLabel lblTipo=new JLabel("Tipo:");
	private String[] pa={"Ampolletas","Jarabe", "Tabletas"};
	private JComboBox box1=new JComboBox(pa);
	
	private JTextField txtPrecioVenta=new JTextField(5);
	private JLabel lblPrecioVenta =new JLabel("Precio de venta:");
	private JTextField txtEntradas=new JTextField(5);
	private JLabel lblEntradas=new JLabel ("Entradas:");
	private JTextField txtSalidas=new JTextField (5);
	private JLabel lblSalidas=new JLabel("Salidas:");
	private JTextField txtExistencias=new JTextField (5);
	private JLabel lblExistencias=new JLabel("Existencias:");
	private JLabel imagen = new JLabel (new ImageIcon ("engranes.gif"));
	private JPanel datos=new JPanel();
	private JPanel generales=new JPanel();
	
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
	private Border borde1;
	
	public static ctrlMedicamentos ctrlMed=new ctrlMedicamentos();
	
	public Medicamento(){
    super  ("Medicamento");
    setLayout(new BorderLayout());
    setSize(600,430);

    setIconImage(new ImageIcon(Medicamento.class.getResource("icono.jpg")).getImage());
    
    	borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde," Control Medicamento ");
	datos.setBorder(titulo);
	
		borde1=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo1=BorderFactory.createTitledBorder(borde1," Descripcion Medicamento ");
	generales.setBorder(titulo1);
	
	datos.setBounds(10,125,570,130);
	datos.setLayout(null);
	
	generales.setBounds(10,5,570,110);
	generales.setLayout(null);
	
	setIconImage(new ImageIcon(Medicamento.class.getResource("icono.jpg")).getImage());    
    setResizable(false);
	Dimension pantalla, cuadro;
    pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    cuadro = this.getSize();
    this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
 
    txtIdMedicamento.setBounds(195,35,50,20);
    lblIdMedicamento.setBounds(20,35,200,20); 
    txtNombre.setBounds(195,75,120,20);  
    lblNombre.setBounds(20,75,200,20); 
    //txtTipo.setBounds(440,75,130,20); 
   	box1.setBounds(new Rectangle(440,75,130,20));
    lblTipo.setBounds(380,75,150,20); 
    	
    txtPrecioVenta.setBounds(195,155,55,20); 
    lblPrecioVenta.setBounds(60,155,150,20); 
    txtEntradas.setBounds(440,155,55,20);  
    lblEntradas.setBounds(345,155,150,20);
    txtSalidas.setBounds(195,195,55,20); 
    lblSalidas.setBounds(60,195,150,20); 
   // btnRegresar.setBounds(390,200,100,45); 
    txtExistencias.setBounds(440,195,55,20); 
    lblExistencias.setBounds(345,195,150,20); 
    imagen.setBounds(new Rectangle(245,240,110,120));
	principal.add(imagen);
    
    principal.setLayout(null);
    principal.add(txtIdMedicamento);
    principal.add(lblIdMedicamento);
    principal.add(txtNombre);
    principal.add(lblNombre);
    principal.add(box1);
    principal.add(lblTipo);
    
    principal.add(txtPrecioVenta);
    principal.add(lblPrecioVenta);
    principal.add(txtEntradas);
    principal.add(lblEntradas);
    principal.add(txtSalidas);
    principal.add(lblSalidas);
    principal.add(txtExistencias);
    principal.add(lblExistencias);
    
    principal.add(datos);
		
		principal.add(generales);
		
		lblIdMedicamento.setFont(new Font("Georgia",Font.BOLD,12));
		lblIdMedicamento.setForeground(Color.black);
		
		lblNombre.setFont(new Font("Georgia",Font.BOLD,12));
		lblNombre.setForeground(Color.black);

	    lblTipo .setFont(new Font("Georgia",Font.BOLD,12));
		lblTipo.setForeground(Color.black);
		
		lblPrecioVenta.setFont(new Font("Georgia",Font.BOLD,12));
		lblPrecioVenta.setForeground(Color.black);

    	lblEntradas.setFont(new Font("Georgia",Font.BOLD,12));
		lblEntradas.setForeground(Color.black);
		
		lblSalidas.setFont(new Font("Georgia",Font.BOLD,12));
		lblSalidas.setForeground(Color.black);

	     lblExistencias.setFont(new Font("Georgia",Font.BOLD,12));
		lblExistencias.setForeground(Color.black);
		
	
	
		
  
  	
  	btnAltas.setToolTipText("Nuevo registro");
  	btnimprimir.setToolTipText("Imprimir registro");
  	btnConsultas.setToolTipText("Buscar registro");
  	btnEliminar.setToolTipText("Eliminar registro");
  	btnModificar.setToolTipText("Modificar registro");
  	btnGuardar.setToolTipText("Guardar registro");
  	btnRegresar.setToolTipText("Regresar al menu principal");

  	this.add(herramientas, BorderLayout.NORTH);
  	this.add(principal, BorderLayout.CENTER);
  	
    
    setVisible(true);
	agregaABarra();
	setResizable(false);
	
	ctrlMed.conexion();
	
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
				String idMedicamento=txtIdMedicamento.getText();
				String nombreMedicamento=txtNombre.getText();
				String tipoMedicamento=box1.getSelectedItem().toString();
				Double precioVenta=Double.parseDouble(txtPrecioVenta.getText());
				int entradas=Integer.parseInt(txtEntradas.getText());
				int salidas=Integer.parseInt(txtSalidas.getText());
				int existencias=Integer.parseInt(txtExistencias.getText());
				
				ctrlMed.insertaMedicamento(idMedicamento, nombreMedicamento, tipoMedicamento,
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
	
	
		btnAltas.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		txtIdMedicamento.setText("");
		txtNombre.setText("");
		txtPrecioVenta.setText("");
		txtEntradas.setText("");
		txtSalidas.setText("");
		txtExistencias.setText("");
		
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
			String idMedic=txtIdMedicamento.getText();
			
			if(idMedic.equalsIgnoreCase("")||idMedic.equalsIgnoreCase(" ")||idMedic.equalsIgnoreCase("  ")){
				ctrlMed.msgError("La caja de texto está vacía");
			}else{
				buscaEliminaMedicamento();
			}
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
			
			int val=JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro actual?",
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
         System.out.println("Falló la carga del tema");
         System.out.println(ex);
      }
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);
	    new Medicamento();
	
	}
}
	
	
	
	
