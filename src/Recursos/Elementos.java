package Recursos;

import Controlador.PacienteDAO;
import Modelo.ResultSetTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.*;

public class Elementos extends JFrame{

    LocalDateTime fechaHoy = LocalDateTime.now();

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

                ((JRadioButton) c).setSelected(true);

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

    public boolean validacion(JComponent... componente){

        boolean cajas = false, combos = false;

        int contCajasVacias = 0, contComboVacios = 0;

        for(JComponent c: componente){

            if(c instanceof JTextField){

                if(((JTextField) c).getText().isEmpty() || ((JTextField) c).getText().charAt(0) == ' '){

                    contCajasVacias++;

                }

            }

            if(contCajasVacias == 0){

                cajas = true;

            }else{

                cajas = false;

            }

            if( c instanceof JComboBox){

                if(((JComboBox<?>) c).getSelectedIndex() == 0){

                    contComboVacios++;

                }
            }

            if(contComboVacios == 0){

                combos = true;

            }else{

                combos = false;

            }

        }

        if((cajas && combos)){

            return true;

        }else{

            return false;

        }

    }

    public boolean validarFecha(int dia, int mes, int año){

        if(dia <= fechaHoy.getDayOfMonth() && mes <= fechaHoy.getMonthValue() && año <= fechaHoy.getYear()){

            return true;

        }else {

            return false;

        }


    }

}
