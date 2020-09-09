package com.mx.medicalsystem.blogic;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public final class Splash extends JWindow implements Runnable {

    private final JLabel razon = new JLabel("C  A  R  G  A  N  D  O    S  I  S  T  E  M  A  .  .  . ");
    private final JProgressBar bar = new JProgressBar(1, 2000);
    
    private final JLabel lbl1 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/dsicono.jpg")));
    private final JLabel lbl2 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/reloj.gif")));
    private final JLabel lbl3 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/electro.gif")));
    
    int n = 0;

    public Splash() {
        configurarForma();
        setBounds(centrarForma(800, 600));
        setLayout(null);
        setVisible(true);

    }//CONSTRUCTOR

    public void configurarForma() {
        Thread t = new Thread(this);
        // lo arrancamos con XXX.Strart
        t.start();
        Container c = getContentPane();
        lbl1.setBounds(1, 1, 800, 600);
        lbl2.setBounds(650, 75, 80, 80);
        lbl3.setBounds(330, 270, 350, 160);
        c.add(lbl1);
        lbl1.add(lbl3);
        lbl1.add(razon);
        //	l.add(l2);
        razon.setBounds(65, 530, 487, 25);

        razon.setFont(new Font("Arial", Font.BOLD, 17));
        //	c.add(razon);
        bar.setBounds(10, 560, 780, 25);
        bar.setBorderPainted(true);
        bar.setStringPainted(true);
        lbl1.add(bar);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(4);
                bar.setValue(n++);
                if (n > bar.getMaximum()) {
                    this.dispose();
                    //		JOptionPane.showMessageDialog(null,"Sistema Cargado");
                    new Splas();
                    break;
                }
            }

        } catch (InterruptedException err) {
        }
    }

    public Rectangle centrarForma(int x1, int y1) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return new Rectangle((d.width - x1) / 2, (d.height - y1) / 2, x1, y1);
    }

    public static void main(String[] args) {
        MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println("Falló la carga del tema");
            System.out.println(ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new Splash();
    }

}
