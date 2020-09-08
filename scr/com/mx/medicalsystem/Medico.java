import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.sql.*;

public class Medico extends JFrame{
	JPanel panel = new JPanel();
	
	JLabel id = new JLabel("Clave Medico:");
	JTextField txtid = new JTextField(10);
	JLabel nom = new JLabel("Nombre del medico:");
	JTextField txtnom = new JTextField(10);
	JLabel apepat = new JLabel("Apellido Paterno:");
	JTextField apellidopaterno = new JTextField(10);
	JLabel apemat = new JLabel("Apellido Materno:");
	JTextField apellidomaterno = new JTextField(10);
	JLabel espe= new JLabel("Especialidad:");
	JTextField txtespe = new JTextField(10);
	JLabel tur = new JLabel("Turno:");
	private String[] pa={"Matutino","Vespertino","Nocturno"};
	private JComboBox box1=new JComboBox(pa);
	JPanel datos=new JPanel();
	JPanel generales=new JPanel();
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
	JLabel consul= new JLabel("Clave Consultorio:");
	JTextField txtconsul= new JTextField(10);
	
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
	private JLabel imagen = new JLabel (new ImageIcon ("engranes.gif"));
	private final ImageIcon imagen7=new ImageIcon(getClass().getResource("imprimir.gif"));

	private JButton btnimprimir=new JButton(imagen7);
	
private Border borde;
private Border borde1;

	public static ctrlMedico ctrlMedi=new ctrlMedico();
	
	Medico(){
		super("Médico");
		setSize(800,480);
		setVisible(true);
		setResizable(false);
		
		 setIconImage(new ImageIcon(Medico.class.getResource("icono.jpg")).getImage());   

		
		Dimension pantalla,cuadro;
    pantalla=Toolkit.getDefaultToolkit().getScreenSize();
    cuadro=this.getSize();
    this.setLocation(((pantalla.width-cuadro.width)/2),(pantalla.height-cuadro.height)/2);
		
		borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde," Direccion ");
	datos.setBorder(titulo);
	
		borde1=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo1=BorderFactory.createTitledBorder(borde1," Datos Generales ");
	generales.setBorder(titulo1);
	
	datos.setBounds(10,185,770,120);
	datos.setLayout(null);
	
	generales.setBounds(10,5,770,180);
	generales.setLayout(null);
	
	
		
		panel.setLayout(null);
		id.setBounds(new Rectangle(55,20,120,20));
		txtid.setBounds(new Rectangle(150,20,50,20));
		
		nom.setBounds(new Rectangle(20,60,200,20));
		txtnom.setBounds(new Rectangle(150,60,120,20));
		apepat.setBounds(new Rectangle(280,60,200,20));
		apellidopaterno.setBounds(new Rectangle(400,60,120,20));
		apemat.setBounds(new Rectangle(530,60,200,20));
		apellidomaterno.setBounds(new Rectangle(650,60,120,20));
		
		espe.setBounds(new Rectangle(60,100,200,20));
		txtespe.setBounds(new Rectangle(150,100,120,20));
		tur.setBounds(new Rectangle(340,100,200,20));
		box1.setBounds(new Rectangle(400,100,120,20));
		//txttur.setBounds(new Rectangle(430,100,50,20));
		
		cedula.setBounds(new Rectangle(25,140,200,20));
		txtcedula.setBounds(new Rectangle(150,140,120,20));
		tel.setBounds(new Rectangle(575,140,200,20));
		txttel.setBounds(new Rectangle(650,140,100,20));
		
		direccion.setBounds(new Rectangle(45,215,120,20));
		txtdireccion.setBounds(new Rectangle(150,215,120,20));
		
		colonia.setBounds(new Rectangle(330,215,280,20));
		txtcolonia.setBounds(new Rectangle(400,215,120,20));
		
		cp.setBounds(new Rectangle(605,215,200,20));
		txtcp.setBounds(new Rectangle(650,215,100,20));
		
		consul.setBounds(new Rectangle(525,100,200,20));
		txtconsul.setBounds(new Rectangle(650,100,50,20));
		
		delegacion.setBounds(new Rectangle(65,255,200,20));
		txtdelegacion.setBounds(new Rectangle(150,255,120,20));
	
