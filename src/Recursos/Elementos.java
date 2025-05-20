package Recursos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Elementos extends JFrame{

    ImageIcon icono;

    Image imagenAjustada;

    ImageIcon iconoAjustado;

    public void restablecer(JComponent... componentes){

        for(JComponent c : componentes){

            if(c instanceof JTextField) {

                ((JTextField) c).setText("");

            }
            if(c instanceof JPasswordField){

                ((JPasswordField) c).setText("");

            }


        }

    }

    public void caracteristicasInternal(JInternalFrame internal){

        internal.setClosable(true);

        internal.setMaximizable(true);

        internal.setIconifiable(true);

        internal.setResizable(false);


    }

    public void agregarAlPanel(JComponent component, JPanel panel,int x, int y, int w, int h) {

        component.setBounds(x, y, w, h);

        panel.add(component);

    }

    public void asignarPosicion(JComponent componente , int x, int y, int w, int h){

        componente.setBounds(x,y,w,h);

        add(componente);

    }

    public ImageIcon asignarImagen(String ruta, int w, int h){

        icono = new ImageIcon(ruta);

        imagenAjustada = icono.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);

        iconoAjustado = new ImageIcon(imagenAjustada);

        return iconoAjustado;

    }

}
