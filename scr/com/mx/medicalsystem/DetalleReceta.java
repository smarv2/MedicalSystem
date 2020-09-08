import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;

public class DetalleReceta extends JFrame{
	JPanel panel = new JPanel();
	
	JLabel idreceta = new JLabel("Clave de receta:");
	JTextField txtidreceta = new JTextField(3);
	JLabel idMed = new JLabel("Clave de medicamento:");
	JTextField txtidMed = new JTextField(10);
	JLabel precio = new JLabel("Precio de venta:");
	JTextField txtprecio= new JTextField(2);
	JLabel cant= new JLabel("Cantidad:");
	JTextField txtcant = new JTextField(2);
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
	
	
	
		DetalleReceta(){
		super("Receta");
		setSize(480,280);
		setVisible(true);
		setResizable(false);
		
		Dimension pantalla,cuadro;
    pantalla=Toolkit.getDefaultToolkit().getScreenSize();
    cuadro=this.getSize();
    this.setLocation(((pantalla.width-cuadro.width)/2),(pantalla.height-cuadro.height)/2);
		
		 borde=BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue ,Color.darkGray);
	Border titulo=BorderFactory.createTitledBorder(borde,"");
	datos.setBorder(titulo);
	
	datos.setBounds(90,15,270,160);
	datos.setLayout(null);
	
    setIconImage(new ImageIcon(DetalleReceta.class.getResource("icono.jpg")).getImage());		
		panel.setLayout(null);
		idreceta.setBounds(new Rectangle(100,25,120,20));
		txtidreceta.setBounds(new Rectangle(265,25,50,20));
		
		idMed.setBounds(new Rectangle(100,65,200,20));
		txtidMed.setBounds(new Rectangle(265,65,50,20));
		precio.setBounds(new Rectangle(100,105,200,20));
		txtprecio.setBounds(new Rectangle(265,105,50,20));
		cant.setBounds(new Rectangle(100,145,200,20));
		txtcant.setBounds(new Rectangle(265,145,50,20));
		
		
		
		panel.add(idreceta);  
		panel.add(txtidreceta);
		panel.add(idMed);
		panel.add(txtidMed);
		panel.add(precio);
		panel.add(txtprecio);
		panel.add(cant);
		panel.add(txtcant);
		panel.add(datos);
		
		idreceta.setFont(new Font("Georgia",Font.BOLD,12));
		idreceta.setForeground(Color.black);
		idMed.setFont(new Font("Georgia",Font.BOLD,12));
		idMed.setForeground(Color.black);
		precio.setFont(new Font("Georgia",Font.BOLD,12));
		precio.setForeground(Color.black);
		cant.setFont(new Font("Georgia",Font.BOLD,12));
		cant.setForeground(Color.black);
		
				add(panel);
		
		
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
}
public void agregaABarra(){
	herramientas.add(btnnuevo);
	herramientas.add(btnbuscar);
	herramientas.add(btneliminar);
	herramientas.add(btnmodificar);
	herramientas.add(btnguardar);
	herramientas.add(btnregresar);
	herramientas.add(btnimprimir);
	
	
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
	    new DetalleReceta();
	
	}	
	
	
}
	
	