		estado.setBounds(new Rectangle(335,255,200,20));
		txtestado.setBounds(new Rectangle(400,255,120,20));
		imagen.setBounds(new Rectangle(350,290,110,120));
		panel.add(imagen);
		
			
		/*altas.setBounds(new Rectangle(90,250,100,30));
		modificar.setBounds(new Rectangle(380,250,100,30));
		bajas.setBounds(new Rectangle(230,250,90,30));
		
		
		buscar.setBounds(new Rectangle(520,250,90,30));
		
		regresar.setBounds(new Rectangle(450,300,100,30));
		limpiar.setBounds(new Rectangle(160,300,100,30));
		
		
		panel.add(altas);
		panel.add(bajas);
		panel.add(modificar);
		panel.add(buscar);
		panel.add(regresar);
		panel.add(limpiar);*/
				
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
		
		datos.setFont(new Font("Georgia",Font.BOLD,14));
		datos.setForeground(Color.blue);
		
		generales.setFont(new Font("Georgia",Font.BOLD,14));
		generales.setForeground(Color.blue);
		
		
		nom.setFont(new Font("Georgia",Font.BOLD,12));
		nom.setForeground(Color.black);
		
		id.setFont(new Font("Georgia",Font.BOLD,12));
		id.setForeground(Color.black);
		
		apepat.setFont(new Font("Georgia",Font.BOLD,12));
		apepat.setForeground(Color.black);
				
		apemat.setFont(new Font("Georgia",Font.BOLD,12));
		apemat.setForeground(Color.black);
		
		espe.setFont(new Font("Georgia",Font.BOLD,12));
		espe.setForeground(Color.black);
		
		tur.setFont(new Font("Georgia",Font.BOLD,12));
		tur.setForeground(Color.black);
		
		tel.setFont(new Font("Georgia",Font.BOLD,12));
		tel.setForeground(Color.black);
		
		cedula.setFont(new Font("Georgia",Font.BOLD,12));
		cedula.setForeground(Color.black);
		
     	consul.setFont(new Font("Georgia",Font.BOLD,12));
		consul.setForeground(Color.black);
		
		colonia.setFont(new Font("Georgia",Font.BOLD,12));
		colonia.setForeground(Color.black);
		
		cp.setFont(new Font("Georgia",Font.BOLD,12));
		cp.setForeground(Color.black);
		
		delegacion.setFont(new Font("Georgia",Font.BOLD,12));
		delegacion.setForeground(Color.black);
		
		estado.setFont(new Font("Georgia",Font.BOLD,12));
		estado.setForeground(Color.black);
		
		direccion.setFont(new Font("Georgia",Font.BOLD,12));
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
    	
    	ctrlMedi.conexion();
	
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
				String id=txtid .getText();
				String nom=txtnom .getText();
				String apepat=apellidopaterno .getText();
				String apemat=apellidomaterno  .getText();
				String espe=txtespe  .getText();
				String tur =box1.getSelectedItem().toString();
			    String direccion=txtdireccion .getText();
				String colonia =txtcolonia  .getText();
				String delegacion=txtdelegacion .getText();
			    String estado=txtestado  .getText();
			    int cp =Integer.parseInt(txtcp.getText());
				int  tel =Integer.parseInt(txttel .getText());
				String cedula=txtcedula  .getText();
			    String consul=txtconsul  .getText();
			    
			    
				ctrlMedi.insertaMedico( id,nom, apepat,apemat,espe,tur,
	            direccion, colonia, delegacion,estado, cp, tel,  cedula, consul);
			}catch(Exception fi){
			}
		}
	}
	);
	
	btnbuscar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			buscaMedico();
		}
	}
	);
	
	
		btnnuevo.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		txtid.setText("");
		txtnom.setText("");
		apellidopaterno.setText("");
		apellidomaterno.setText("");
		txtespe.setText("");
		txtcedula.setText("");
		txtconsul.setText("");
		txtdelegacion.setText("");
//	    txtedad.setText("");
		txttel.setText("");
