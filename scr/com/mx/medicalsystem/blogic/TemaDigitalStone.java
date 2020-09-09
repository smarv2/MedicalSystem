package com.mx.medicalsystem.blogic;

//Creado por matrix the mario
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

public class TemaDigitalStone extends DefaultMetalTheme {

    public String getName() {
        return "DigitalStone";
    }

    //iconos de control 
    private final ColorUIResource primary1 = new ColorUIResource(0, 0, 255);
    //marco interno de ventana y barra de progreso y objetos seleccionados sin clik
    private final ColorUIResource primary2 = new ColorUIResource(0, 0, 255);
    //Frame principal 
    private final ColorUIResource primary3 = new ColorUIResource(255, 255, 255);

    //Borde de objetos
    private final ColorUIResource secondary1 = new ColorUIResource(0, 0, 255);
    //color q toman los botones al ser seleccionados con clik
    private final ColorUIResource secondary2 = new ColorUIResource(0, 0, 255);
    //Fondo del frame
    private final ColorUIResource secondary3 = new ColorUIResource(185, 220, 255);

    //marco externo deobjetos
    private final ColorUIResource black = new ColorUIResource(0, 0, 0);
    //Color para campos PJ cajas de texto y marco interno objetos
    private final ColorUIResource white = new ColorUIResource(255, 255, 255);

    protected ColorUIResource getPrimary1() {
        return primary1;
    }

    protected ColorUIResource getPrimary2() {
        return primary2;
    }

    protected ColorUIResource getPrimary3() {
        return primary3;
    }

    protected ColorUIResource getSecondary1() {
        return secondary1;
    }

    protected ColorUIResource getSecondary2() {
        return secondary2;
    }

    protected ColorUIResource getSecondary3() {
        return secondary3;
    }

    protected ColorUIResource getBlack() {
        return black;
    }

    protected ColorUIResource getWhite() {
        return white;
    }

}
