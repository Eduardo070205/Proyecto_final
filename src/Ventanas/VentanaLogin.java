package Ventanas;
import Recursos.Elementos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class VentanaLogin extends Elementos implements ActionListener {

    JTextField cajaUsuario;

    JPasswordField cajaContrasena;

    JButton btnLogin, btnRestablecer;

    JLabel logo, txtTitulo, txtContra, txtUsuario, txtInicio;

    public VentanaLogin(){

        getContentPane().setLayout(null);

        getContentPane().setBackground(Color.decode("#ffffff"));

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setTitle("Login");

        setSize(600, 600);

        setLocationRelativeTo(null);

        setVisible(true);

        //Widgets

        logo = new JLabel(asignarImagen("./img/Hospital.png", 150, 150));

        asignarPosicion(logo, 0,0,150,150);

        txtTitulo = new JLabel("Wellmeadows Hospital");

        txtTitulo.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));

        asignarPosicion(txtTitulo, 200, 40, 350, 40);

        txtInicio = new JLabel("Iniciar sesión");

        txtInicio.setFont(new Font("Calibri", Font.BOLD, 25));

        asignarPosicion(txtInicio, 20, 160, 200, 30);

        txtUsuario = new JLabel("Usuario (Ingresa tu número de empleado):");

        txtUsuario.setFont(new Font("Calibri", Font.BOLD, 16));

        asignarPosicion(txtUsuario, 20, 200, 300, 20);

        cajaUsuario = new JTextField();

        asignarPosicion(cajaUsuario, 20, 220, 300, 20);

        txtContra = new JLabel("Contraseña:");

        txtContra.setFont(new Font("Calibri", Font.BOLD, 16));

        asignarPosicion(txtContra, 20, 260, 100, 20);

        cajaContrasena = new JPasswordField();

        asignarPosicion(cajaContrasena, 20, 280, 300, 20);

        btnLogin = new JButton("Iniciar sesión");

        btnLogin.addActionListener(this);

        btnLogin.setBackground(Color.decode("#9eb2ff"));

        asignarPosicion(btnLogin, 140, 320, 120, 30);

        btnRestablecer = new JButton("Restablecer");

        btnRestablecer.addActionListener(this);

        btnRestablecer.setBackground(Color.decode("#9eb2ff"));

        asignarPosicion(btnRestablecer, 350, 320, 120, 30);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if(componente == btnRestablecer){

            restablecer(cajaUsuario, cajaContrasena);

        }

        if(componente == btnLogin){

            SwingUtilities.invokeLater(new Runnable() { //Siemnpre agregar ese codigo

                @Override
                public void run() {

                    new VentanaPrincipal();

                }
            });

            this.dispose();

        }

    }
}
