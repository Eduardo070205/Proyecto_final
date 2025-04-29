package Recursos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Elementos extends JFrame{

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

    public void asignarPosicion(JComponent componente , int x, int y, int w, int h){

        componente.setBounds(x,y,w,h);

        add(componente);

    }

}