//		txtno.setText("");
		txtdireccion.setText("");
		txtcolonia.setText("");
		txtestado.setText("");
		txtcp.setText("");
		
	
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
			String id=txtid.getText();
			
			if(id.equalsIgnoreCase("")||id.equalsIgnoreCase(" ")||id.equalsIgnoreCase("  ")){
				ctrlMedi.msgError("La caja de texto está vacía");
			}else{
				buscaEliminaMedico();
			}
		}
	}
	);
	
	btnmodificar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(txtid.getText().equalsIgnoreCase("") || txtnom.getText().equalsIgnoreCase("") ||
	    	apellidopaterno.getText().equalsIgnoreCase("") || apellidomaterno.getText().equalsIgnoreCase("") ||
	    	txtespe.getText().equalsIgnoreCase("") || txtdireccion.getText().equalsIgnoreCase("") ||
			txtcolonia.getText().equalsIgnoreCase("") || txtdelegacion.getText().equalsIgnoreCase("") ||
	    	txtestado .getText().equalsIgnoreCase("") ||txtcp .getText().equalsIgnoreCase("") ||
	    	 txttel .getText().equalsIgnoreCase("") ||txtcedula .getText().equalsIgnoreCase("") || 
	    	 txtconsul .getText().equalsIgnoreCase("")){
				
				ctrlMedi.msgError("Todos los campos deben contener datos" +
				"\ncon el formato correspondiente");
			}else{
				String id=txtid .getText();
				String nom=txtnom .getText();
				String apepat=apellidopaterno .getText();
				String apemat=apellidomaterno  .getText();
				String espe=txtespe  .getText();
				String tur =box1.getSelectedItem().toString();
			    String direccion=txtdireccion .getText();
				String colonia =txtcolonia  .getText();
				String delegacion=txtdelegacion .getText();
			    String estado=txtestado  .getText();
			    int cp =Integer.parseInt(txtcp.getText());
				int  tel =Integer.parseInt(txttel .getText());
				String cedula=txtcedula  .getText();
			    String consul=txtconsul  .getText();
			    
			 
			 	ctrlMedi.actualizaMedico(id,nom, apepat,apemat,espe,tur,
	            direccion, colonia, delegacion,estado, cp, tel,  cedula, consul);
			}
		}
	});
}
public void buscaMedico(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlMedi.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Medico where IdMedico=?");
		sentencia.setString(1, String.valueOf(txtid.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
			//txtid.setText(resultado.getString("IdMedico"));
			txtnom.setText(resultado.getString("NombreMedico"));
			apellidopaterno.setText(resultado.getString("ApellidoPat"));
			apellidomaterno .setText(resultado.getString("ApellidoMat"));
			txtespe .setText(resultado.getString("IdEspecialidad"));
			box1.setSelectedItem(resultado.getString("IdTurno"));
			txtdireccion.setText(resultado.getString("CalleNumero"));
			txtcolonia.setText(resultado.getString("Colonia"));
			txtdelegacion.setText(resultado.getString("Delegacion"));
			txtestado.setText(resultado.getString("Estado"));
			txtcp.setText(resultado.getString("CP"));
			txttel.setText(resultado.getString("Telefono"));
			txtcedula .setText(resultado.getString("Cedula"));
			txtconsul.setText(resultado.getString("IdConsultorio"));
		
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlMedi.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlMedi.msgError("La clave a buscar no existe");
	}
}

public void buscaEliminaMedico(){
	try{
		Connection conexion=DriverManager.getConnection(ctrlMedi.url);
		PreparedStatement sentencia=conexion.prepareStatement("select * from Medico where IdMedico=?");
		sentencia.setString(1, String.valueOf(txtid.getText()));
		ResultSet resultado=sentencia.executeQuery();
		
		if(resultado.next()){
		//	txtid.setText(resultado.getString("IdMedico"));
			txtnom.setText(resultado.getString("NombreMedico"));
			apellidopaterno.setText(resultado.getString("ApellidoPat"));
			apellidomaterno .setText(resultado.getString("ApellidoMat"));
			txtespe .setText(resultado.getString("IdEspecialidad"));
			box1.setSelectedItem(resultado.getString("IdTurno"));
			txtdireccion.setText(resultado.getString("CalleNumero"));
			txtcolonia.setText(resultado.getString("Colonia"));
			txtdelegacion.setText(resultado.getString("Delegacion"));
			txtestado.setText(resultado.getString("Estado"));
			txtcp.setText(resultado.getString("CP"));
			txttel.setText(resultado.getString("Telefono"));
			txtcedula .setText(resultado.getString("Cedula"));
			txtconsul.setText(resultado.getString("IdConsultorio"));
			
			int val=JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro actual?",
			"Medico", JOptionPane.YES_NO_OPTION);
			if(val==JOptionPane.YES_OPTION){
				String id=txtid.getText();
				ctrlMedi.eliminaMedico(id);
				
			txtid.setText("");
			txtnom.setText("");
			apellidopaterno.setText("");
			apellidomaterno .setText("");
			txtespe .setText("");
		//	box1.setSelectedItem("");
			txtdireccion.setText("");
			txtcolonia.setText("");
			txtdelegacion.setText("");
			txtestado.setText("");
			txtcp.setText("");
			txttel.setText("");
			txtcedula .setText("");
			txtconsul.setText("");
			}
			
			resultado.close();
			sentencia.close();
			conexion.close();
		}else{
			ctrlMedi.msgError("La clave a buscar no existe");
		}
	}catch(Exception noE){
		ctrlMedi.msgError("La clave a buscar no existe");
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
	    new Medico();
	
	}	
	
	
}
	
