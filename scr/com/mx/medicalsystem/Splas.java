package com.mx.medicalsystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.metal.*;

public final class Splas extends JWindow implements Runnable {
    //se declara una imagen como JLabel

    private final JLabel label = new JLabel(new ImageIcon(getClass().getResource("/imagenes/ds2.png")));
        
    public Splas() {
        setBounds(centrarForma(665, 420));
        setLayout(new GridLayout(1, 1));
        Container c = getContentPane();
        c.add(label);
        setVisible(true);
        // se declara un hilo Thred nombre del hilo = new Thread (this)
        Thread t = new Thread(this);
        // lo arrancamos con XXX.Strart
        t.start();
    }

    @Override
    public void run() {
        try {
            //enseguida se declara el tiempo de ejecucion de la imagen
            Thread.sleep(6000);
            dispose();
            JOptionPane.showMessageDialog(null, "        MEDICAL SYSTEM ", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            new Seleccion();
        } catch (InterruptedException err) {
        }
        //	JFrame.setDefaultLookAndFeelDecorated(true);
        //  new password().show();
    }

    public Rectangle centrarForma(int x1, int y1) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return new Rectangle((d.width - x1) / 2, (d.height - y1) / 2, x1, y1);

    }

    public static void main(String... s) {
        MetalLookAndFeel.setCurrentTheme(new TemaDigitalStone());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println("Falló la carga del tema");
            System.out.println(ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new Splas().show();

    }
}
