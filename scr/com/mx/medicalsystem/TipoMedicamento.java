import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class TipoMedicamento extends JFrame{
	JPanel panel = new JPanel();
	
	JLabel id = new JLabel("Id Tipo Medicamento:");
	JTextField txtid = new JTextField(10);
	JLabel tipopresen = new JLabel("Tipo de Presentacion:");
	JTextField txttipopresen = new JTextField(10);

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
	

	
	TipoMedicamento(){
		super("TIPO DE MEDICAMENTO");
		setSize(480,260);
		setVisible(true);
		setResizable(false);
		
		Dimension pantalla,cuadro;
    pantalla=Toolkit.getDefaultToolkit().getScreenSize();
    cuadro=this.getSize();
    this.setLocation(((pantalla.width-cuadro.width)/2),(pantalla.height-cuadro.height)/2);
		
		
		panel.setLayout(null);
		id.setBounds(new Rectangle(20,20,120,20));
		txtid.setBounds(new Rectangle(160,20,50,20));
		
		tipopresen.setBounds(new Rectangle(20,60,200,20));
		txttipopresen.setBounds(new Rectangle(160,60,150,20));
	
				
		panel.add(id);
		panel.add(txtid);
		panel.add(tipopresen);
		panel.add(txttipopresen);

	
		add(panel);
		
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
	    new TipoMedicamento();
	
	}
}
	
