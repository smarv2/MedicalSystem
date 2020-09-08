import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class Recetas extends JFrame{
	JPanel panel = new JPanel();
	
	JLabel idreceta = new JLabel("Id Receta:");
	JTextField txtidreceta = new JTextField(3);
	JLabel idMed = new JLabel("Id Medico:");
	JTextField txtidMed = new JTextField(10);
	JLabel idpaciente = new JLabel("Id Paciente:");
	JTextField txtidpaciente= new JTextField(2);
	JLabel fechareceta = new JLabel("Fecha Receta:");
	JTextField txtfechareceta = new JTextField(2);
	
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
	
	
		Recetas(){
		super("RECETAS");
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		
		Dimension pantalla,cuadro;
    pantalla=Toolkit.getDefaultToolkit().getScreenSize();
    cuadro=this.getSize();
    this.setLocation(((pantalla.width-cuadro.width)/2),(pantalla.height-cuadro.height)/2);
		
		
		panel.setLayout(null);
		idreceta.setBounds(new Rectangle(40,20,120,20));
		txtidreceta.setBounds(new Rectangle(130,20,50,20));
		
		idMed.setBounds(new Rectangle(40,60,200,20));
		txtidMed.setBounds(new Rectangle(130,60,50,20));
		idpaciente.setBounds(new Rectangle(40,100,200,20));
		txtidpaciente.setBounds(new Rectangle(130,100,50,20));
		fechareceta.setBounds(new Rectangle(40,140,200,20));
		txtfechareceta.setBounds(new Rectangle(130,140,50,20));
		
		
		
		panel.add(idreceta);
		panel.add(txtidreceta);
		panel.add(idMed);
		panel.add(txtidMed);
		panel.add(idpaciente);
		panel.add(txtidpaciente);
		panel.add(fechareceta);
		panel.add(txtfechareceta);
		
		add(panel);
		
		idreceta.setFont(new Font("Georgia",Font.BOLD,12));
		idreceta.setForeground(Color.black);
		
		idMed.setFont(new Font("Georgia",Font.BOLD,12));
		idMed.setForeground(Color.black);
		
		idpaciente.setFont(new Font("Georgia",Font.BOLD,12));
		idpaciente.setForeground(Color.black);
		
		fechareceta.setFont(new Font("Georgia",Font.BOLD,12));
		fechareceta.setForeground(Color.black);
		
		btnnuevo.setToolTipText("Nuevo registro");
		btnbuscar.setToolTipText("Buscar registro");
		btneliminar.setToolTipText("Eliminar registro");
		btnmodificar.setToolTipText("Modificar registro");
		btnguardar.setToolTipText("Guardar registro");
		btnregresar.setToolTipText("Regresar al menu principal");
		
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
	    new Recetas();
	
	}	
	
	
}
	
	