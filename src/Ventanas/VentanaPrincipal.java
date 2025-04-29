package Ventanas;

import Recursos.Elementos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends Elementos {

    JMenu Menu;

    JLabel logo;

    public  VentanaPrincipal(){

        getContentPane().setLayout(null);

        getContentPane().setBackground(Color.decode("#ffffff"));

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setTitle("Menú Principal");

        setSize(1200, 900);

        setLocationRelativeTo(null);

        setVisible(true);

        ImageIcon icono = new ImageIcon("./img/Hospital.png");

        Image imagenAjustada = icono.getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

        ImageIcon iconoAjustado = new ImageIcon(imagenAjustada);

        logo = new JLabel(iconoAjustado);

        asignarPosicion(logo, 0,0,180,180);


    }

}
