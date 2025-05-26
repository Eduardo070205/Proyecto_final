package Recursos;

import Controlador.PacienteDAO;
import Modelo.ResultSetTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
            if(c instanceof JComboBox<?>){

                ((JComboBox<?>) c).setSelectedIndex(0);

            }
            if(c instanceof JRadioButton){

                ((JRadioButton) c).setSelected(false);

            }


        }

    }



    public void caracteristicasInternal(JInternalFrame internal){

        internal.setDefaultCloseOperation(HIDE_ON_CLOSE);

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

    public void actualizarTabla(JTable tabla) {

        final String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";

        final String URL = "jdbc:mysql://localhost:3306/bd_hospital_topicos_proyecto_final";

        final String CONSULTA = "SELECT * FROM Pacientes";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);

            tabla.setModel(modelo);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

    }

}
